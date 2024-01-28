package com.android.photo.feature_photos_list_impl.domain

import kotlinx.coroutines.flow.Flow

internal interface GetPhotosUseCase : () -> Flow<List<Photo>>

internal class GetPhotosUseCaseImpl(
    private val repository: PhotosRepository,
) : GetPhotosUseCase {

    override fun invoke(): Flow<List<Photo>> {
        return repository.getAllPhotos()
    }
}
