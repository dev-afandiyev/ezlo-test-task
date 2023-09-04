package com.ezlo.task.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ezlo.task.db.dao.IDevicesDao
import com.ezlo.task.db.models.devices.DevicesModel

@Database(
    version = 1,
    entities = [
        DevicesModel::class
    ],
    exportSchema = true,
)
abstract class EzloDatabase : RoomDatabase() {

    abstract fun devicesDao(): IDevicesDao

}