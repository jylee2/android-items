package com.androiditems.repositories

import com.androiditems.models.Item
import com.androiditems.models.Result
import com.androiditems.services.IItemsService

interface IItemsRepository {
    suspend fun loadItems(): Result<List<Item>>
    suspend fun createItem(item: Item): Result<Item>
    suspend fun updateItem(item: Item): Result<Item>
    suspend fun deleteItem(item: Item): Result<String>
}

class ItemsRepository(
//    private val cache: ICache, // TODO: Add caching
    private val itemsService: IItemsService
): IItemsRepository {

    override suspend fun loadItems(): Result<List<Item>> {
        // TODO: If not in cache, then fetch from API
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