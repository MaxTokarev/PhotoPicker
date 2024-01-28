package com.android.photo.feature_photos_list_impl.data.repository

import com.android.photo.feature_photos_list_impl.data.api.PhotosRemoteDataSource
import com.android.photo.feature_photos_list_impl.data.db.PhotosDao
import com.android.photo.feature_photos_list_impl.domain.Photo
import com.android.photo.feature_photos_list_impl.domain.PhotosRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

internal class PhotosRepositoryImpl @Inject constructor(
    private val remoteDataSource: PhotosRemoteDataSource,
    private val photosDao: PhotosDao,
) : PhotosRepository {

    override fun getAllPhotos(): Flow<List<Photo>> {
        // todo mb make it with single source of truth
        return flow {
            val dbPhotos = runCatching { photosDao.getAllPhotos().firstOrNull() }
                .getOrNull()
                .orEmpty()
            if (dbPhotos.isEmpty()) {
                loadAndSavePhotos()
            } else {
                emit(dbPhotos)
                loadAndSavePhotos()
            }
        }
    }

    private suspend fun FlowCollector<List<Photo>>.loadAndSavePhotos() {
        val remotePhotos = remoteDataSource.getPhotos().photos.photo
            .map { photoResponse -> photoResponse.toDomain() }
            .onEach { photo -> photosDao.insertPhoto(photo) }

        emit(remotePhotos)
    }
}
