package com.example.foodorderingapp.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodorderingapp.databinding.CartItemBinding

class CartAdapter(
    private val cartItemName: MutableList<String>,
    private val cartItemPrice: MutableList<String>,
    private val cartItemImage: MutableList<Int>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = CartItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CartViewHolder(binding)
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }

    class CartViewHolder(val binding: CartItemBinding) : RecyclerView.ViewHolder(binding.root)

    fun bind(position: Int) {


    }
}