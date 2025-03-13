package com.androiditems.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.androiditems.models.Item

@Composable
fun ItemRow(item: Item) {

//    val selectedItemViewModel: SelectedItemViewModel = getViewModel()
//    val appRouter: IAppRouter = get()

    fun onClick(item: Item) {
        // TODO: navigate to the Item Details screen
//        selectedItemViewModel.setItem(item)
//        appRouter.navigateTo(Routes.ItemDetails)
    }

    Row(
        modifier = Modifier
            .clickable { onClick(item) }
            .padding(12.dp), // TODO: use a Theme.dp.md
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = item.name)
    }

}

@Composable
fun ItemsList(items: List<Item>) {
    LazyColumn {
        items(
            items = items,
            key = { it.id }
        ) {  item ->
            ItemRow(item)
        }
    }
}

@Preview
@Composable
fun ItemsListPreview() {
    val items = listOf(
        Item("id1", "name1"),
        Item("id2", "name2"),
        Item("id3", "name3"),
        Item("id4", "name4"),
        Item("id5", "name5"),
        Item("id6", "name6")
    )
    ItemsList(items)
}