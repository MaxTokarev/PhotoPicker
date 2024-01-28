package com.android.photo.feature_photos_list_impl.data.api

import de.jensklingenberg.ktorfit.http.GET

internal interface PhotosRemoteDataSource {

    // todo move out to interceptor
    @GET("services/rest/?method=flickr.photos.getRecent&api_key=da9d38d3dee82ec8dda8bb0763bf5d9c&format=json&nojsoncallback=1")
    suspend fun getPhotos(): PhotoListResponse
}
