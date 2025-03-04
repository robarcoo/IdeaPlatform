package com.example.feature.presentation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.TextButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.rememberVectorPainter

@Composable
fun DeleteAlertDialog() {
    AlertDialog(onDismissRequest = {},
        confirmButton = { TextButton(onClick = {}) { Text("Да") } },
        dismissButton = { TextButton(onClick = {}) { Text("Нет")  } },
        icon = { Icon(painter = rememberVectorPainter(Icons.Default.Warning), contentDescription = "Delete Item Icon")}
    )
}