package com.example.and_km6_refandadickypradana_challengechapter2.feature.menudetail

import android.R.attr.value
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.and_km6_refandadickypradana_challengechapter2.R
import com.example.and_km6_refandadickypradana_challengechapter2.data.model.ListMenu
import com.example.and_km6_refandadickypradana_challengechapter2.databinding.ActivityMenuDetailBinding
import com.example.and_km6_refandadickypradana_challengechapter2.utils.toIndonesianFormat


class MenuDetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRAS_ITEM = "EXTRAS_ITEM"
        fun startActivity(context: Context, person: ListMenu) {
            val intent = Intent(context, MenuDetailActivity::class.java)
            intent.putExtra(EXTRAS_ITEM, person)
            context.startActivity(intent)
        }
    }

    private val binding: ActivityMenuDetailBinding by lazy {
        ActivityMenuDetailBinding.inflate(layoutInflater)
    }
    private var amount = 0
    private var total : Double = 0.0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        getIntentData()
        binding.layoutAddToCart.icPlusCart.setOnClickListener {
            incrementAmount()
        }
        binding.layoutAddToCart.icMinCart.setOnClickListener {
            decrementAmount()
        }
    }

    private fun incrementAmount() {
        amount++
        updateAmountTextView()
    }

    private fun decrementAmount() {
        if (amount > 0) {
            amount--
            updateAmountTextView()
        }
    }

    private fun updateAmountTextView() {
        intent.extras?.getParcelable<ListMenu>(EXTRAS_ITEM)?.let {
            binding.layoutAddToCart.tvAddition.text = amount.toString()
            setTotalPrice(it)
        }
    }

    private fun setTotalPrice(listMenu: ListMenu) {
        total = (listMenu.price * amount)
        binding.layoutAddToCart.btnAddToCart.text =
            getString(R.string.add_to_string, total.toIndonesianFormat())
    }

    private fun getIntentData() {
        intent.extras?.getParcelable<ListMenu>(EXTRAS_ITEM)?.let {
            setProfileImage(it.image)
            setDetailData(it)
        }
    }

    private fun setDetailData(listMenu: ListMenu) {
        binding.layoutMenuDetail.tvDetailName.text = listMenu.name
        binding.layoutMenuDetail.tvDetailPrice.text = listMenu.price.toIndonesianFormat()
        binding.layoutMenuDetail.tvDetailMenu.text = listMenu.detailMenu
        binding.layoutLocationDetail.tvDetailLocation.text = listMenu.address
        binding.layoutLocationDetail.tvDetailLocation.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW)
            i.setData(Uri.parse(listMenu.mapsUrl))
            startActivity(i)

        }
        binding.layoutAddToCart.btnAddToCart.text =
            getString(R.string.add_to_string, total.toIndonesianFormat())
    }

    private fun setProfileImage(image: Int?) {
        image?.let { binding.ivFoodPhoto.setImageResource(it) }
    }

}