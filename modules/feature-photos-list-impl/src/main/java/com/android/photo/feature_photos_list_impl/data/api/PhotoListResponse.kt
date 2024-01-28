package com.android.photo.feature_photos_list_impl.data.api

import kotlinx.serialization.Serializable

@Serializable
internal data class PhotoListResponse(
    val photos: PhotosResponse,
    val stat: String
)
