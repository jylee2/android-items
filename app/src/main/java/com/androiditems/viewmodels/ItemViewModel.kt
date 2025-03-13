package com.androiditems.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androiditems.models.Item
import com.androiditems.models.Result
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import com.androiditems.repositories.IItemsRepository
import com.androiditems.ui.Screen
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

interface IItemViewModel {
    val selectedItem: StateFlow<Item?>
    val createItemLoading: StateFlow<Boolean>
    fun setSelectedItem(item: Item)
    fun clearSelectedItem()
    fun createItem(
        item: Item,
        navigateTo: (screen: String) -> Unit
    )

    fun updateItem(item: Item)
    fun deleteItem(item: Item)
}

class ItemViewModel(
    private val itemsRepository: IItemsRepository
) : ViewModel(), IItemViewModel {

    private val _selectedItem = MutableStateFlow<Item?>(null)
    override val selectedItem = _selectedItem.asStateFlow()
    private val _createItemLoading = MutableStateFlow(false)
    override val createItemLoading = _createItemLoading.asStateFlow()

    override fun setSelectedItem(item: Item) {
        _selectedItem.value = item
    }

    override fun clearSelectedItem() {
        _selectedItem.value = null
    }

    override fun createItem(
        item: Item,
        navigateTo: (screen: String) -> Unit
    ) {
        _createItemLoading.value = true
        viewModelScope.launch {
            val result = async {
                itemsRepository.createItem(item)
            }.await()
            when (result) {
                is Result.Success -> {
                    // TODO: show success message and navigate to Item details screen
                    navigateTo(Screen.ItemDetails)
                }

                is Result.Error<*> -> {
                    // TODO: show error message
                }

                else -> {}
            }
            _createItemLoading.value = false
        }
    }

    override fun updateItem(item: Item) {
        TODO("Not yet implemented")
    }

    override fun deleteItem(item: Item) {
        TODO("Not yet implemented")
    }

}