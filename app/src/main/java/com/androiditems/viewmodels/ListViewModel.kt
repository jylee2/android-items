package com.androiditems.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androiditems.models.Item
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
        viewModelScope.launch {
//            items.value = itemsRepository.loadItems()
        }
    }

}