package com.androiditems.repositories

import com.androiditems.models.Item
import com.androiditems.models.Result
import com.androiditems.services.IItemsService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

interface IItemsRepository {
    suspend fun loadItems(): Result<List<Item>>
    suspend fun createItem(item: Item): Result<Item>
    suspend fun updateItem(item: Item): Result<Item>
    suspend fun deleteItem(item: Item): Result<String>
}

class ItemsRepository(
    private val itemsService: IItemsService
): IItemsRepository {

    override suspend fun loadItems(): Result<List<Item>> {
        // TODO: implement
//        val result = itemsService.loadItems()
//        when(result) {
//            is Result.Error<*> -> return result
//            is Result.Success -> {
//                val byteArray = result.data
//                val items = Item.decodeFromJsonString(
//                    data = byteArray.decodeToString(),
//                    jsonConfig = JsonConfig(ignoreUnknownFieldsInInput = true)
//                )
//                return Result.Success(items)
//            }
//            else -> return Result.Loading
//        }
        return Result.Loading
    }

    override suspend fun createItem(item: Item): Result<Item> {
        return itemsService.createItem(item)
    }

    override suspend fun updateItem(item: Item): Result<Item> {
        TODO("Not yet implemented")
    }

    override suspend fun deleteItem(item: Item): Result<String> {
        TODO("Not yet implemented")
    }

}