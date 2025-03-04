package com.example.feature.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Chip
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.Card
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ItemCard(productName : String,
             tagList: List<String>,
             inStorage : Int,
             date : String,
             openEditWindow: () -> Unit,
             openDeleteWindow: () -> Unit) {

    Card(modifier = Modifier.padding(8.dp)) {
        Row() {
            Text(text = productName, fontWeight = FontWeight.Bold)
            Row() {
                IconButton(onClick = openEditWindow) {
                    
                }
                IconButton(onClick = openDeleteWindow) {
                    
                }
            }
        }
        LazyRow {
            items(tagList) {
                Chip(onClick = {}) {
                    Text("")
                }
            }
        }
        Row() {
            Column() {
                Text(text = "На складе")
                Text(text = inStorage.toString())
            }
            Column() {
                Text(text = "Дата добавления")
                Text(text = date)
            }
        }

    }
}