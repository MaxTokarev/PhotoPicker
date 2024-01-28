package com.android.photo.feature_photo_detail_api

import com.github.terrakok.cicerone.Screen

interface FeaturePhotoDetailApi {

    fun screen(photoUrl: String): Screen
}
