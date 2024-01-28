package com.android.photo.feature_photos_list_impl.domain

import kotlinx.coroutines.flow.Flow

internal interface PhotosRepository {

    fun getAllPhotos(): Flow<List<Photo>>
}
