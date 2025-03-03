package com.example.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.core.Item

@Database(entities = [Item::class], version = 1)
@TypeConverters(ItemConverter::class)
abstract class ItemDatabase : RoomDatabase() {
    abstract fun itemDao() : ItemDao
}
