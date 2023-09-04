package com.ezlo.task.db.repositories

import com.ezlo.task.data.models.items.ItemsResponse
import kotlinx.coroutines.flow.Flow

interface IItemsRepository {

    fun getItems() : Flow<ItemsResponse>

}