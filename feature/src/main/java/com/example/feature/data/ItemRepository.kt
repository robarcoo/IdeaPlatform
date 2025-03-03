package com.example.feature.data

import com.example.core.Item
import kotlinx.coroutines.flow.Flow

interface ItemRepository {
    suspend fun getItems() : Flow<List<Item>>
    suspend fun deleteItem(item : Item)
    suspend fun editItem(item : Item)
    suspend fun createItem(item: Item)
}