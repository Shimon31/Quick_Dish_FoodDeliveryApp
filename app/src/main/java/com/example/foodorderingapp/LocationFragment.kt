package com.example.foodorderingapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.foodorderingapp.databinding.FragmentLocationBinding

class LocationFragment : Fragment() {

    lateinit var binding: FragmentLocationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLocationBinding.inflate(layoutInflater, container, false)
        return binding.root
        val locationList = arrayOf(
            "Dhaka",
            "Chittagong",
            "Sylhet",
            "Khulna",
            "Barisal",
            "Mymensingh",
            "Rajshahi",
            "Rangpur"
        )

        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, locationList)
        val autoCompleteTextView = binding.listOfLocation
        autoCompleteTextView.setAdapter(adapter)


    }
}
