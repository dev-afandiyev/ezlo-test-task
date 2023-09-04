package com.ezlo.task.di

import com.ezlo.task.db.repositories.IItemsRepository
import com.ezlo.task.db.repositories.ItemsRepositoryIml
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ItemsRepositoryModule {

    @Binds
    abstract fun bindFoo(foo: ItemsRepositoryIml): IItemsRepository

}