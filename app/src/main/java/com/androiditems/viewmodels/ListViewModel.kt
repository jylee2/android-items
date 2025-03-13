package com.androiditems.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androiditems.models.Item
import kotlinx.coroutines.flow.StateFlow
import com.androiditems.repositories.IItemsRepository
import kotlinx.coroutines.launch

interface IListViewModel {
    val items: StateFlow<List<Item>>
}

class ListViewModel(
    private val itemsRepository: IItemsRepository
) : ViewModel(), IListViewModel {

    override val items = itemsRepository.items

    init {
        viewModelScope.launch f@{
            itemsRepository.loadItems()
        }
    }

}