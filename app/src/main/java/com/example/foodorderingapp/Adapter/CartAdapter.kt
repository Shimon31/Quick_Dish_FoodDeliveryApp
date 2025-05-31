package com.example.foodorderingapp.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodorderingapp.databinding.CartItemBinding

class CartAdapter(
    private val cartItemName: MutableList<String>,
    private val cartItemPrice: MutableList<String>,
    private val cartItemImage: MutableList<Int>
) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    var itemQuantities = IntArray(cartItemName.size) { 1 }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding = CartItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CartViewHolder(binding)
    }

    override fun getItemCount(): Int = cartItemName.size

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bind(
            cartItemName[position],
            cartItemPrice[position],
            cartItemImage[position],
            itemQuantities[position],
            position,
            this
        )
    }

    class CartViewHolder(private val binding: CartItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            name: String,
            price: String,
            imageRes: Int,
            quantity: Int,
            position: Int,
            adapter: CartAdapter
        ) {
            binding.apply {
                itemName.text = name
                itemPrice.text = price
                itemIV.setImageResource(imageRes)
                cartQuantity.text = quantity.toString()

                plusIV.setOnClickListener {
                    adapter.itemQuantities[position]++
                    adapter.notifyItemChanged(position)
                }

                minusIV.setOnClickListener {
                    if (adapter.itemQuantities[position] > 1) {
                        adapter.itemQuantities[position]--
                        adapter.notifyItemChanged(position)
                    }
                }

                deleteIV.setOnClickListener {
                    adapter.cartItemName.removeAt(position)
                    adapter.cartItemPrice.removeAt(position)
                    adapter.cartItemImage.removeAt(position)

                    adapter.itemQuantities = adapter.itemQuantities.toMutableList().apply {
                        removeAt(position)
                    }.toIntArray()

                    adapter.notifyItemRemoved(position)
                    adapter.notifyItemRangeChanged(position, adapter.itemCount)
                }
            }
        }
    }
}
