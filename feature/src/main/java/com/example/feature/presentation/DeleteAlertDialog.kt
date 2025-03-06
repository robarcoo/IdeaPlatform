package com.example.feature.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.TextButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.core.Item
import com.example.feature.R

@Composable
fun DeleteAlertDialog(
    item: Item,
    closeDeleteWindow: () -> Unit,
    deleteItem: (Item) -> Unit) {
    AlertDialog(onDismissRequest = closeDeleteWindow,
        modifier = Modifier.padding(16.dp),
        confirmButton = { TextButton(onClick = {
            deleteItem(item)
        }) { Text(stringResource(R.string.confirm_button_text)) } },
        title = { Text(stringResource(R.string.delete_item_dialog_title), color = Color.Black) },
        dismissButton = { TextButton(onClick = closeDeleteWindow) {
            Text(stringResource(R.string.dismiss_button_text))  } },
        containerColor = Color.White,
        shape = RoundedCornerShape(20.dp),
        text = { Text(stringResource(R.string.delete_item_dialog_text), color = Color.Gray)},
        icon = { Icon(Icons.Default.Warning,
            contentDescription = stringResource(R.string.delete_item_icon_description),
            tint = Color.DarkGray)}
    )
}