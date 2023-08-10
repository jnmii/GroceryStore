package com.example.grocerystore.data.repository

import com.example.grocerystore.data.db.ShoppingDatabase
import com.example.grocerystore.data.db.entities.ShoppingItem

class ShoppingRepository (
    private val db: ShoppingDatabase
){
    suspend fun upsert(item: ShoppingItem)= db.getShoppingDao().upsert(item)

    suspend fun delete(item: ShoppingItem)= db.getShoppingDao().delete(item)

    fun getAllShoppingItems() = db.getShoppingDao().getAllShoppingItems()
}