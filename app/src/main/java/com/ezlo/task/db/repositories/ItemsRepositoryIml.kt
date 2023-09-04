package com.ezlo.task.db.repositories

import com.ezlo.task.data.api.BackendApi
import com.ezlo.task.data.models.items.ItemsResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class ItemsRepositoryIml @Inject constructor(
    private val api: BackendApi
) : IItemsRepository {

   override fun getItems(): Flow<ItemsResponse> = flow {
        emit(api.getItems())
    }.flowOn(Dispatchers.IO)

}