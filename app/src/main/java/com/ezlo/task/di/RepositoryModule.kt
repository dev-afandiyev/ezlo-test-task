package com.ezlo.task.di

import com.ezlo.task.db.repositories.IDevicesRepository
import com.ezlo.task.db.repositories.DevicesRepositoryIml
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindItemsRepository(repository: DevicesRepositoryIml): IDevicesRepository

}