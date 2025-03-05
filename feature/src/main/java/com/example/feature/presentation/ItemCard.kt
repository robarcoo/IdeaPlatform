package com.example.feature.presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Chip
import androidx.compose.material.ChipDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.ChipColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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

    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)) {
        Row(modifier = Modifier.padding(8.dp)) {
            Text(text = productName, fontWeight = FontWeight.Bold)
            Row() {
                IconButton(onClick = openEditWindow) {
                    Icon(Icons.Default.Create, contentDescription = "")
                }
                IconButton(onClick = openDeleteWindow) {
                    Icon(Icons.Default.Delete, contentDescription = "")
                }
            }
        }
        LazyRow(horizontalArrangement = Arrangement.SpaceBetween) {
            items(tagList) {
                Chip(onClick = {}, border = BorderStroke(1.dp, Color.Black),
                    colors = ChipDefaults.outlinedChipColors(backgroundColor = Color.Transparent)) {
                    Text(it)
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