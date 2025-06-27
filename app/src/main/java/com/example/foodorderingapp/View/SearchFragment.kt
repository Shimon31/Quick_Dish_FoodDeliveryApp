package com.example.foodorderingapp.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodorderingapp.Adapter.MenuAdapter
import com.example.foodorderingapp.R
import com.example.foodorderingapp.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding
    private lateinit var adapter: MenuAdapter

    private val originalFoodName = listOf("Cake", "Momo", "Ice Cream", "Soup", "Pasta", "Sharma", "Platter")
    private val originalPrice = listOf("$3", "$2", "$4", "$5", "$4", "$3", "$6")
    private val originalFoodImage = listOf(
        R.drawable.menu1,
        R.drawable.menu2,
        R.drawable.menu3,
        R.drawable.menu4,
        R.drawable.menu5,
        R.drawable.menu6,
        R.drawable.menu7
    )

    private val filterFoodName = mutableListOf<String>()
    private val filterPrice = mutableListOf<String>()
    private val filterImage = mutableListOf<Int>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(inflater, container, false)

        adapter = MenuAdapter(filterFoodName, filterPrice, filterImage)
        binding.menuRcv.layoutManager = LinearLayoutManager(requireContext())
        binding.menuRcv.adapter = adapter

        // Initially show all items
        filterQueryMenuItems("")

        setUpSearchView()

        showAllMenu()
        return binding.root
    }

    private fun showAllMenu() {
        filterFoodName.clear()
        filterPrice.clear()
        filterImage.clear()

        filterFoodName.addAll(originalFoodName)
        filterPrice.addAll(originalPrice)
        filterImage.addAll(originalFoodImage)
        adapter.notifyDataSetChanged() // Make sure adapter updates
    }


    private fun setUpSearchView() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                filterQueryMenuItems(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterQueryMenuItems(newText)
                return true
            }
        })
    }

    private fun filterQueryMenuItems(query: String?) {
        filterFoodName.clear()
        filterPrice.clear()
        filterImage.clear()

        originalFoodName.forEachIndexed { index, foodName ->
            if (query.isNullOrEmpty() || foodName.contains(query, ignoreCase = true)) {
                filterFoodName.add(foodName)
                filterPrice.add(originalPrice[index])
                filterImage.add(originalFoodImage[index])
            }
        }
        adapter.notifyDataSetChanged()
    }
}
