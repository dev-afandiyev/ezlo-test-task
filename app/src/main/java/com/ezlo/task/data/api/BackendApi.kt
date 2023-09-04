package com.ezlo.task.data.api

import com.ezlo.task.data.models.items.ItemsResponse
import retrofit2.http.GET

interface BackendApi {

    @GET("test_android/items.test")
    suspend fun getItems() : ItemsResponse

}