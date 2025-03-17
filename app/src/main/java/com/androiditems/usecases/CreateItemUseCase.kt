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

    private val idRegex = Regex("^[a-zA-Z0-9]+$")
    private val nameRegex = Regex("^[a-zA-Z0-9 ]+$")

    override suspend fun invoke(item: Item): Result<Item> {
        // Validate ID
        if (item.id.isBlank()) {
            return Result.Error<Item>(Exception("ID cannot be blank"))
        }
//        if (!item.id.matches(idRegex)) {
//            throw Exception("ID must be alphanumeric (a-z, A-Z, 0-9)")
//        }
//
//        // Validate Name
//        if (item.name.isEmpty()) {
//            throw Exception("Name cannot be empty")
//        }
//        if (item.name.length < 2 || item.name.length > 50) {
//            throw Exception("Name must be between 2 and 50 characters")
//        }
//        if (!item.name.matches(nameRegex)) {
//            throw Exception("Name must contain only letters, numbers, and spaces")
//        }

        // If validation passes, delegate to repository
        return itemsRepository.createItem(item)
    }

}