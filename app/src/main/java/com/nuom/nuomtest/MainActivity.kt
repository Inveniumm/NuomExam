package com.nuom.nuomtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.nuom.nuomtest.databinding.ActivityMainBinding
import com.nuom.nuomtest.functionality.SectionsPagerAdapter


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(
            this, R.layout.activity_main)

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        //val viewPager: ViewPager = findViewById(R.id.view_pager)
        binding.viewPager.adapter = sectionsPagerAdapter
        //val tabs: TabLayout = findViewById(R.id.tabs)
//        binding.tabs.setupWithViewPager(binding.viewPager)
        //val fab: FloatingActionButton = findViewById(R.id.fab)

//        binding.fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show()
//        }
    }
}