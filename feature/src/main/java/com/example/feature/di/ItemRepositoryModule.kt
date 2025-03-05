package com.example.feature.di

import com.example.core.di.room.DatabaseComponent
import com.example.feature.data.ItemRepository
import com.example.feature.data.ItemRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class ItemRepositoryModule {

    @Singleton
    @Binds
    abstract fun provideItemRepository(repository: ItemRepositoryImpl) : ItemRepository

}