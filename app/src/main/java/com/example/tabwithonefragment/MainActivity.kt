package com.example.tabwithonefragment

import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tabwithonefragment.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val selectedTabBackground: Drawable =
            resources.getDrawable(R.drawable.category_selected_bg, theme)
        val defaultTabBackground: Drawable =
            resources.getDrawable(R.drawable.category_unselected_bg, theme)

        val categories =
            listOf("Barchasi", "Pitssa", "Milliy", "Shirinliklar", "Desert", "Muzqaymoqlar")
        val adapter = MyPagerAdapter(this, categories)
        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            if (position == 0) {
                tab.view.background = selectedTabBackground
            }
            tab.text = categories[position]
        }.attach()


        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.let {
                    tab.view.background = selectedTabBackground

                    val message = "Tab ${tab.position + 1} selected: ${tab.text}"
                    Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT).show()
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                tab?.view?.let { view ->
                    view.background = defaultTabBackground // Default background
                }
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })

    }
}