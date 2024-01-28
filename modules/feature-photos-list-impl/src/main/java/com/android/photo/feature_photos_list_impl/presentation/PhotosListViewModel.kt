package com.android.photo.feature_photos_list_impl.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.photo.feature_photos_list_impl.domain.GetPhotosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
internal class PhotosListViewModel @Inject constructor(
    private val getPhotosUseCase: GetPhotosUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow(value = PhotosListState())
    val state: StateFlow<PhotosListState> = _state.asStateFlow()

    init {
        getPhotosUseCase()
            .map {
                _state.emit(
                    _state.value.copy(
                        isLoading = false,
                        it.map { it.toUi() })
                )
            } // todo refactor
            .flowOn(Dispatchers.IO) // todo move out dispatcher for testing
            .launchIn(viewModelScope)
    }

    fun onPhotoClicked(position: Int) {
        // todo setup logic
    }
}
