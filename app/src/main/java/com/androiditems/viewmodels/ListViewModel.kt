package com.androiditems.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androiditems.models.Item
import kotlinx.coroutines.launch

class ListViewModel : ViewModel() {

    val service = Service()
    val items: MutableLiveData<Set<Item>> = MutableLiveData()

    init {
        viewModelScope.launch {
            items.value = service.loadItems()
        }
    }

}