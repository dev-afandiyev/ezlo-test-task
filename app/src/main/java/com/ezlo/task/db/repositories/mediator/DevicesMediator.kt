package com.ezlo.task.db.repositories.mediator

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import com.ezlo.task.data.api.BackendApi
import com.ezlo.task.db.base.BaseMediator
import com.ezlo.task.db.dao.IDevicesDao
import com.ezlo.task.db.models.devices.DevicesModel
import javax.inject.Inject

@OptIn(ExperimentalPagingApi::class)
class DevicesMediator @Inject constructor(
    private val dao: IDevicesDao,
    private val api: BackendApi,
) : BaseMediator<DevicesModel>() {

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, DevicesModel>
    ): MediatorResult {
        pageIndex = getPageIndex(loadType)
            ?: return MediatorResult.Success(endOfPaginationReached = true)

        val limit = state.config.pageSize

        return try {
            val responseList = fetchResponse(limit)
            if (loadType == LoadType.REFRESH) {
                refresh(responseList)
            } else {
                dao.save(responseList)
            }

            MediatorResult.Success(endOfPaginationReached = responseList.size < limit)
        } catch (e: Exception) {
            e.printStackTrace()
            MediatorResult.Error(e)
        }
    }

    override suspend fun refresh(list: List<DevicesModel>) {
        val payloadIdList = list.map { it.pkDevice.toString() }
        dao.refresh(payloadIdList, list)
    }

    override suspend fun fetchResponse(pageSize: Int): List<DevicesModel> {
        val response = api.getDevices().body()

        return response?.devices.orEmpty().map { it.getDevicesEntity() }
    }

}