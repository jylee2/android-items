package com.androiditems.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androiditems.models.Item
import com.androiditems.models.Result
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import com.androiditems.repositories.IItemsRepository
import kotlinx.coroutines.launch

interface IListViewModel {
    val items: StateFlow<List<Item>>
//    fun refreshItems()
}

class ListViewModel(
    private val itemsRepository: IItemsRepository
) : ViewModel(), IListViewModel {

    private val _items = MutableStateFlow<List<Item>>(mutableListOf())
    override val items = _items.asStateFlow()

    init {
        viewModelScope.launch f@{
            val result = itemsRepository.loadItems()
            when(result) {
                is Result.Success -> {
                    _items.value = result.data
                }
                is Result.Error<*> -> {
                    // TODO: show error message
                }
                is Result.Loading -> {
                    // TODO: Show CircularProgressBar
                }
            }
        }
    }

}