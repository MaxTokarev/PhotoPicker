package com.android.photo.feature_photos_list_impl.presentation

internal data class PhotosListState(
    val isLoading: Boolean = true,
    val photos: List<PhotoItem> = emptyList(),
)
