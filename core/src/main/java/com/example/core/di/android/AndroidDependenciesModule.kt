package com.example.core.di.android

import android.app.Application
import android.content.Context
import com.example.core.database.ItemDatabase
import com.example.core.di.room.DatabaseComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AndroidDependenciesModule (
    private val app: Application,
) {
    @Singleton
    @Provides
    fun provideApplication(): Application = app

    @Singleton
    @Provides
    fun provideApplicationContext(): Context = app

    @Singleton
    @Provides
    fun getDatabase(): ItemDatabase {
        return DatabaseComponent.init(app)
            .itemDatabase()
    }
}