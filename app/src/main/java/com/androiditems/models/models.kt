package com.androiditems.models

data class Item(val id: String, val name: String) {

    fun equals(other: Item): Boolean =
        this.id == other.id && this.name == other.name

}