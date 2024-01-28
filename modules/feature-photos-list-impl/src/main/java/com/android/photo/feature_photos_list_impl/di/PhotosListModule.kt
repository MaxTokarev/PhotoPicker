package com.android.photo.feature_photos_list_impl.di

import com.android.photo.feature_photos_list_api.FeaturePhotosListApi
import com.android.photo.feature_photos_list_impl.FeaturePhotosListImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal class PhotosListModule {

    @Provides
    fun provideAddTransactionFeature(): FeaturePhotosListApi = FeaturePhotosListImpl()
}
