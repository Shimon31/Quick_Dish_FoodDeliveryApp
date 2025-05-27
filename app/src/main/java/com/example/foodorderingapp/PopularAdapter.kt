package com.example.foodorderingapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodorderingapp.databinding.ItemDesignBinding

class PopularAdapter(private val itemList: List<String>, private val imageList: List<Int>) :
    RecyclerView.Adapter<PopularAdapter.PopularViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        val binding = ItemDesignBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PopularViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        holder.bind(itemList[position], imageList[position])
    }

    class PopularViewHolder(private val binding: ItemDesignBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: String, imageRes: Int) {



        }
    }
}
