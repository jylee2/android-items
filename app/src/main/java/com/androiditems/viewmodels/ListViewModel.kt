package com.androiditems.viewmodels

import com.androiditems.models.Item

class ListViewModel : ViewModel() {

    val service = Service()
    val items: MutableLiveDate<Set<Item>> = MutableLiveData()

    init {
        viewModelScope.launch {
            items.value = service.loadItems()
        }
    }

}