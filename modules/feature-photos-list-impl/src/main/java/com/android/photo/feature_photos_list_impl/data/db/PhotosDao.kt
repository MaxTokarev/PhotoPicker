package com.android.photo.feature_photos_list_impl.data.db

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import com.android.photo.feature_photos_list_impl.domain.Photo
import com.android.photo.picker.PhotosDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

internal interface PhotosDao {

    suspend fun getAllPhotos(): Flow<List<Photo>>
    suspend fun insertPhoto(photo: Photo)
}

internal class PhotosDaoImpl @Inject constructor(
    private val database: PhotosDatabase,
) : PhotosDao {

    override suspend fun getAllPhotos(): Flow<List<Photo>> {
        return database.userTransactionQueries.selectAll()
            .asFlow()
            .mapToList(Dispatchers.Default)
            .map { photos -> photos.map { Photo(it.id, it.secret, it.server) } }
    }

    override suspend fun insertPhoto(photo: Photo) {
        withContext(Dispatchers.IO) { // todo move out dispatchers
            database.userTransactionQueries.insert(photo.id, photo.secret, photo.server)
        }
    }
}
