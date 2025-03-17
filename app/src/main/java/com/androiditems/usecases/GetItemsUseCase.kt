package com.androiditems.usecases

import com.androiditems.repositories.IItemsRepository

interface IGetItemsUseCase {
    suspend operator fun invoke()
}

class GetItemsUseCase(
    private val itemsRepository: IItemsRepository
) : IGetItemsUseCase {

    /**
     * Depends on the backend
     */
    override suspend operator fun invoke() {
        val repositoryResult = itemsRepository.loadItems()

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