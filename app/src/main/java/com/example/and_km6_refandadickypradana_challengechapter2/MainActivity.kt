package com.example.and_km6_refandadickypradana_challengechapter2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.and_km6_refandadickypradana_challengechapter2.databinding.ActivityMainBinding
import com.example.and_km6_refandadickypradana_challengechapter2.model.Category
import com.example.and_km6_refandadickypradana_challengechapter2.model.ListMenu

// aproach by find by id
//class MainActivity : AppCompatActivity() {
//    private val icProfile : ImageView by lazy {
//        findViewById(R.id.iv_profile)
//    }
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        setAction()
////        changeProfileIcon()
//    }
//    private fun changeProfileIcon(){
//        icProfile?.setImageResource(R.drawable.img_pp)
//    }
//
//    private fun setAction(){
//        icProfile?.setOnClickListener{
//            Toast.makeText(this@MainActivity, "Refanda ganteng", Toast.LENGTH_SHORT).show()
//        }
//    }
//
//}
// aproach by binding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val categoryAdapter = CategoryAdapter()
    private val listMenuAdapter = ListMenuAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setAction()
        setListCategory()
        setListMenu()
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

    private fun setListMenu() {
        val data = listOf(
            ListMenu(image = R.drawable.img_menu_grilled_chicken, name = "Ayam Bakar", price = "Rp 50.000"),
            ListMenu(image = R.drawable.img_menu_fried_chicken, name = "Ayam Goreng", price = "Rp 40.000"),
            ListMenu(image = R.drawable.img_menu_chicken_smashed, name = "Ayam Geprek", price = "Rp 40.000"),
            ListMenu(image = R.drawable.img_menu_chicken_intestine_satay, name = "Sate Usus Ayam", price = "Rp 5.000"),
            ListMenu(image = R.drawable.img_menu_french_fries, name = "Kentang Goreng", price = "Rp 15.000"),
            ListMenu(image = R.drawable.img_menu_ice_coffee, name = "Ice Coffee", price = "Rp 35.000"),
        )
        binding.rvListmenu.apply {
            adapter = this@MainActivity.listMenuAdapter
        }
        listMenuAdapter.submitData(data)
    }

    private fun setAction(){
        binding.layoutHeader.ivProfile.setOnClickListener{
            Toast.makeText(this@MainActivity, "Refanda ganteng", Toast.LENGTH_SHORT).show()
        }
    }

}