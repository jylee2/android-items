package com.androiditems.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.androiditems.viewmodels.IItemViewModel
import com.androiditems.viewmodels.IListViewModel

class Screen {
    companion object {
        val ItemsList = "ItemsList"
        val ItemDetails = "ItemDetails"
        val CreateItem = "CreateItem"
    }
}

@Composable
fun MainContent(
    listViewModel: IListViewModel,
    itemViewModel: IItemViewModel
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.ItemsList
    ) {
        composable(Screen.ItemsList) {
            val itemsResult = listViewModel.items.collectAsStateWithLifecycle().value
            ItemsList(itemsResult) {
                navController.navigate(it)
            }
        }
        composable(Screen.ItemDetails) {
            ItemDetails(itemViewModel) {
                navController.navigate(it)
            }
        }
        composable(Screen.CreateItem) {
            CreateItem(itemViewModel) {
                navController.navigate(it)
            }
        }
    }

}