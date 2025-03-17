package com.androiditems.models

import kotlinx.serialization.Serializable

@Serializable
data class Item(val id: String, val name: String) {
    // Not required, id.equals() already exists
//    fun equals(other: Item): Boolean =
//        this.id == other.id && this.name == other.name

}

sealed class Result<out T> {
    object Loading : Result<Nothing>()
    data class Success<T>(val data: T): Result<T>()
    data class Error<T>(val exception: Throwable) : Result<Nothing>()
}