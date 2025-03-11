package com.androiditems.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.androiditems.models.Item

@Composable
fun ItemRow(item: Item) {

    val selectedItemViewModel: SelectedItemViewModel = getViewModel()
    val appRouter: IAppRouter = get()

    fun onClick() {
        selectedItemViewModel.setItem(item)
        appRouter.navigateTo(Routes.ItemDetails)
    }

    Row(
        modifier = Modifier
            .clickable { onClick() }
            .padding(12.dp), // TODO: use a Theme.dp.md
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = item.name)
    }

}

@Composable
fun MainContent() {
    val itemsList = viewModel.items.observeAsState().value

    LazyColumn {
        items(
            items = itemsList,
            key = { it.id }
        ) { item ->
            ItemRow(item)
        }
    }

}