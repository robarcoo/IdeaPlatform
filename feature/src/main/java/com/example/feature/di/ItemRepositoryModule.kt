package com.example.feature.di

import com.example.feature.data.ItemRepository
import com.example.feature.data.ItemRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
abstract class ItemRepositoryModule {

    @Binds
    abstract fun provideItemRepositoryImpl(repository: ItemRepository) : ItemRepositoryImpl

}