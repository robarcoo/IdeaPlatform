package com.example.feature.domain

import com.example.core.Item
import com.example.feature.data.ItemRepository
import dagger.assisted.AssistedInject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DeleteItemUseCaseImpl @Inject constructor(private val repository: ItemRepository) : DeleteItemUseCase {
    override suspend fun invoke(item: Item) = withContext(Dispatchers.IO) {
        return@withContext repository.deleteItem(item)
    }

}