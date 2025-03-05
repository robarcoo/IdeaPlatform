package com.example.feature.di

import com.example.core.di.room.DatabaseComponent
import com.example.feature.domain.AddItemUseCase
import com.example.feature.domain.AddItemUseCaseImpl
import com.example.feature.domain.DeleteItemUseCase
import com.example.feature.domain.DeleteItemUseCaseImpl
import com.example.feature.domain.EditItemUseCase
import com.example.feature.domain.EditItemUseCaseImpl
import com.example.feature.domain.GetItemsUseCase
import com.example.feature.domain.GetItemsUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module(includes = [ItemRepositoryModule::class])
abstract class UseCaseModule {

    @Singleton
    @Binds
    abstract fun provideAddItemUseCase(addItemUseCaseImpl: AddItemUseCaseImpl) : AddItemUseCase

    @Singleton
    @Binds
    abstract fun provideDeleteItemUseCase(deleteItemUseCaseImpl: DeleteItemUseCaseImpl) : DeleteItemUseCase

    @Singleton
    @Binds
    abstract fun provideEditItemUseCase(editItemUseCaseImpl: EditItemUseCaseImpl) : EditItemUseCase

    @Singleton
    @Binds
    abstract fun getItemsUseCase(getItemsUseCaseImpl: GetItemsUseCaseImpl) : GetItemsUseCase
}