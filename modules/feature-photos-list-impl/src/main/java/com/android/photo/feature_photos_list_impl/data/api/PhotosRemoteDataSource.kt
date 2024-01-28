package com.android.photo.feature_photos_list_impl.data.api

import com.android.photo.feature_photos_list_impl.domain.Photo
import de.jensklingenberg.ktorfit.http.GET

internal interface PhotosRemoteDataSource {

    @GET("services/rest/?method=flickr.photos.getRecent")
    suspend fun getPhotos(): PhotoListResponse
}
