package com.androiditems.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androiditems.models.Item
//import com.androiditems.repositories.IItemsRepository
import kotlinx.coroutines.launch

interface IListViewModel {
    val items: MutableLiveData<Set<Item>>
//    fun refreshItems()
//    fun createItem(item: Item)
}

class ListViewModel(
//    private val itemsRepository: IItemsRepository
) : ViewModel(), IListViewModel {

    override val items: MutableLiveData<Set<Item>> = MutableLiveData()

    init {
        viewModelScope.launch {
//            items.value = itemsRepository.loadItems()
        }
    }

}