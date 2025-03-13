package com.androiditems.repositories

import com.androiditems.models.Item

interface IItemsRepository {
    fun loadItems()
    fun createItem(item: Item)
    fun updateItem(item: Item)
    fun deleteItem(item: Item)
}

class ItemsRepository(
//    private val cache: ICache,
//    private val itemsService: IItemsService
): IItemsRepository {

    override fun loadItems() {

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