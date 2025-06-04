package com.example.foodorderingapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.foodorderingapp.databinding.FragmentCongratsBottomBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class CongratsBottomFragment : BottomSheetDialogFragment() {

    lateinit var binding : FragmentCongratsBottomBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCongratsBottomBinding.inflate(layoutInflater,container,false)

        binding.goHomeTV.setOnClickListener {
            findNavController().navigate(R.id.action_pay_Out_Fragment_to_homeFragment)
            dismiss()
            //complete
        }

        return binding.root
    }


}