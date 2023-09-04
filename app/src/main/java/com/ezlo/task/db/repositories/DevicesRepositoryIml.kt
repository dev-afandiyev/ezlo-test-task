package com.ezlo.task.db.repositories

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingData
import com.ezlo.task.constants.Constants.PAGING_CONFIG
import com.ezlo.task.db.dao.IDevicesDao
import com.ezlo.task.db.models.devices.DevicesModel
import com.ezlo.task.db.repositories.mediator.DevicesMediator
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DevicesRepositoryIml @Inject constructor(
    private val mediator: DevicesMediator,
    private val dao: IDevicesDao,
) : IDevicesRepository {

    @OptIn(ExperimentalPagingApi::class)
    override fun getDevices(): Flow<PagingData<DevicesModel>> {
        return Pager(
            config = PAGING_CONFIG,
            remoteMediator = mediator,
            pagingSourceFactory = { dao.getPagingSource() }
        ).flow
    }

    override suspend fun resetData() {
        dao.resetData()
    }

    override suspend fun deleteById(pkDevice: Long) {
        dao.deleteById(pkDevice)
    }

}