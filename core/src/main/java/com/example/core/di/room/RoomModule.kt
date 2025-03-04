package com.example.core.di.room

import android.content.Context
import androidx.room.Room
import com.example.core.database.ItemDatabase
import dagger.Module
import dagger.Provides

@Module
internal class RoomModule {

    @DatabaseScope
    @Provides
    fun provideDatabase(context: Context): ItemDatabase {
        return Room.databaseBuilder(context, ItemDatabase::class.java, "database.db")
            .build()
    }
}