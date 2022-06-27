package com.example.android.tour_guide_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.android.tour_guide_app.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout
    private lateinit var pagerAdapter: ViewPagerAdapter
    private val tabNames: Array<String> = arrayOf("Рестораны", "Фитнес центры", "Кинотеатры")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setSupportActionBar(binding.toolbar)
        setContentView(binding.root)

        viewPager = binding.pager
        pagerAdapter = ViewPagerAdapter(this)
        viewPager.adapter = pagerAdapter

        tabLayout = binding.tabLayout
        TabLayoutMediator(tabLayout, viewPager){
            tab, position -> tab.text = tabNames[position]
        }.attach()


    }
}