package com.androiditems.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.androiditems.repositories.ItemsRepository
import com.androiditems.services.ItemsService
import com.androiditems.viewmodels.IItemViewModel
import com.androiditems.viewmodels.ItemViewModel

@Composable
fun ItemDetails(
    itemViewModel: IItemViewModel,
    navigateTo: (screen: String) -> Unit
) {
    val selectedItem = itemViewModel.selectedItem.collectAsStateWithLifecycle().value

    Column(
        modifier = Modifier.padding(20.dp)
    ) {
        Row {
            IconButton(
                onClick = {
                    itemViewModel.clearSelectedItem()
                    navigateTo(Screen.ItemsList)
                }
            ) {
                Icon(Icons.Filled.Close, "Close")
            }
        }
        Row(
            modifier = Modifier.padding(10.dp)
        ) {
            Text(
                text = "Item",
                style = MaterialTheme.typography.titleMedium
            )
        }
        Row(
            modifier = Modifier.padding(10.dp)
        ) {
            Text("ID: ${selectedItem?.id ?: ""}")
        }
        Row(
            modifier = Modifier.padding(10.dp)
        ) {
            Text("Name: ${selectedItem?.name ?: ""}")
        }
        Row(
            modifier = Modifier.padding(10.dp)
        ) {
            Text("New Field:")
        }
    }

}

@Preview
@Composable
fun ItemDetailsPreview() {
    val itemsService = ItemsService()
    val itemsRepository = ItemsRepository(itemsService)
    val itemViewModel = viewModel<ItemViewModel>(
        factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return ItemViewModel(itemsRepository) as T
            }
        }
    )
    ItemDetails(itemViewModel) {}
}