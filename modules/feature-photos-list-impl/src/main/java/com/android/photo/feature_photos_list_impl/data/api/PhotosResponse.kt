package com.android.photo.feature_photos_list_impl.data.api

data class PhotosResponse(
    val page: Int,
    val pages: Int,
    val perpage: Int,
    val photo: List<PhotoResponse>,
    val total: Int
)
