package com.example.grocerystore.other

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.grocerystore.data.db.entities.ShoppingItem
import com.example.grocerystore.ui.shoppinglist.ShoppingViewModel
import com.example.myapplication.databinding.ShoppingItemBinding

class ShoppingItemAdapter(
    private var items: List<ShoppingItem>,
    private val viewModel: ShoppingViewModel
) : RecyclerView.Adapter<ShoppingItemAdapter.ShoppingViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val binding = ShoppingItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ShoppingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val curShoppingItem = items[position]

        with(holder.binding) {
            tvName.text = curShoppingItem.name
            tvAmount.text = "${curShoppingItem.amount}"

            ivDelete.setOnClickListener {
                viewModel.delete(curShoppingItem)
            }

            ivPlus.setOnClickListener {
                curShoppingItem.amount++
                viewModel.upsert(curShoppingItem)
            }

            ivMinus.setOnClickListener {
                if (curShoppingItem.amount > 0) {
                    curShoppingItem.amount--
                    viewModel.upsert(curShoppingItem)
                }
            }
        }
    }

    override fun getItemCount(): Int = items.size

    fun setData(newItems: List<ShoppingItem>) {
        items = newItems
        notifyDataSetChanged()
    }

    inner class ShoppingViewHolder(val binding: ShoppingItemBinding) :
        RecyclerView.ViewHolder(binding.root)
}
