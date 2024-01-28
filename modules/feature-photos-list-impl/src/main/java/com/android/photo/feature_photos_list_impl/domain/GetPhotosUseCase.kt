package com.android.photo.feature_photos_list_impl.domain

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

internal interface GetPhotosUseCase : () -> Flow<List<Photo>>

internal class GetPhotosUseCaseImpl @Inject constructor(
    private val repository: PhotosRepository,
) : GetPhotosUseCase {

    override fun invoke(): Flow<List<Photo>> {
        return repository.getAllPhotos()
            .map { photos -> photos.takeLast(LAST_PHOTOS_COUNT) }
    }

    private companion object {
        const val LAST_PHOTOS_COUNT = 20
    }
}
