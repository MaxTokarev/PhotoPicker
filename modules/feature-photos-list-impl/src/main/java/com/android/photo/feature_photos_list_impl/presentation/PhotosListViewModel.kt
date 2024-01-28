package com.android.photo.feature_photos_list_impl.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.photo.feature_photos_list_impl.domain.GetPhotosUseCase
import com.android.photo.feature_photos_list_impl.domain.Photo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
internal class PhotosListViewModel @Inject constructor(
    private val getPhotosUseCase: GetPhotosUseCase,
    private val urlFormatter: PhotoUrlFormatter
) : ViewModel() {

    private val _state = MutableStateFlow(value = PhotosListState())
    val state: StateFlow<PhotosListState> = _state.asStateFlow()

    init {
        observePhotos()
    }

    private fun observePhotos() {
        getPhotosUseCase()
            .onEach { photos -> updateList(photos) }
            .catch { } // todo add handler
            .flowOn(Dispatchers.IO) // todo move out dispatcher for testing
            .launchIn(viewModelScope)
    }

    private suspend fun updateList(photos: List<Photo>) {
        val newState = _state.value.copy(
            isLoading = false,
            photos = photos.map { photo -> photo.toUi(urlFormatter.getUrl(photo)) },
        )
        _state.emit(newState)
    }

    fun onPhotoClicked(position: Int) {
        // todo setup logic
    }
}
