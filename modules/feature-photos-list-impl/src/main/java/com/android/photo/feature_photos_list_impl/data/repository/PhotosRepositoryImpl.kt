package com.android.photo.feature_photos_list_impl.data.repository

import com.android.photo.feature_photos_list_impl.data.api.PhotosRemoteDataSource
import com.android.photo.feature_photos_list_impl.domain.Photo
import com.android.photo.feature_photos_list_impl.domain.PhotosRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

internal class PhotosRepositoryImpl @Inject constructor(
    private val remoteDataSource: PhotosRemoteDataSource,
) : PhotosRepository {

    override fun getAllPhotos(): Flow<List<Photo>> {
        // todo setup logic with caching
        return flow {
            remoteDataSource.getPhotos().photos.photo
                .map { photoResponse -> photoResponse.toDomain() }
                .also { emit(it) }
        }
    }
}
