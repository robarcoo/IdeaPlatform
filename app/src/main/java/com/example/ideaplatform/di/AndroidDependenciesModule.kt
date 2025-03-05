package com.example.ideaplatform.di

import android.app.Application
import android.content.Context
import com.example.core.database.ItemDatabase
import com.example.core.di.room.DatabaseComponent
import com.example.feature.di.RepositoryComponent
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AndroidDependenciesModule {

    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext app: Context): Application = app as Application


    @Singleton
    @Provides
    fun provideApplicationContext(@ApplicationContext app: Context): Context = app



}