package com.example.feature.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.core.Item
import com.example.core.util.getDate
import com.example.feature.di.LocalFactoryProvider
import javax.inject.Inject


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CatalogueScreen(viewModel: ItemViewModel = hiltViewModel()) {
    val state = viewModel.state.collectAsState()
    val openEditWindow = viewModel.editWindow.collectAsState()
    val openDeleteWindow = viewModel.deleteWindow.collectAsState()
    val item = viewModel.chosenItem.collectAsState()
    val textFieldState = remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) }
    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(title = { Text("Список товаров") })
            LazyColumn(verticalArrangement = Arrangement.SpaceBetween) {
                item {
                    SearchBar(
                        inputField = {
                            SearchBarDefaults.InputField(
                                query = textFieldState.value,
                                onQueryChange = { textFieldState.value = it },
                                onSearch = { active = false },
                                expanded = false,
                                onExpandedChange = { },
                                placeholder = { Text("Hinted search text") },
                                leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
                                trailingIcon = { Icon(Icons.Default.MoreVert, contentDescription = null) },
                            )
                        },
                        expanded = false,
                        onExpandedChange = {},
                    ) {}
                }
                items(state.value) { card ->
                    ItemCard(productName = card.name,
                        tagList = card.tags,
                        inStorage = card.amount,
                        date = getDate(card.time),
                        openEditWindow = {
                            viewModel.openEditWindow()
                            viewModel.setItem(card)
                                         },
                        openDeleteWindow = {
                            viewModel.openDeleteWindow()
                            viewModel.setItem(card)
                        }
                    )
                }
            }

    }
        if (openEditWindow.value) {
            EditDialog(
                item = item.value,
                closeEditWindow = { viewModel.closeEditWindow() },
                onItemEdited = {
                    viewModel.editItem(item.value)
                    viewModel.closeEditWindow()
                }
            )
        }
        if (openDeleteWindow.value) {
            DeleteAlertDialog(
                item = item.value,
                closeDeleteWindow = { viewModel.closeDeleteWindow() },
                deleteItem = {
                    viewModel.deleteItem(item.value)
                    viewModel.closeDeleteWindow()
                }
            )
        }


}