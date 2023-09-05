package com.ezlo.task.data.api

import com.ezlo.task.data.models.items.DevicesResponse
import retrofit2.Response
import retrofit2.http.GET

interface BackendApi {

    @GET("test_android/items.test")
    suspend fun getDevices() : Response<DevicesResponse>

}