package com.androiditems.usecases

import com.androiditems.models.Item
import com.androiditems.models.Result
import com.androiditems.repositories.IItemsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow

interface IGetItemsUseCase {
    val items: StateFlow<Result<List<Item>>>
    suspend operator fun invoke(): Flow<Unit>
}

class GetItemsUseCase(
    private val itemsRepository: IItemsRepository
) : IGetItemsUseCase {

    private val _items = MutableStateFlow<Result<List<Item>>>(Result.Loading)
    override val items = _items.asStateFlow()

    /**
     * Depends on the backend
     */
    override suspend operator fun invoke(): Flow<Unit> {
        val repositoryResult = itemsRepository.loadItems()
        _items.value = repositoryResult

        return flow {
            // TODO: add snapshot listener to get the latest items
//            try {
//                Firebase
//                    .firestore(FirebaseApp.initializeApp(context, options, envKey))
//                    .collection()
//                    .addSnapshotListener f@{ snapshot, error ->
//                        if (snapshot == null) {
//                            return@f
//                        }
//                        val newItems = snapshot.documents.map g@{
//                            val jsonString = it.data.toJsonString()
//                            val newItem = Item.decodeFromJsonString(
//                                data = jsonString,
//                                jsonConfig = JsonConfig(ignoreUnknownFieldsInInput = true)
//                            )
//                            return@g newItem
//                        }
//                        _items.value = Result.Success(newItems)
//                    }
//            } catch (e: Exception) {
//               recordException(e)
//            }
        }
    }
}