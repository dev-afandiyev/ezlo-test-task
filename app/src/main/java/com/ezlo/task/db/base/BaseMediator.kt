package com.ezlo.task.db.base

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.RemoteMediator

@OptIn(ExperimentalPagingApi::class)
abstract class BaseMediator<T : Any> : RemoteMediator<Int, T>(), IBaseMediator<T> {

    var pageIndex = 0

    fun getPageIndex(loadType: LoadType): Int? {
        pageIndex = when (loadType) {
            LoadType.REFRESH -> 0
            LoadType.PREPEND -> return null
            LoadType.APPEND -> ++pageIndex
        }
        return pageIndex
    }

}

interface IBaseMediator<T> {

    /**
     * Function for sending and processing the response
     */
    suspend fun fetchResponse(pageSize: Int): List<T>

}