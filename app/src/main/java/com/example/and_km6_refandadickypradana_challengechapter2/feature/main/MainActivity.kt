package com.example.and_km6_refandadickypradana_challengechapter2.feature.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.and_km6_refandadickypradana_challengechapter2.R
import com.example.and_km6_refandadickypradana_challengechapter2.feature.menudetail.adapter.CategoryAdapter
import com.example.and_km6_refandadickypradana_challengechapter2.feature.menudetail.adapter.ListMenuAdapter
import com.example.and_km6_refandadickypradana_challengechapter2.databinding.ActivityMainBinding
import com.example.and_km6_refandadickypradana_challengechapter2.data.model.Category
import com.example.and_km6_refandadickypradana_challengechapter2.data.model.ListMenu


class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val categoryAdapter = CategoryAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setListCategory()
    }

    private fun setListCategory() {
        val data = listOf(
            Category(image = R.drawable.ic_category_rice, name = "Nasi"),
            Category(image = R.drawable.ic_category_mie, name = "Mie"),
            Category(image = R.drawable.ic_category_snack, name = "Snack"),
            Category(image = R.drawable.ic_category_drink, name = "Minuman"),
            Category(image = R.drawable.ic_category_meatball, name = "Bakso"),
            Category(image = R.drawable.ic_category_satay, name = "Sate"),
            Category(image = R.drawable.ic_category_chicken, name = "Ayam"),
        )
        binding.rvCategory.apply {
            adapter = this@MainActivity.categoryAdapter
        }
        categoryAdapter.submitData(data)
    }


}