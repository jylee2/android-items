package com.androiditems.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androiditems.models.Item
import com.androiditems.models.Result
import com.androiditems.repositories.IItemsRepository
import com.androiditems.usecases.IGetItemsUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

interface IListViewModel {
    val items: Flow<Result<List<Item>>>
}

class ListViewModel(
    private val getItemsUseCase: IGetItemsUseCase,
    private val itemsRepository: IItemsRepository
) : ViewModel(), IListViewModel {

    override val items = itemsRepository.itemsById.map f@{ result ->
        when (result) {
            is Result.Error<*> -> {
                // TODO: Show error message
                return@f result
            }

            is Result.Success -> {
                val items = result.data.toList().map { it.second }
                return@f Result.Success(items)
            }

            else -> {
                // TODO: Show loading indicator
                return@f Result.Loading
            }
        }
    }

    init {
        viewModelScope.launch f@{
            getItemsUseCase().collect { }
        }
    }

}