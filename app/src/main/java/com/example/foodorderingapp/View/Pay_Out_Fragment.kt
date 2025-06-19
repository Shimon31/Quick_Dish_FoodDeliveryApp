package com.example.foodorderingapp.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.foodorderingapp.databinding.FragmentPayOutBinding


class Pay_Out_Fragment : Fragment() {

    lateinit var binding:FragmentPayOutBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPayOutBinding.inflate(layoutInflater,container,false)

        binding.placedBtn.setOnClickListener {

            val bottomSheet = CongratsBottomFragment()
            bottomSheet.show(parentFragmentManager,"test")

        }

        return binding.root
    }


}