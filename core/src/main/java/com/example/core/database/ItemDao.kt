package com.example.core.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.core.Item
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {
    @Update(entity = Item::class)
    fun updateItem(item: Item)
    @Insert(entity = Item::class)
    fun insertItem(item: Item)
    @Delete
    fun deleteItem(item: Item)
    @Query("SELECT * FROM Item")
    fun getItems() : Flow<List<Item>>
}