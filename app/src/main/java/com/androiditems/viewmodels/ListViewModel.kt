package com.androiditems.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androiditems.models.Item
import com.androiditems.models.Result
import com.androiditems.repositories.IItemsRepository
import com.androiditems.usecases.IGetItemsUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

interface IListViewModel {
    val items: Flow<Result<List<Item>>>
}

class ListViewModel(
    private val getItemsUseCase: IGetItemsUseCase,
    private val itemsRepository: IItemsRepository
) : ViewModel(), IListViewModel {

    // TODO: map to UI-friendly data structure
    override val items = itemsRepository.items

    init {
        viewModelScope.launch f@{
            getItemsUseCase()
        }
    }

}