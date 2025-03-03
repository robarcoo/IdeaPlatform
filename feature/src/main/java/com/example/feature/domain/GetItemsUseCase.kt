package com.example.feature.domain

import com.example.core.Item
import kotlinx.coroutines.flow.Flow

interface GetItemsUseCase {
    suspend fun invoke() : Flow<List<Item>>
}