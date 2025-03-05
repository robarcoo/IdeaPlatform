package com.example.feature.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.window.Dialog
import com.example.core.Item

@Composable
fun EditDialog(
    item : Item,
    closeEditWindow: () -> Unit,
    onItemEdited: (Item) -> Unit
) {
    val editItem by remember { mutableStateOf(item) }
    Dialog(onDismissRequest = closeEditWindow) {
        Card {
            Column() {
                Icon(
                    painter = rememberVectorPainter(image = Icons.Default.Settings),
                    contentDescription = "Edit Items"
                )
                Text("Количество товара")
                Row() {
                    IconButton(onClick = { editItem.amount-- }) {
                        Icon(
                            painter = rememberVectorPainter(Icons.Outlined.Clear),
                            contentDescription = ""
                        )
                    }
                    Text("${editItem.amount}")
                    IconButton(onClick = { editItem.amount++ }) {
                        Icon(
                            painter = rememberVectorPainter(Icons.Outlined.Add),
                            contentDescription = ""
                        )
                    }
                }
                Row() {
                    TextButton(onClick = closeEditWindow) {
                        Text("Отмена")
                    }
                    TextButton(onClick = { onItemEdited(editItem) }) {
                        Text("Принять")
                    }
                }
            }
        }

    }
}