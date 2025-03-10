package com.example.feature.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.core.Item
import com.example.feature.domain.AddItemUseCase
import com.example.feature.domain.DeleteItemUseCase
import com.example.feature.domain.EditItemUseCase
import com.example.feature.domain.GetItemsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

@HiltViewModel
class ItemViewModel @Inject constructor(
    private val addItemUseCase : AddItemUseCase,
    private val deleteItemUseCase : DeleteItemUseCase,
    private val editItemUseCase: EditItemUseCase,
    private val getItemsUseCase: GetItemsUseCase
): ViewModel() {

    private val _state : MutableStateFlow<List<Item>> = MutableStateFlow(listOf())
    val state : StateFlow<List<Item>> = _state.asStateFlow()

    private val _editWindow : MutableStateFlow<Boolean> = MutableStateFlow(false)
    val editWindow : StateFlow<Boolean> = _editWindow.asStateFlow()

    private val _deleteWindow : MutableStateFlow<Boolean> = MutableStateFlow(false)
    val deleteWindow : StateFlow<Boolean> = _deleteWindow.asStateFlow()

    private val _chosenItem : MutableStateFlow<Item> = MutableStateFlow(Item())
    val chosenItem : StateFlow<Item> = _chosenItem.asStateFlow()

    init {
        getItems()
    }


    private fun getItems() {
        viewModelScope.launch {
            _state.update {
                getItemsUseCase.invoke().first()
            }
        }
    }

    fun setItem(item : Item) {
        _chosenItem.update {
            item
        }
    }

    fun openEditWindow() {
        _editWindow.update {
            true
        }
    }

    fun closeEditWindow() {
        _editWindow.update {
            false
        }
    }

    fun openDeleteWindow() {
        _deleteWindow.update {
            true
        }
    }


    fun closeDeleteWindow() {
        _deleteWindow.update {
            false
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
            val temp = _state.value.toMutableList().filter { it.id != item.id }
            _state.update {
                temp
            }
        }
    }

    fun addItem(item: Item) {
        viewModelScope.launch {
            addItemUseCase.invoke(item)
        }
    }
}

