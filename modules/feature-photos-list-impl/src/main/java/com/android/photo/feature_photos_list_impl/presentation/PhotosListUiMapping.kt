package com.android.photo.feature_photos_list_impl.presentation

import com.android.photo.feature_photos_list_impl.domain.Photo

internal fun Photo.toUi(url: String): PhotoItem {
    return PhotoItem(id = id, imageUrl = url)
}
