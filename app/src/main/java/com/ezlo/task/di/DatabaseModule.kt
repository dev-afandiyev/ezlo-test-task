package com.ezlo.task.di

import android.content.Context
import androidx.room.Room
import com.ezlo.task.db.EzloDatabase
import com.ezlo.task.db.dao.IDevicesDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context): EzloDatabase {
        return Room.databaseBuilder(
            appContext,
            EzloDatabase::class.java, "database"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideDevicesDao(appDatabase: EzloDatabase): IDevicesDao {
        return appDatabase.devicesDao()
    }


}