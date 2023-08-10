package com.example.grocerystore.ui.shoppinglist

import com.example.grocerystore.data.db.entities.ShoppingItem

interface AddDialogListener {
    fun onAddButtonClicked(item: ShoppingItem)
}