package com.example.feature.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.core.Item
import com.example.core.util.getDate


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun CatalogueScreen() {
    val itemList = listOf<Item>()
    TopAppBar(title = { Text("Список товаров") })
    SearchBar(inputField = { /*TODO*/ }, expanded = true, onExpandedChange = {}) {

    }
    LazyColumn(verticalArrangement = Arrangement.SpaceBetween) {
        items(itemList) { card ->
            ItemCard(productName = card.name,
                tagList = card.tags,
                inStorage = card.amount,
                date = getDate(card.time)
            )
        }
    }

}