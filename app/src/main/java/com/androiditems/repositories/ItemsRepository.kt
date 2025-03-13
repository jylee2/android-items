package com.androiditems.repositories

import com.androiditems.models.Item
import com.androiditems.models.Result
import com.androiditems.services.IItemsService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

interface IItemsRepository {
    val items: StateFlow<List<Item>>
    suspend fun loadItems()
    suspend fun createItem(item: Item): Result<Item>
    suspend fun updateItem(item: Item): Result<Item>
    suspend fun deleteItem(item: Item): Result<String>
}

class ItemsRepository(
    private val itemsService: IItemsService
): IItemsRepository {

    private val _items = MutableStateFlow<List<Item>>(mutableListOf())
    override val items = _items.asStateFlow()

    override suspend fun loadItems() {
        // TODO: add snapshot listener to get the latest items
//        try {
//            Firebase
//                .firestore(FirebaseApp.initializeApp(context, options, envKey))
//                .collection()
//                .addSnapshotListener f@{ snapshot, error ->
//                    if (snapshot == null) {
//                        _items.value = Result.Loading
//                        return@f
//                    }
//                    val newItems = snapshot.documents.map g@{
//                        val jsonString = it.data.toJsonString()
//                        val newItem = Item.decodeFromJsonString(
//                            data = jsonString,
//                            jsonConfig = JsonConfig(ignoreUnknownFieldsInInput = true)
//                        )
//                        return@g newItem
//                    }
//                    _items.value = Result.Success(newItems)
//                }
//        } catch (e: Exception) {
//            _items.value = Result.Error(e)
//        }
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