package com.example.feature.data

import android.util.Log
import com.example.core.Item
import com.example.core.database.ItemDao
import com.example.core.database.ItemDatabase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class ItemRepositoryImpl @Inject constructor(private val itemDatabase: ItemDatabase) : ItemRepository {

    private val itemDao = itemDatabase.itemDao()

    override suspend fun getItems() : Flow<List<Item>> {
        return itemDao.getItems()
    }

    override suspend fun deleteItem(item: Item) {
        itemDao.deleteItem(item)
    }

    override suspend fun editItem(item: Item) {
        itemDao.updateItem(item)
    }

    override suspend fun createItem(item: Item) {
        itemDao.insertItem(item)
    }

}