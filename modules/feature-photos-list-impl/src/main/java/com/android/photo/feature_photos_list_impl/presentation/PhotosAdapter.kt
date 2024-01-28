package com.android.photo.feature_photos_list_impl.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.WindowManager
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.android.photo.picker.R
import com.android.photo.picker.databinding.ItemPhotoBinding
import com.bumptech.glide.Glide

internal class PhotosDiffUtils :
    DiffUtil.ItemCallback<PhotoItem>() {
    override fun areItemsTheSame(oldItem: PhotoItem, newItem: PhotoItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: PhotoItem, newItem: PhotoItem): Boolean {
        return oldItem == newItem
    }
}

internal class PhotosAdapter(
    private val onClick: (Int) -> Unit,
) : ListAdapter<PhotoItem, PhotosAdapter.VH>(PhotosDiffUtils()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val inflater = LayoutInflater.from(parent.context)
        return VH(ItemPhotoBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(getItem(position))
    }

    inner class VH(private val binding: ItemPhotoBinding) : ViewHolder(binding.root) {

        init {
            binding.ivPhoto.setOnClickListener {
                onClick(adapterPosition)
            }
        }

        fun bind(item: PhotoItem) {
            with(binding) {
                Glide.with(ivPhoto)
                    .load(item.imageUrl)
                    .fallback(R.drawable.ic_image_load_failed)
                    .centerCrop()
                    .into(binding.ivPhoto)
            }
        }
    }
}

internal data class PhotoItem(
    val id: String,
    val imageUrl: String,
)
