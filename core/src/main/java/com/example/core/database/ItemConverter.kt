package com.example.core.database

import androidx.room.TypeConverter
import com.example.core.Item
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ItemConverter {
    @TypeConverter
    fun fromItemInfoObject(item : Item?): String {
        val type = object : TypeToken<Item?>() {}.type
        return Gson().toJson(item, type)
    }

    @TypeConverter
    fun toItemObject(item: String?): Item {
        val type = object : TypeToken<Item?>() {}.type
        return Gson().fromJson(item, type)
    }
}