package com.androiditems.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androiditems.models.Item
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import com.androiditems.repositories.IItemsRepository
import kotlinx.coroutines.launch

interface IItemViewModel {
    val selectedItem: StateFlow<Item?>
//    fun refreshItems()
//    fun createItem(item: Item)
}

class ItemViewModel(
    private val itemsRepository: IItemsRepository
) : ViewModel(), IItemViewModel {

    private val _selectedItem = MutableStateFlow<Item?>(null)
    override val selectedItem = _selectedItem.asStateFlow()

    init {
        viewModelScope.launch {
//            items.value = itemsRepository.loadItems()
        }
    }

}