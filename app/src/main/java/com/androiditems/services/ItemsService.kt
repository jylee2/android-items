package com.androiditems.services

import com.androiditems.models.Item
import com.androiditems.models.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json

interface IItemsService {
    suspend fun loadItems(): ByteArray
    suspend fun createItem(item: Item)
    suspend fun updateItem(item: Item)
    suspend fun deleteItem(item: Item)
}

class ItemsService() : IItemsService {
    override suspend fun loadItems(): ByteArray {
        TODO("Not yet implemented")
//        return withContext(Dispatchers.IO) f@{
//            val url = "example.com/endpoint"
//            val (_, response, _) = Fuel.get(url)
//                .timeout(20000)
//                .awaitStringResponseResult()
//            if (!response.isSuccessful) {
//                throw Exception("error downloading items $url - ${response.statusCode}: ${response.responseMessage}")
//            }
//            return@f response.data
//        }
    }

    override suspend fun createItem(item: Item) {
        TODO("Not yet implemented")
    }

    override suspend fun updateItem(item: Item) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteItem(item: Item) {
        TODO("Not yet implemented")
    }

}