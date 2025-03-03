package com.example.feature.domain

import com.example.core.Item

interface EditItemUseCase {
    suspend fun invoke(item : Item)
}