package com.ezlo.task.db.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.ezlo.task.db.models.devices.DevicesModel

@Dao
interface IDevicesDao {

    /**
     * Get all items
     */
    @Transaction
    @Query("SELECT * FROM model_devices")
    fun getPagingSource(): PagingSource<Int, DevicesModel>

    /**
     * Save items
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(list: List<DevicesModel>)

    @Query("DELETE FROM model_devices")
    suspend fun resetData()

    @Query("DELETE FROM model_devices WHERE id = :pkDevice")
    suspend fun deleteById(pkDevice: Long)

    @Update
    suspend fun edit(device: DevicesModel)

}