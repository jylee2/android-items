package com.androiditems.ui

import com.androiditems.viewmodels.ListViewModel

class ListActivity: ComponentActivity() {

    val viewModel = ListViewModel()

    fun onCreate() {
        setContent {
            Content()
        }
    }

    @Composable
    fun Content() {
        val items = viewModel.items.observeAsState().value
        items.forEach {
            Text(text = it.name)
        }
    }

}