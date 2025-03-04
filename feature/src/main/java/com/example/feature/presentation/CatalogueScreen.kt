package com.example.feature.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ColumnScope
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
import com.example.core.Item
import com.example.core.util.getDate


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CatalogueScreen(viewModel: ItemViewModel) {
    val state = viewModel.state.collectAsState()
    val openEditWindow = viewModel.editWindow.collectAsState()
    val openDeleteWindow = viewModel.deleteWindow.collectAsState()
    val textFieldState = remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) }

    TopAppBar(title = { Text("Список товаров") })

    SearchBar(
            inputField = {
                SearchBarDefaults.InputField(
                    query = textFieldState.value,
                    onQueryChange = { textFieldState.value = it},
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
        ) {
        LazyColumn(verticalArrangement = Arrangement.SpaceBetween) {
            items(state.value) { card ->
                ItemCard(productName = card.name,
                    tagList = card.tags,
                    inStorage = card.amount,
                    date = getDate(card.time),
                    openEditWindow = { viewModel.openEditWindow() },
                    openDeleteWindow = { viewModel.openDeleteWindow() }
                )
            }
        }
    }
    if (openEditWindow.value) {
        EditDialog()
    }
    if (openDeleteWindow.value) {
        DeleteAlertDialog()
    }

}