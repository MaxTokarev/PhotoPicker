package com.android.photo.feature_photos_list_impl.di

import android.content.Context
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.android.photo.feature_photos_list_impl.data.api.PhotosRemoteDataSource
import com.android.photo.feature_photos_list_impl.data.db.PhotosDao
import com.android.photo.feature_photos_list_impl.data.db.PhotosDaoImpl
import com.android.photo.feature_photos_list_impl.data.repository.PhotosRepositoryImpl
import com.android.photo.feature_photos_list_impl.domain.GetPhotosUseCase
import com.android.photo.feature_photos_list_impl.domain.GetPhotosUseCaseImpl
import com.android.photo.feature_photos_list_impl.domain.PhotosRepository
import com.android.photo.picker.PhotosDatabase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import de.jensklingenberg.ktorfit.Ktorfit
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json

@Module
@InstallIn(ViewModelComponent::class)
internal interface PhotosListInnerModule {

    @Binds
    fun bindRepository(impl: PhotosRepositoryImpl): PhotosRepository

    @Binds
    fun bindUseCase(impl: GetPhotosUseCaseImpl): GetPhotosUseCase

    @Binds
    fun bindPhotosDao(impl: PhotosDaoImpl): PhotosDao


    companion object {
        @Provides
        fun remoteDataSource(): PhotosRemoteDataSource {
            // todo move out creating ktorfit
            val httpClient = HttpClient {
                defaultRequest {
                    url {
                        encodedParameters = parameters.apply {
                            append("api_key", "da9d38d3dee82ec8dda8bb0763bf5d9c")
                            append("format", "json")
                            append("nojsoncallback", "1")
                        }
                    }
                }
                install(ContentNegotiation) {
                    json(contentType = ContentType.Any)
                }
            }

            val ktorfit = Ktorfit.Builder()
                .baseUrl("https://api.flickr.com/")
                .httpClient(httpClient)
                .build()

            return ktorfit.create()
        }

        @Provides
        fun provideDB(@ApplicationContext context: Context): PhotosDatabase {
            val driver = AndroidSqliteDriver(
                schema = PhotosDatabase.Schema,
                context = context,
                name = "photos.db"
            )
            return PhotosDatabase(driver)
        }
    }
}
