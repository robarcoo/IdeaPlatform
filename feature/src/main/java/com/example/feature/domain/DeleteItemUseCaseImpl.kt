package com.example.feature.domain

import com.example.core.Item
import com.example.feature.data.ItemRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DeleteItemUseCaseImpl(private val repository: ItemRepository, private val item : Item) : DeleteItemUseCase {
    override suspend fun invoke(item: Item) = withContext(Dispatchers.IO) {
        return@withContext repository.deleteItem(item)
    }

}