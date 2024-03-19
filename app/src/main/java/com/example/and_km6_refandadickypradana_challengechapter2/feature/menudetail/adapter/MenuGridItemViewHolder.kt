package com.example.and_km6_refandadickypradana_challengechapter2.feature.menudetail.adapter

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.and_km6_refandadickypradana_challengechapter2.base.ViewHolderBinder
import com.example.and_km6_refandadickypradana_challengechapter2.databinding.LayoutGridmenuBinding
import com.example.and_km6_refandadickypradana_challengechapter2.databinding.LayoutListmenuBinding
import com.example.and_km6_refandadickypradana_challengechapter2.data.model.ListMenu
import com.example.and_km6_refandadickypradana_challengechapter2.utils.toIndonesianFormat

class MenuGridItemViewHolder(
    private val binding: LayoutGridmenuBinding,
    private val listener: OnItemClickedListener<ListMenu>
) : ViewHolder(binding.root), ViewHolderBinder<ListMenu> {
    override fun bind(item: ListMenu) {
        item.let {
            binding.tvGridmenuName.text = item.name
            binding.tvGridmenuPrice.text = item.price.toIndonesianFormat()
            binding.ivGridmenuImage.setImageResource(item.image)
            itemView.setOnClickListener {
                listener.onItemClicked(item)
            }
        }
    }
}