package com.androiditems.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.androiditems.models.Item
import com.androiditems.viewmodels.IItemViewModel
import com.androiditems.viewmodels.ListViewModel

@Composable
fun ItemDetails(
    itemViewModel: IItemViewModel
) {
    var id by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }

    Column {
        TextField(value = id, onValueChange = { id = it }, label = { Text("ID") })
        TextField(value = name, onValueChange = { name = it }, label = { Text("Name") })
//        Button(onClick = { viewModel.addItem(id, name) }) {
//            Text("Add Item")
//        }
//        Content(viewModel = viewModel) // Reuse the existing list display
    }
}