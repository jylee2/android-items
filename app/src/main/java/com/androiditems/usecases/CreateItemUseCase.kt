package com.androiditems.usecases

import com.androiditems.models.Item
import com.androiditems.models.Result
import com.androiditems.repositories.IItemsRepository


interface ICreateItemUseCase {
    suspend operator fun invoke(item: Item): Result<Item>
}

class CreateItemUseCase(
    private val itemsRepository: IItemsRepository
) : ICreateItemUseCase {

    override suspend fun invoke(item: Item): Result<Item> {
        // TODO: Add validation
        if (item.id.isBlank()) {
            return Result.Error<Item>(Exception("ID cannot be blank"))
        }

        // If validation passes, delegate to repository
        return itemsRepository.createItem(item)
    }

}