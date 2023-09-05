package com.ezlo.task.viewmodels

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.ezlo.task.db.models.devices.DevicesModel
import com.ezlo.task.db.repositories.IDevicesRepository
import com.ezlo.task.viewmodels.base.BaseViewModel
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
    private val repository: IDevicesRepository
) : BaseViewModel() {

    val devicesFlow = singleSharedFlow<PagingData<DevicesModel>>()

    fun getDevices() = viewModelScope.launch {
        repository.getDevices()
            .catch { it.printStackTrace() }
            .cachedIn(this)
            .onEach { devicesFlow.emit(it) }
            .flowOn(Dispatchers.IO)
            .launchIn(this)
    }

    fun resetData() = viewModelScope.launch(Dispatchers.IO) {
        repository.resetData()
    }

    fun deleteItem(pkDevice: Long) = viewModelScope.launch(Dispatchers.IO) {
        repository.deleteById(pkDevice)
    }

   fun edit(device: DevicesModel) = viewModelScope.launch(Dispatchers.IO) {
       repository.edit(device)
   }

}