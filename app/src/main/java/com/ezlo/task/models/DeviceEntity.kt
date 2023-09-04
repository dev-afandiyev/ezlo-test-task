package com.ezlo.task.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * UI entity for device info
 */

@Parcelize
data class DeviceEntity(
    var pkDevice: Int? = null,
    var macAddress: String? = null,
    var firmware: String? = null,
    var platform: String? = null
) : Parcelable