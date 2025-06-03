package com.example.foodorderingapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.foodorderingapp.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)

        binding.notificationBell.setOnClickListener {
            val bottomSheetDialog = NotificationBottomFragment()
            bottomSheetDialog.show(parentFragmentManager, "test")
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navHostFragment = childFragmentManager.findFragmentById(R.id.fragmentContainerView2) as? NavHostFragment
        val navController = navHostFragment?.navController ?: return

        // Setup bottom navigation
        binding.bottomNavigation.setupWithNavController(navController)

        // Handle visibility changes based on destination
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.pay_Out_Fragment -> {
                    // Hide views in Pay_Out_Fragment
                    binding.notificationBell.visibility = View.GONE
                    binding.bottomNavigation.visibility = View.GONE
                    binding.topTitleTv.visibility = View.GONE
                }
                else -> {
                    // Show views in other fragments
                    binding.notificationBell.visibility = View.VISIBLE
                    binding.bottomNavigation.visibility = View.VISIBLE
                }
            }
        }
    }
}
