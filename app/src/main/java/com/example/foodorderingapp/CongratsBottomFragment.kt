package com.example.foodorderingapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
            dismiss()
        }

        return binding.root
    }


}