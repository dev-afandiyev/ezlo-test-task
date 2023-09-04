package com.ezlo.task.viewmodels.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow

open class BaseViewModel : ViewModel() {

    fun <T> singleSharedFlow(): MutableSharedFlow<T> =
        MutableSharedFlow(replay = 1, onBufferOverflow = BufferOverflow.DROP_OLDEST)

}