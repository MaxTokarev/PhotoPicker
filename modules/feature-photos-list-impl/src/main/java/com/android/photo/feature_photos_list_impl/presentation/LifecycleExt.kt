package com.android.photo.feature_photos_list_impl.presentation

import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.launch

// todo move out to core module
context(Fragment)
fun <T> Flow<T>.collectOnResumed(collector: FlowCollector<T>) {
    collectOnLifecycle(state = Lifecycle.State.RESUMED, collector = collector)
}

/**
 * Needs for collection flows in ui
 */
context(Fragment)
fun <T> Flow<T>.collectOnLifecycle(
    state: Lifecycle.State = Lifecycle.State.STARTED,
    collector: FlowCollector<T>,
) {
    viewLifecycleOwner.lifecycleScope.launch {
        repeatOnLifecycle(state) {
            collect(collector)
        }
    }
}
