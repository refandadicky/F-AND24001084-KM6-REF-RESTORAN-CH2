package com.example.and_km6_refandadickypradana_challengechapter2.feature.menudetail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.and_km6_refandadickypradana_challengechapter2.databinding.LayoutCategoryBinding
import com.example.and_km6_refandadickypradana_challengechapter2.data.model.Category

class CategoryAdapter : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {
    private val data = mutableListOf<Category>()

    fun submitData(items: List<Category>) {
        data.addAll(items)
    }

    class CategoryViewHolder(private val binding: LayoutCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Category) {

            binding.tvCategoryName.text = item.name
            binding.ivCategoryImage.setImageResource(item.image)

        }
    }

    //creating data
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(
            LayoutCategoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    // counting the data size
    override fun getItemCount(): Int = data.size

    //show the data from onCreateViewHolder
    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(data[position])
    }
}