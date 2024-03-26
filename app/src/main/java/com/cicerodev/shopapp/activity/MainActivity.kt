package com.cicerodev.shopapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.cicerodev.shopapp.R
import com.cicerodev.shopapp.adapter.PopularAdapter
import com.cicerodev.shopapp.databinding.ActivityMainBinding
import com.cicerodev.shopapp.domain.PopularDomain

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        statusBarColor()
        initRecyclerView()
    }

    private fun statusBarColor() {
        val window = window
        window.statusBarColor = ContextCompat.getColor(this, R.color.purple_dark)
    }

    private fun initRecyclerView() {
        val  popularItems = ArrayList<PopularDomain>()
        popularItems.add(PopularDomain("Camisa preta", "item_1", 15,4.0, 0, 500.0, "AAAA"))
        popularItems.add(PopularDomain("Smart Watch", "item_2", 10, 4.5,0,450.0,"BBBBBB"))
        popularItems.add(PopularDomain("Smartphone", "item_3", 3, 4.9, 0, 800.0, "CCCCCC"))

        binding.poularRV.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.poularRV.adapter = PopularAdapter(popularItems, this)
    }
}