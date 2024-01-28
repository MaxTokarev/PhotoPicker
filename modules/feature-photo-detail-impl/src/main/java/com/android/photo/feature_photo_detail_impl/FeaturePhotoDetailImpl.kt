package com.android.photo.feature_photo_detail_impl

import com.android.photo.feature_photo_detail_api.FeaturePhotoDetailApi
import com.android.photo.feature_photo_detail_impl.presentation.PhotoDetailFragment
import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen
import javax.inject.Inject

class FeaturePhotoDetailImpl @Inject constructor() : FeaturePhotoDetailApi {

    override fun screen(photoUrl: String): Screen {
        return FragmentScreen { PhotoDetailFragment.newInstance(photoUrl) }
    }
}
