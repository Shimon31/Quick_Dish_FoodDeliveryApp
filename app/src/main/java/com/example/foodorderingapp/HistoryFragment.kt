package com.example.foodorderingapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodorderingapp.Adapter.BuyAgainAdapter
import com.example.foodorderingapp.databinding.FragmentHistoryBinding
import com.example.foodorderingapp.databinding.HistoryItemBinding


class HistoryFragment : Fragment() {

    lateinit var binding: FragmentHistoryBinding
    private lateinit var buyAgainAdapter: BuyAgainAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHistoryBinding.inflate(layoutInflater, container, false)
        setUpRecyclerView()
        return binding.root
    }

    private fun setUpRecyclerView() {
        val buyAgainFoodName =
            arrayListOf("soup", "Sharma", "Chicken", "Ice-Cream", "Pasta", "Cake")
        val buyAgainFoodPrice = arrayListOf("$4", "$10", "$6", "$12", "$10", "$5")
        val buyAgainFoodImage =
            arrayListOf(
                R.drawable.menu4,
                R.drawable.menu6,
                R.drawable.menu2,
                R.drawable.menu3,
                R.drawable.menu5,
                R.drawable.menu1
            )

        buyAgainAdapter = BuyAgainAdapter(buyAgainFoodName, buyAgainFoodPrice, buyAgainFoodImage)
        binding.historyRCV.adapter = buyAgainAdapter
    }

}