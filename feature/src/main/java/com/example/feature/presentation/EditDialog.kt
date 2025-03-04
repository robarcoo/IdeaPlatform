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
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.window.Dialog

@Composable
fun EditDialog(
    closeEditWindow: () -> Unit,
    editItem: () -> Unit
) {
    Dialog(onDismissRequest = closeEditWindow) {
        Card {
            Column() {
                Icon(
                    painter = rememberVectorPainter(image = Icons.Default.Settings),
                    contentDescription = "Edit Items"
                )
                Text("Количество товара")
                Row() {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = rememberVectorPainter(Icons.Outlined.Clear),
                            contentDescription = ""
                        )
                    }
                    Text("0")
                    IconButton(onClick = {}) {
                        Icon(
                            painter = rememberVectorPainter(Icons.Outlined.Add),
                            contentDescription = ""
                        )
                    }
                }
                Row() {
                    TextButton(onClick = { /*TODO*/ }) {

                    }
                    TextButton(onClick = { /*TODO*/ }) {

                    }
                }
            }
        }

    }
}