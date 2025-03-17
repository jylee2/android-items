package com.androiditems.repositories

import com.androiditems.models.Item
import com.androiditems.models.Result
import com.androiditems.services.IItemsService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

interface IItemsRepository {
    val itemsById: StateFlow<Result<Map<String, Item>>>
    suspend fun loadItems(): Result<Map<String, Item>>
    fun getItemById(id: String): Result<Item>
    suspend fun createItem(item: Item): Result<Item>
    suspend fun updateItem(item: Item): Result<Item>
    suspend fun deleteItem(item: Item): Result<String>
}

class ItemsRepository(
    private val itemsService: IItemsService
) : IItemsRepository {

    private val _itemsById = MutableStateFlow<Result<Map<String, Item>>>(Result.Loading)
    override val itemsById = _itemsById.asStateFlow()

    override suspend fun loadItems(): Result<Map<String, Item>> {
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

    override fun getItemById(id: String): Result<Item> {
        val itemsResult = itemsById.value
        if (itemsResult is Result.Loading) {
            return Result.Loading
        }

        if (itemsResult is Result.Success) {
            val foundItem = itemsResult.data[id]
            if (foundItem != null) {
                return Result.Success(foundItem)
            }
        }

        return Result.Error<Item>(Exception("Item not found for id = $id."))
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