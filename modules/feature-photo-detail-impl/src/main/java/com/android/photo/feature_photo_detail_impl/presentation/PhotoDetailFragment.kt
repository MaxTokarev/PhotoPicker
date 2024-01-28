package com.android.photo.feature_photo_detail_impl.presentation

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.android.photo.detail.R
import com.android.photo.detail.databinding.FragmentPhotoDetailBinding
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
internal class PhotoDetailFragment : Fragment(R.layout.fragment_photo_detail) {

    private val binding by viewBinding(FragmentPhotoDetailBinding::bind)
    private val photoUrl by lazy(LazyThreadSafetyMode.NONE) {
        requireArguments().getString(ARG_PHOTO_URL)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            Glide.with(requireContext())
                .load(photoUrl)
                .into(ivDetailPhoto)
        }
    }

    companion object {
        private const val ARG_PHOTO_URL = "ARG_PHOTO_URL"

        fun newInstance(photoUrl: String) = PhotoDetailFragment().apply {
            arguments = bundleOf(ARG_PHOTO_URL to photoUrl)
        }
    }
}
