package com.example.feature.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.core.util.getDate
import com.example.feature.R



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CatalogueScreen(viewModel: ItemViewModel = hiltViewModel()) {
    val state = viewModel.state.collectAsState()
    val openEditWindow = viewModel.editWindow.collectAsState()
    val openDeleteWindow = viewModel.deleteWindow.collectAsState()
    val item = viewModel.chosenItem.collectAsState()
    val textFieldState = remember { mutableStateOf("") }
    Column(modifier = Modifier.fillMaxSize()) {
        CenterAlignedTopAppBar(title = { Text(stringResource(R.string.item_list_top_bar)) },
            colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Cyan, titleContentColor = Color.Black))
            LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.padding(8.dp)) {
                item {
                    OutlinedTextField(value = textFieldState.value,
                        onValueChange = { textFieldState.value = it },
                        label = { Text(stringResource(R.string.item_search_label)) },
                        leadingIcon = { Icon(Icons.Default.Search,
                            contentDescription = stringResource(
                            R.string.search_icon_description),
                            tint = Color.DarkGray)},
                        modifier = Modifier.fillMaxWidth(),
                        colors = OutlinedTextFieldDefaults.colors(cursorColor = Color.DarkGray,
                            focusedLabelColor = Color.DarkGray,
                            unfocusedLabelColor = Color.Gray,
                            unfocusedContainerColor = Color.White,
                            focusedContainerColor = Color.White,
                            unfocusedBorderColor = Color.DarkGray,
                            focusedBorderColor = Color.Blue,
                            focusedTextColor = Color.Black),
                        trailingIcon = { if (textFieldState.value.isNotEmpty())
                        { IconButton(onClick = { textFieldState.value = "" }) {
                            Icon(Icons.Default.Clear,
                                contentDescription = stringResource(R.string.clear_text_icon_description),
                                tint = Color.Black) } } },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Password
                        )
                    )
                }
                items(state.value.filter { it.name.contains(textFieldState.value, ignoreCase = true) }) { card ->
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
                onItemEdited = { newItem ->
                    viewModel.editItem(newItem)
                    viewModel.closeEditWindow()
                }
            )
        }
        if (openDeleteWindow.value) {
            DeleteAlertDialog(
                item = item.value,
                closeDeleteWindow = { viewModel.closeDeleteWindow() },
                deleteItem = { thisItem ->
                    viewModel.deleteItem(thisItem)
                    viewModel.closeDeleteWindow()
                }
            )
        }


}