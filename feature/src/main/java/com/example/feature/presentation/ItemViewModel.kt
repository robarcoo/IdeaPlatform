package com.example.feature.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.Item
import com.example.feature.domain.AddItemUseCase
import com.example.feature.domain.DeleteItemUseCase
import com.example.feature.domain.EditItemUseCase
import com.example.feature.domain.GetItemsUseCase
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ItemViewModel(
    private val addItemUseCase : AddItemUseCase,
    private val deleteItemUseCase : DeleteItemUseCase,
    private val editItemUseCase: EditItemUseCase,
    private val getItemsUseCase: GetItemsUseCase
): ViewModel() {

    private val _state : MutableStateFlow<List<Item>> = MutableStateFlow(listOf())
    val state : StateFlow<List<Item>> = _state.asStateFlow()

    init {
        getItems()
    }


    fun getItems() {
        viewModelScope.launch {
            getItemsUseCase.invoke().collect {
                _state.emit(it)
            }
        }
    }

    fun editItem(item : Item) {
        viewModelScope.launch {
            editItemUseCase.invoke(item)
            val temp = state.value.toMutableList().map {
                if (it.id == item.id) {
                    it.copy(name = item.name,
                        time = item.time,
                        tags = item.tags,
                        amount = item.amount)
                } else {
                    it
                }
            }
            _state.update {
                temp
            }
        }
    }

    fun deleteItem(item: Item) {
        viewModelScope.launch {
            deleteItemUseCase.invoke(item)
        }
    }

    fun addItem(item: Item) {
        viewModelScope.launch {
            addItemUseCase.invoke(item)
        }
    }

}