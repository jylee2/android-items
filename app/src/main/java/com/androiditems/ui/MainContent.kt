package com.androiditems.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.androiditems.viewmodels.IListViewModel

@Composable
fun MainContent(
    listViewModel: IListViewModel
) {
    val itemsList = listViewModel.items.collectAsStateWithLifecycle().value
    ItemsList(itemsList)
}