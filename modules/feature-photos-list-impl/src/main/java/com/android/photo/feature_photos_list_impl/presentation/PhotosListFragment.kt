package com.android.photo.feature_photos_list_impl.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.android.photo.picker.R
import com.android.photo.picker.databinding.FragmentPhotosListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
internal class PhotosListFragment : Fragment(R.layout.fragment_photos_list) {

    private val binding by viewBinding(FragmentPhotosListBinding::bind)
    private val viewModel: PhotosListViewModel by viewModels()
    private val photosAdapter: PhotosAdapter by lazy(LazyThreadSafetyMode.NONE) {
        PhotosAdapter(onClick = viewModel::onPhotoClicked)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            rvPhotos.adapter = photosAdapter
        }
    }

    private fun render(state: PhotosListState) {
        with(binding) {
            photosAdapter.submitList(state.photos)
        }
    }
}
