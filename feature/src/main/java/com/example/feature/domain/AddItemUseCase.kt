package com.example.feature.domain

import com.example.core.Item
import com.example.feature.data.ItemRepository
import kotlinx.coroutines.flow.Flow

interface AddItemUseCase {
    suspend fun invoke(item : Item)
}