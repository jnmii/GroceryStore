package com.example.grocerystore.ui.shoppinglist

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatDialog
import com.example.grocerystore.data.db.entities.ShoppingItem
import com.example.myapplication.databinding.DialogueAddShoppingItemBinding

class AddShoppingItemDialogue(context: Context, private val addDialogListener: AddDialogListener): AppCompatDialog(context) {

    private lateinit var binding: DialogueAddShoppingItemBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DialogueAddShoppingItemBinding.inflate(LayoutInflater.from(context))
        setContentView(binding.root)

        binding.tvAdd.setOnClickListener {
            val name = binding.etName.text.toString()
            val amount = binding.etAmount.text.toString()

            if (name.isEmpty() || amount.isEmpty()) {
                // Handle input validation
            } else {
                val item = ShoppingItem(name, amount.toInt())
                addDialogListener.onAddButtonClicked(item)
                dismiss()
            }
        }

        binding.tvCancel.setOnClickListener {
            cancel()
        }
    }
}
