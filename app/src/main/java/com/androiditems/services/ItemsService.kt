package com.androiditems.services

import com.androiditems.models.Item
import com.androiditems.models.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json

interface IItemsService {
    suspend fun loadItems(): Result<ByteArray>
    suspend fun createItem(item: Item): Result<Item>
    suspend fun updateItem(item: Item): Result<Item>
    suspend fun deleteItem(item: Item): Result<String>
}

class ItemsService() : IItemsService {
    override suspend fun loadItems(): Result<ByteArray> {
        TODO("Not yet implemented")
//        return withContext(Dispatchers.IO) f@{
//            try {
//                val url = "example.com/endpoint"
//                val (_, response, _) = Fuel.get(url)
//                    .timeout(20000)
//                    .awaitStringResponseResult()
//                if (!response.isSuccessful) {
//                    throw Exception("error downloading items $url - ${response.statusCode}: ${response.responseMessage}")
//                }
//                return@f Result.Success(response.data)
//            } catch (e: Exception) {
//                return@f Result.Error(e)
//            }
//        }
    }

    override suspend fun createItem(item: Item): Result<Item> {
        TODO("Not yet implemented")
//        return withContext(Dispatchers.IO) f@{
//            try {
//                val json = Json { ignoreUnknownKeys = true }
//                val jsonBody = json.encodeToString(Item.serializer(), item)
//                val (_, _, result) = Fuel.post(path = endPoint, parameters = null)
//                    .jsonBody(jsonBody)
//                    .timeout(20000)
//                    .awaitStringResponseResult()
//                val isSuccess = result.toString().lowercase().contains("success")
//                if (isSuccess) {
//                    return@f Result.Success(item)
//                }
//                throw Exception(result.toString())
//            } catch (e: Exception) {
//                return@f Result.Error(e)
//            }
//        }
    }

    override suspend fun updateItem(item: Item): Result<Item> {
        TODO("Not yet implemented")
    }

    override suspend fun deleteItem(item: Item): Result<String> {
        TODO("Not yet implemented")
    }

}