package com.example.feature.data

import com.example.core.Item
import com.example.core.database.ItemDao
import com.example.core.database.ItemDatabase
import kotlinx.coroutines.flow.Flow

class ItemRepositoryImpl(private val itemDao: ItemDao) : ItemRepository {

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