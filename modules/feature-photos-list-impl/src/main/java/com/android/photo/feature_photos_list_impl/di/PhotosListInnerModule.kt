package com.android.photo.feature_photos_list_impl.di

import com.android.photo.feature_photos_list_impl.data.api.PhotosRemoteDataSource
import com.android.photo.feature_photos_list_impl.data.repository.PhotosRepositoryImpl
import com.android.photo.feature_photos_list_impl.domain.GetPhotosUseCase
import com.android.photo.feature_photos_list_impl.domain.GetPhotosUseCaseImpl
import com.android.photo.feature_photos_list_impl.domain.PhotosRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import de.jensklingenberg.ktorfit.Ktorfit
import io.ktor.client.HttpClient
import io.ktor.client.plugins.defaultRequest
import io.ktor.http.parameters

@Module
@InstallIn(ViewModelComponent::class)
internal interface PhotosListInnerModule {

    @Binds
    fun bindRepository(impl: PhotosRepositoryImpl): PhotosRepository

    @Binds
    fun bindUseCase(impl: GetPhotosUseCaseImpl): GetPhotosUseCase


    companion object {

        @Provides
        fun remoteDataSource(): PhotosRemoteDataSource {
            // todo move out creating ktorfit
            val httpClient = HttpClient {
                defaultRequest {
                    this.url {
                        parameters {
                            this.append("api_key", "da9d38d3dee82ec8dda8bb0763bf5d9c")
                        }
                    }
                }
            }

            val ktorfit = Ktorfit.Builder()
                .baseUrl("https://api.flickr.com/")
                .httpClient(httpClient)
                .build()

            return ktorfit.create()
        }
    }
}
