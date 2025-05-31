package com.example.foodorderingapp.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodorderingapp.databinding.MenuItemBinding

class MenuAdapter(
    private val itemList: List<String>,
    private val price: List<String>,
    private val imageList: List<Int>
) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val binding = MenuItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MenuViewHolder(binding)
    }

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(itemList[position], price[position], imageList[position])
    }

    class MenuViewHolder(private val binding: MenuItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: String, price: String, imageRes: Int) {
            binding.itemName.text = item
            binding.itemPrice.text = price
            binding.itemIV.setImageResource(imageRes)
        }
    }
}
