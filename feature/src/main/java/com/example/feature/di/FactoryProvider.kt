package com.example.feature.di

import com.example.feature.presentation.ItemViewModel
import javax.inject.Inject

class FactoryProvider @Inject constructor(
    val viewModelFactory: DaggerViewModelFactory<ItemViewModel>,
)