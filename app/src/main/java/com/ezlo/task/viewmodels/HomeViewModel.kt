package com.ezlo.task.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ezlo.task.db.repositories.IItemsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val itemsRepository: IItemsRepository
) : ViewModel() {

    fun getItems() = viewModelScope.launch {
        itemsRepository.getItems()
            .onEach {  }
            .catch { it.printStackTrace() }
            .flowOn(Dispatchers.IO)
            .launchIn(this)
    }

}