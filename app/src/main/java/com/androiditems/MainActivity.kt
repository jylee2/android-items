package com.androiditems

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.androiditems.repositories.ItemsRepository
import com.androiditems.ui.MainContent
import com.androiditems.viewmodels.ItemViewModel
import com.androiditems.viewmodels.ListViewModel

class MainActivity : ComponentActivity() {

    // TODO: Use dependency injection
    private val itemsRepository = ItemsRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val listViewModel = viewModel<ListViewModel>(
                factory = object : ViewModelProvider.Factory {
                    override fun <T : ViewModel> create(modelClass: Class<T>): T {
                        return ListViewModel(itemsRepository) as T
                    }
                }
            )
            val itemViewModel = viewModel<ItemViewModel>(
                factory = object : ViewModelProvider.Factory {
                    override fun <T : ViewModel> create(modelClass: Class<T>): T {
                        return ItemViewModel(itemsRepository) as T
                    }
                }
            )

            MainContent(listViewModel, itemViewModel)
        }
    }

}
