package com.example.feature.domain

import com.example.core.Item
import com.example.feature.data.ItemRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetItemsUseCaseImpl @Inject constructor(private val repository: ItemRepository) : GetItemsUseCase {
    override suspend fun invoke(): Flow<List<Item>> = withContext(Dispatchers.IO) {
        return@withContext repository.getItems()
    }
}