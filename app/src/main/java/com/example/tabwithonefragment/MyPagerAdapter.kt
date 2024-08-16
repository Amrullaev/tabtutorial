package com.example.tabwithonefragment

import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class MyPagerAdapter(
    fragmentActivity: FragmentActivity,
    private val categories: List<String>
) : FragmentStateAdapter(fragmentActivity) {

    override fun createFragment(position: Int) =
        MyFragment.newInstance(categories[position])

    override fun getItemCount(): Int = categories.size
}