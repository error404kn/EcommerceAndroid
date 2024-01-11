package com.example.itstepproject.fragments.shopping

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.itstepproject.R
import com.example.itstepproject.adapters.HomeViewpagerAdapter
import com.example.itstepproject.databinding.FragmentHomeBinding
import com.example.itstepproject.fragments.categories.ChairFragment
import com.example.itstepproject.fragments.categories.HeadsetFragment
import com.example.itstepproject.fragments.categories.KeyboardFragment
import com.example.itstepproject.fragments.categories.LaptopFragment
import com.example.itstepproject.fragments.categories.MainCategoryFragment
import com.example.itstepproject.fragments.categories.MouseFragment
import com.example.itstepproject.fragments.categories.MousePadFragment
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment: Fragment(R.layout.fragment_home) {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val categoriesFragments = arrayListOf<Fragment>(
            MainCategoryFragment(),
            LaptopFragment(),
            MouseFragment(),
            MousePadFragment(),
            HeadsetFragment(),
            KeyboardFragment(),
            ChairFragment()
        )

        binding.viewPagerHome.isUserInputEnabled = false

        val viewPager2Adapter = HomeViewpagerAdapter(categoriesFragments, childFragmentManager, lifecycle)
        binding.viewPagerHome.adapter = viewPager2Adapter
        TabLayoutMediator(binding.tabLayout, binding.viewPagerHome){ tab, position ->
            when(position){
                0 -> tab.text = "მთავარი გვერდი"
                1 -> tab.text = "ლეპტოპები"
                2 -> tab.text = "მაუსები"
                3 -> tab.text = "მაუს პედები"
                4 -> tab.text = "ყურსასმენები"
                5 -> tab.text = "კლავიატურები"
                6 -> tab.text = "სავარძლები"

            }
        }.attach()
    }
}