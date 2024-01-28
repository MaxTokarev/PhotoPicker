package com.android.photo.feature_photo_detail_impl.di

import com.android.photo.feature_photo_detail_api.FeaturePhotoDetailApi
import com.android.photo.feature_photo_detail_impl.FeaturePhotoDetailImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal class PhotoDetailModule {

    @Provides
    fun provideAddTransactionFeature(): FeaturePhotoDetailApi = FeaturePhotoDetailImpl()
}
