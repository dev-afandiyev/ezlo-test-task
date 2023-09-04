package com.ezlo.task.data.models.items

import com.google.gson.annotations.SerializedName

data class ItemsResponse(
    @SerializedName("Devices")
    var Devices: ArrayList<Devices> = arrayListOf()
)

data class Devices(
    @SerializedName("PK_Device")
    var PKDevice: Int? = null,
    @SerializedName("MacAddress")
    var MacAddress: String? = null,
    @SerializedName("PK_DeviceType")
    var PKDeviceType: Int? = null,
    @SerializedName("PK_DeviceSubType")
    var PKDeviceSubType: Int? = null,
    @SerializedName("Firmware")
    var Firmware: String? = null,
    @SerializedName("Server_Device")
    var ServerDevice: String? = null,
    @SerializedName("Server_Event")
    var ServerEvent: String? = null,
    @SerializedName("Server_Account")
    var ServerAccount: String? = null,
    @SerializedName("InternalIP")
    var InternalIP: String? = null,
    @SerializedName("LastAliveReported")
    var LastAliveReported: String? = null,
    @SerializedName("Platform")
    var Platform: String? = null
)