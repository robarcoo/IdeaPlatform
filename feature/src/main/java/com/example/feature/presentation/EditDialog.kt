package com.example.feature.presentation

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.core.Item

@Composable
fun EditDialog(
    item : Item,
    closeEditWindow: () -> Unit,
    onItemEdited: (Item) -> Unit
) {
    val editItem = remember { mutableStateOf(item) }
    Dialog(onDismissRequest = closeEditWindow) {
        Card {
            Column(modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(
                    painter = rememberVectorPainter(image = Icons.Default.Settings),
                    contentDescription = "Edit Items"
                )
                Text("Количество товара", fontSize = 24.sp, modifier = Modifier.padding(vertical = 8.dp))
                Row(verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    OutlinedButton(onClick = {
                        editItem.value = editItem.value.copy(amount = editItem.value.amount - 1)
                    },
                        modifier= Modifier.size(40.dp),
                        contentPadding = PaddingValues(0.dp),
                        border = BorderStroke(2.dp, Color.Blue)
                    ) {
                        Text("—", fontSize = 30.sp, color = Color.Blue)
                    }
                    Text("${editItem.value.amount}", fontSize = 18.sp)
                    OutlinedButton(onClick = {
                        editItem.value = editItem.value.copy(amount = editItem.value.amount + 1)
                    },
                        modifier= Modifier.size(40.dp),
                        contentPadding = PaddingValues(0.dp),
                        border = BorderStroke(2.dp, Color.Blue)
                    ) {

                        Text("+", fontSize = 35.sp, color = Color.Blue)
                    }
                }
                Row() {
                    TextButton(onClick = closeEditWindow) {
                        Text("Отмена")
                    }
                    TextButton(onClick = {
                        Log.d("ROOMZ", "${editItem.value}")
                        onItemEdited(editItem.value)
                    }) {
                        Text("Принять")
                    }
                }
            }
        }

    }
}