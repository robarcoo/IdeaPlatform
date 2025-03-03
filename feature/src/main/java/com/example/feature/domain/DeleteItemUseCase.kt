package com.example.feature.domain

import com.example.core.Item

interface DeleteItemUseCase {
    suspend fun invoke(item : Item)
}