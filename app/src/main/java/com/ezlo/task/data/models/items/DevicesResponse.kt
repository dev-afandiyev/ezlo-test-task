package com.ezlo.task.data.models.items

import com.ezlo.task.db.models.devices.DevicesModel
import com.google.gson.annotations.SerializedName

data class DevicesResponse(
    @SerializedName("Devices")
    var devices: ArrayList<Devices> = arrayListOf()
)

data class Devices(
    @SerializedName("PK_Device")
    var pkDevice: Int? = null,
    @SerializedName("MacAddress")
    var macAddress: String? = null,
    @SerializedName("PK_DeviceType")
    var pkDeviceType: Int? = null,
    @SerializedName("PK_DeviceSubType")
    var pkDeviceSubType: Int? = null,
    @SerializedName("Firmware")
    var firmware: String? = null,
    @SerializedName("Server_Device")
    var serverDevice: String? = null,
    @SerializedName("Server_Event")
    var serverEvent: String? = null,
    @SerializedName("Server_Account")
    var serverAccount: String? = null,
    @SerializedName("InternalIP")
    var internalIP: String? = null,
    @SerializedName("LastAliveReported")
    var lastAliveReported: String? = null,
    @SerializedName("Platform")
    var platform: String? = null
) {

    fun getDevicesEntity() = DevicesModel(
        pkDevice = pkDevice,
        macAddress = macAddress,
        pkDeviceType = pkDeviceType,
        pkDeviceSubType = pkDeviceSubType,
        firmware = firmware,
        serverDevice = serverDevice,
        serverEvent = serverEvent,
        serverAccount = serverAccount,
        internalIP = internalIP,
        lastAliveReported = lastAliveReported,
        platform = platform
    )

}