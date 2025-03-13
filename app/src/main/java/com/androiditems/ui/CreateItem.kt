package com.androiditems.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.androiditems.models.Item
import com.androiditems.viewmodels.IItemViewModel

@Composable
fun CreateItem(
    itemViewModel: IItemViewModel
) {
    val selectedItem = itemViewModel.selectedItem.collectAsStateWithLifecycle().value
    val createItemLoading = itemViewModel.createItemLoading.collectAsStateWithLifecycle().value

    Column(
        modifier = Modifier.padding(20.dp) // TODO: Don't hardcode dp
    ) {
        Row(
            modifier = Modifier.padding(10.dp)
        ) {
            Text(
                text = "Create Item",
                style = MaterialTheme.typography.titleMedium
            )
        }
        Row(
            modifier = Modifier.padding(10.dp)
        ) {
            OutlinedTextField(
                value = selectedItem?.id ?: "",
                onValueChange = {
                    val newItem = Item(it, selectedItem?.name ?: "")
                    itemViewModel.setSelectedItem(newItem)
                },
                placeholder = {
                    Text(
                        text = "Enter id..."
                    )
                },
                modifier = Modifier.fillMaxWidth()
            )
        }
        Row(
            modifier = Modifier.padding(10.dp)
        ) {
            OutlinedTextField(
                value = selectedItem?.name ?: "",
                onValueChange = {
                    val newItem = Item(selectedItem?.id ?: "", it)
                    itemViewModel.setSelectedItem(newItem)
                },
                placeholder = {
                    Text(
                        text = "Enter name..."
                    )
                },
                modifier = Modifier.fillMaxWidth()
            )
        }
        Row(
            modifier = Modifier.padding(10.dp)
        ) {
            Button(
                onClick = {
                    if (selectedItem == null) {
                        // TODO: Show an alert dialog saying
                        return@Button
                    }
                    itemViewModel.createItem(selectedItem)
                },
                modifier = Modifier.fillMaxWidth(),
                enabled = !createItemLoading
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    if (createItemLoading) {
                        CircularProgressIndicator()
                    } else {
                        Icon(Icons.Filled.Add, "Add")
                    }
                    Text(
                        text = "Create Item"
                    )
                }
            }
        }
    }

}