package com.ezlo.task.db.models.devices

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "model_devices")
data class DevicesModel(
    @PrimaryKey
    @ColumnInfo(name = "id")
    var pkDevice: Int? = null,
    var macAddress: String? = null,
    var pkDeviceType: Int? = null,
    var pkDeviceSubType: Int? = null,
    var firmware: String? = null,
    var serverDevice: String? = null,
    var serverEvent: String? = null,
    var serverAccount: String? = null,
    var internalIP: String? = null,
    var lastAliveReported: String? = null,
    var platform: String? = null
)