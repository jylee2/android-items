package com.androiditems.repositories

import com.androiditems.models.Item
import com.androiditems.models.Result
import com.androiditems.services.IItemsService

interface IItemsRepository {
    fun loadItems(): Result<List<Item>>
    fun createItem(item: Item)
    fun updateItem(item: Item)
    fun deleteItem(item: Item)
}

class ItemsRepository(
//    private val cache: ICache, // TODO: Add caching
    private val itemsService: IItemsService
): IItemsRepository {

    override fun loadItems(): Result<List<Item>> {
        // TODO: call service method
        return Result.Loading
    }

    override fun createItem(item: Item) {
        TODO("Not yet implemented")
    }

    override fun updateItem(item: Item) {
        TODO("Not yet implemented")
    }

    override fun deleteItem(item: Item) {
        TODO("Not yet implemented")
    }

}