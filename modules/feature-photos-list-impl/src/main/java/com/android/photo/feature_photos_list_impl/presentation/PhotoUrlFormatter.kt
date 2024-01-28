package com.android.photo.feature_photos_list_impl.presentation

import com.android.photo.feature_photos_list_impl.domain.Photo
import javax.inject.Inject

internal class PhotoUrlFormatter @Inject constructor() {

    fun getUrl(photo: Photo): String {
        return "$DEFAULT_URL${photo.server}/${photo.id}_${photo.secret}_b.jpg"
    }

    private companion object {
        const val DEFAULT_URL = "https://live.staticflickr.com/"
    }
}
