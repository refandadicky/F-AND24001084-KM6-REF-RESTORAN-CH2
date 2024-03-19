package com.example.and_km6_refandadickypradana_challengechapter2.feature.menudetail.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.and_km6_refandadickypradana_challengechapter2.base.ViewHolderBinder
import com.example.and_km6_refandadickypradana_challengechapter2.databinding.LayoutGridmenuBinding
import com.example.and_km6_refandadickypradana_challengechapter2.databinding.LayoutListmenuBinding
import com.example.and_km6_refandadickypradana_challengechapter2.data.model.ListMenu
import com.example.and_km6_refandadickypradana_challengechapter2.utils.toIndonesianFormat

class ListMenuAdapter(
    private val listener: OnItemClickedListener<ListMenu>,
    private val listMode: Int = MODE_LIST
) : RecyclerView.Adapter<ViewHolder>() {

    companion object {
        const val MODE_LIST = 0
        const val MODE_GRID = 1
    }

    private var asyncDataDiffer = AsyncListDiffer(
        this, object : DiffUtil.ItemCallback<ListMenu>() {
            override fun areItemsTheSame(oldItem: ListMenu, newItem: ListMenu): Boolean {
                //membandingkan apakah item tersebut sama
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(oldItem: ListMenu, newItem: ListMenu): Boolean {
                // yang dibandingkan adalah kontennya
                return oldItem.hashCode() == newItem.hashCode()
            }

        }
    )

    fun submitData(items: List<ListMenu>) {
        asyncDataDiffer.submitList(items)
    }


    //creating data
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return if (listMode == MODE_GRID) MenuGridItemViewHolder(
            LayoutGridmenuBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), listener
        ) else {
            MenuListItemViewHolder(
                LayoutListmenuBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                ), listener
            )
        }
    }

    // counting the data size
    override fun getItemCount(): Int = asyncDataDiffer.currentList.size

    //show the data from onCreateViewHolder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (holder !is ViewHolderBinder<*>) return
        (holder as ViewHolderBinder<ListMenu>).bind(asyncDataDiffer.currentList[position])
    }

}

interface OnItemClickedListener<T> {
    fun onItemClicked(item: T)
}