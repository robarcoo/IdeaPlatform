package com.example.feature.presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.Chip
import androidx.compose.material.ChipDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ChipColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterialApi::class, ExperimentalLayoutApi::class)
@Composable
fun ItemCard(productName : String,
             tagList: List<String>,
             inStorage : Int,
             date : String,
             openEditWindow: () -> Unit,
             openDeleteWindow: () -> Unit) {

    Card(modifier = Modifier
        .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(horizontalArrangement = Arrangement.SpaceBetween) {
                Text(
                    text = productName, fontWeight = FontWeight.Bold,
                    color = Color.Black, modifier = Modifier.weight(1f),
                    fontSize = 18.sp
                )
                Row() {
                    IconButton(onClick = openEditWindow) {
                        Icon(Icons.Default.Create, contentDescription = "")
                    }
                    IconButton(onClick = openDeleteWindow) {
                        Icon(Icons.Default.Delete, contentDescription = "")
                    }
                }
            }
            FlowRow(horizontalArrangement = Arrangement.spacedBy(4.dp),
               verticalArrangement = Arrangement.spacedBy((-10).dp)) {
                tagList.forEach {
                    Chip(
                        onClick = {}, border = BorderStroke(1.dp, Color.DarkGray),
                        shape = MaterialTheme.shapes.small.copy(
                            CornerSize(percent = 30)),
                        colors = ChipDefaults.outlinedChipColors(backgroundColor = Color.Transparent)
                    ) {
                        Text(it, color = Color.Black, fontWeight = FontWeight.Bold,
                            fontSize = 12.sp)
                    }
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(text = "На складе", fontWeight = FontWeight.Bold, color = Color.Black)
                    Text(text = inStorage.toString(), color = Color.Black)
                }
                Column() {
                    Text(text = "Дата добавления", fontWeight = FontWeight.Bold, color = Color.Black)
                    Text(text = date, color = Color.Black)
                }
            }
        }

    }
}