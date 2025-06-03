package com.example.foodorderingapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.denzcoskun.imageslider.models.SlideModel
import com.example.foodorderingapp.Adapter.CartAdapter
import com.example.foodorderingapp.Adapter.PopularAdapter
import com.example.foodorderingapp.databinding.FragmentCartBinding


class CartFragment : Fragment() {
    lateinit var binding: FragmentCartBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartBinding.inflate(layoutInflater, container, false)


        val foodName = listOf("Cake", "Momo", "Ice Cream", "Soup", "Pasta", "Sharma", "Platter")
        val price = listOf("$3", "$2", "$4", "$5", "$4", "$3", "$6")
        val foodImage =
            listOf(
                R.drawable.menu1,
                R.drawable.menu2,
                R.drawable.menu3,
                R.drawable.menu4,
                R.drawable.menu5,
                R.drawable.menu6,
                R.drawable.menu7,
            )

        val adapter = CartAdapter(ArrayList(foodName), ArrayList(price), ArrayList(foodImage))
        binding.cartRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.cartRecyclerView.adapter = adapter

        binding.proceedBtn.setOnClickListener {
            findNavController().navigate(R.id.action_cartFragment_to_pay_Out_Fragment)

        }
        return binding.root
    }




}