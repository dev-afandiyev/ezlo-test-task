package com.ezlo.task.db.repositories

import androidx.paging.PagingData
import com.ezlo.task.db.models.devices.DevicesModel
import kotlinx.coroutines.flow.Flow

interface IDevicesRepository {

    fun getDevices() : Flow<PagingData<DevicesModel>>

    suspend fun resetData()

    suspend fun deleteById(pkDevice: Long)

    suspend fun edit(device: DevicesModel)

}