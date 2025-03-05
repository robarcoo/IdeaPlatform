package com.example.feature.domain

import com.example.core.Item
import com.example.feature.data.ItemRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class EditItemUseCaseImpl @Inject constructor(private val repository: ItemRepository) : EditItemUseCase {
    override suspend fun invoke(item: Item) = withContext(Dispatchers.IO) {
        return@withContext repository.editItem(item)
    }

}