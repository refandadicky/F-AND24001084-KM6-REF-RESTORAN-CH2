package com.example.and_km6_refandadickypradana_challengechapter2.feature.menudetail.adapter

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.and_km6_refandadickypradana_challengechapter2.base.ViewHolderBinder
import com.example.and_km6_refandadickypradana_challengechapter2.databinding.LayoutListmenuBinding
import com.example.and_km6_refandadickypradana_challengechapter2.data.model.ListMenu
import com.example.and_km6_refandadickypradana_challengechapter2.utils.toIndonesianFormat

class MenuListItemViewHolder(
    private val binding: LayoutListmenuBinding,
    private val listener: OnItemClickedListener<ListMenu>
) : ViewHolder(binding.root), ViewHolderBinder<ListMenu> {
    override fun bind(item: ListMenu) {
        item.let {
            binding.tvListmenuName.text = item.name
            binding.tvListmenuPrice.text = item.price.toIndonesianFormat()
            binding.ivListmenuImage.setImageResource(item.image)
            itemView.setOnClickListener {
                listener.onItemClicked(item)
            }
        }
    }
}