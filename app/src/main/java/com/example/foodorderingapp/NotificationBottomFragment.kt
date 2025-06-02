package com.example.foodorderingapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.foodorderingapp.databinding.FragmentNotificationBottomBinding
import java.util.ArrayList


class NotificationBottomFragment : Fragment() {
    lateinit var binding: FragmentNotificationBottomBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNotificationBottomBinding.inflate(layoutInflater, container, false)
        val notification = arrayListOf(
            "Your order has been Canceled Successfully",
            "Order has been taken by the driver",
            "Congrats Your Order Placed"
        )
        val notificationImage =
            arrayListOf<Int>(R.drawable.sademoji, R.drawable.truck, R.drawable.congrats)

        val adapter = NotificationAdapter(ArrayList(notification), ArrayList(notificationImage))
        binding.notificationRcv.adapter = adapter

        return binding.root
    }


}