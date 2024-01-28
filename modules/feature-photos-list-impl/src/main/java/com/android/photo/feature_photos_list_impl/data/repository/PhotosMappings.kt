package com.android.photo.feature_photos_list_impl.data.repository

import com.android.photo.feature_photos_list_impl.data.api.PhotoResponse
import com.android.photo.feature_photos_list_impl.domain.Photo

internal fun PhotoResponse.toDomain(): Photo {
    return Photo(
        id = id,
        secret = secret,
        server = server
    )
}
