package com.android.photo.feature_photos_list_impl.presentation

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
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
        viewModel.state.collectOnResumed(::render)

        with(binding) {
            rvPhotos.adapter = photosAdapter
            rvPhotos.layoutManager = GridLayoutManager(requireContext(), 2)
        }
    }

    private fun render(state: PhotosListState) {
        Log.e("asdf", "render: ${state}")
        photosAdapter.submitList(state.photos)
        with(binding) {
            rvPhotos.isVisible = !state.isLoading
            loader.isVisible = state.isLoading
        }
    }
}
