package com.android.photo.feature_photos_list_impl.presentation

import androidx.annotation.StringRes

internal data class PhotosListState(
    val isLoading: Boolean = true,
    val photos: List<PhotoItem> = emptyList(),
)

internal sealed interface PhotosListSideEffects {

    class ShowError(@StringRes val cause: Int) : PhotosListSideEffects
}
