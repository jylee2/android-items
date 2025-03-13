package com.androiditems

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.androiditems.ui.MainContent
import com.androiditems.viewmodels.ItemViewModel
import com.androiditems.viewmodels.ListViewModel

class MainActivity : ComponentActivity() {

    // TODO: Use dependency injection
    private val listViewModel by viewModels<ListViewModel>()
    private val itemViewModel by viewModels<ItemViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainContent(listViewModel, itemViewModel)
        }
    }

}
