package com.example.feature.presentation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.TextButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import com.example.core.Item

@Composable
fun DeleteAlertDialog(
    item: Item,
    closeDeleteWindow: () -> Unit,
    deleteItem: (Item) -> Unit) {
    AlertDialog(onDismissRequest = closeDeleteWindow,
        confirmButton = { TextButton(onClick = {
            deleteItem(item)
        }) { Text("Да") } },
        dismissButton = { TextButton(onClick = closeDeleteWindow) { Text("Нет")  } },
        icon = { Icon(painter = rememberVectorPainter(Icons.Default.Warning), contentDescription = "Delete Item Icon")}
    )
}