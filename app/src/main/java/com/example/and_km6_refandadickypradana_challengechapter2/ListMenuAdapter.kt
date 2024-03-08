package com.example.and_km6_refandadickypradana_challengechapter2


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.and_km6_refandadickypradana_challengechapter2.databinding.LayoutListmenuBinding
import com.example.and_km6_refandadickypradana_challengechapter2.model.ListMenu

class ListMenuAdapter : RecyclerView.Adapter<ListMenuAdapter.ListMenuViewHolder>() {
    private val data = mutableListOf<ListMenu>()

    fun submitData(items: List<ListMenu>) {
        data.addAll(items)
    }

    class ListMenuViewHolder(private val binding: LayoutListmenuBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ListMenu) {
            binding.tvListmenuName.text = item.name
            binding.tvListmenuPrice.text = item.price
            binding.ivListmenuImage.setImageResource(item.image)

        }
    }

    //creating data
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListMenuViewHolder {
        return ListMenuViewHolder(
            LayoutListmenuBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    // counting the data size
    override fun getItemCount(): Int = data.size

    //show the data from onCreateViewHolder
    override fun onBindViewHolder(holder: ListMenuViewHolder, position: Int) {
        holder.bind(data[position])
    }
}