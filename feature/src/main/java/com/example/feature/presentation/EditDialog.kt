package com.example.feature.presentation

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.core.Item
import com.example.feature.R

@Composable
fun EditDialog(
    item : Item,
    closeEditWindow: () -> Unit,
    onItemEdited: (Item) -> Unit
) {
    val editItem = remember { mutableStateOf(item) }
    Dialog(onDismissRequest = closeEditWindow) {
        Card(colors = CardDefaults.cardColors(containerColor = Color.White),
            shape = RoundedCornerShape(20.dp)) {
            Column(modifier = Modifier.padding(32.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(
                    painter = rememberVectorPainter(image = Icons.Default.Settings),
                    contentDescription = stringResource(R.string.edit_items_icon_description),
                    tint = Color.DarkGray
                )
                Text(
                    stringResource(R.string.item_amount_label),
                    fontSize = 24.sp,
                    modifier = Modifier.padding(vertical = 16.dp),
                    color = Color.Black)
                Row(verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                    OutlinedButton(onClick = {
                        editItem.value = editItem.value.copy(amount = editItem.value.amount - 1)
                    },
                        modifier= Modifier.size(40.dp),
                        contentPadding = PaddingValues(0.dp),
                        border = BorderStroke(2.dp, Color.Blue)
                    ) {
                        Text(stringResource(R.string.remove_item), fontSize = 30.sp, color = Color.Blue)
                    }
                    Text("${editItem.value.amount}", fontSize = 20.sp)
                    OutlinedButton(onClick = {
                        editItem.value = editItem.value.copy(amount = editItem.value.amount + 1)
                    },
                        modifier= Modifier.size(40.dp),
                        contentPadding = PaddingValues(0.dp),
                        border = BorderStroke(2.dp, Color.Blue)
                    ) {

                        Text(text = stringResource(R.string.add_item),
                            fontSize = 35.sp,
                            color = Color.Blue)
                    }
                }
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp), horizontalArrangement = Arrangement.End) {
                    TextButton(onClick = closeEditWindow) {
                        Text(stringResource(R.string.cancel_edit), color = Color.DarkGray)
                    }
                    TextButton(onClick = {
                        onItemEdited(editItem.value)
                    }) {
                        Text(text = stringResource(R.string.accept_edit), color = Color.DarkGray)
                    }
                }
            }
        }

    }
}