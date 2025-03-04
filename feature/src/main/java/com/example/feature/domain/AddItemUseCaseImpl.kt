package com.example.feature.domain

import com.example.core.Item
import com.example.feature.data.ItemRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AddItemUseCaseImpl
    @Inject constructor(private val repository: ItemRepository, private val item: Item) : AddItemUseCase {
    override suspend fun invoke(item: Item) = withContext(Dispatchers.IO) {
        return@withContext repository.createItem(item)
    }
}