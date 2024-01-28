package com.android.photo.feature_photos_list_impl

import com.android.photo.feature_photos_list_api.FeaturePhotosListApi
import com.android.photo.feature_photos_list_impl.presentation.PhotosListFragment
import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen


internal class FeaturePhotosListImpl : FeaturePhotosListApi {

    override val screen: Screen
        get() = FragmentScreen { PhotosListFragment() }
}
