package com.example.foodorderingapp.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.foodorderingapp.R
import com.example.foodorderingapp.databinding.FragmentOnBoarding1Binding

class onBoarding1Fragment : Fragment() {
    lateinit var binding: FragmentOnBoarding1Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnBoarding1Binding.inflate(layoutInflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.nextBtn.setOnClickListener {
            findNavController().navigate(R.id.action_onBoarding1Fragment_to_loginFragment)
        }
    }


}