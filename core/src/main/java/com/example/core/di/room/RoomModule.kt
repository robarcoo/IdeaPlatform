package com.example.core.di.room

import android.content.Context
import androidx.room.Room
import com.example.core.database.ItemDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
internal class RoomModule {

    @Singleton
    @Provides
    fun provideDatabase(context: Context): ItemDatabase {
        return Room.databaseBuilder(context, ItemDatabase::class.java, "database.db")
            .build()
    }
}