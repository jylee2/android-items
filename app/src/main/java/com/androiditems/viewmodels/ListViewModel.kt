package com.androiditems.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androiditems.models.Item
import com.androiditems.models.Result
import kotlinx.coroutines.flow.StateFlow
import com.androiditems.usecases.IGetItemsUseCase
import kotlinx.coroutines.launch

interface IListViewModel {
    val items: StateFlow<Result<List<Item>>>
}

class ListViewModel(
    private val getItemsUseCase: IGetItemsUseCase
) : ViewModel(), IListViewModel {

    override val items = getItemsUseCase.items

    init {
        viewModelScope.launch f@{
            getItemsUseCase()
        }
    }

}