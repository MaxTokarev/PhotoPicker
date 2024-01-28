package com.android.photo.feature_photos_list_impl.data.api

import kotlinx.serialization.Serializable

@Serializable
internal data class PhotoResponse(
    val farm: Int,
    val id: String,
    val isfamily: Int,
    val isfriend: Int,
    val ispublic: Int,
    val owner: String,
    val secret: String,
    val server: String,
    val title: String
)
