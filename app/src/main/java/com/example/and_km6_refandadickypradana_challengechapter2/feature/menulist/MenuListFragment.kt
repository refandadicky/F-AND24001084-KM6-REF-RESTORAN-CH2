package com.example.and_km6_refandadickypradana_challengechapter2.feature.menulist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.and_km6_refandadickypradana_challengechapter2.R
import com.example.and_km6_refandadickypradana_challengechapter2.feature.menudetail.adapter.ListMenuAdapter
import com.example.and_km6_refandadickypradana_challengechapter2.feature.menudetail.adapter.OnItemClickedListener
import com.example.and_km6_refandadickypradana_challengechapter2.data.datasource.MenuDataSource
import com.example.and_km6_refandadickypradana_challengechapter2.data.datasource.MenuDataSourceImpl
import com.example.and_km6_refandadickypradana_challengechapter2.data.model.ListMenu
import com.example.and_km6_refandadickypradana_challengechapter2.databinding.FragmentMenuListBinding
import com.example.and_km6_refandadickypradana_challengechapter2.feature.menudetail.MenuDetailActivity

class MenuListFragment : Fragment() {

    private lateinit var binding: FragmentMenuListBinding
    private var adapter: ListMenuAdapter? = null
    private val dataSource: MenuDataSource by lazy { MenuDataSourceImpl() }
    private var isUsingGridMode: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentMenuListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindMenulist(isUsingGridMode)
        setClickAction()
    }

    private fun setClickAction() {
        binding.icListmenu.setOnClickListener {
            isUsingGridMode = !isUsingGridMode
            setButtonText(isUsingGridMode)
            bindMenulist(isUsingGridMode)
        }
    }

    private fun setButtonText(usingGridMode: Boolean) {
        binding.icListmenu.setImageResource(if (usingGridMode) R.drawable.ic_grid_view else R.drawable.ic_list)
    }

    private fun bindMenulist(isUsingGrid: Boolean) {
        val listMode = if (isUsingGrid) ListMenuAdapter.MODE_GRID else ListMenuAdapter.MODE_LIST
        adapter = ListMenuAdapter(
            listMode = listMode,
            listener = object : OnItemClickedListener<ListMenu> {
                override fun onItemClicked(item: ListMenu) {
                    navigateToDetail(item)
                }
            })
        binding.rvListmenu.apply {
            adapter = this@MenuListFragment.adapter
            layoutManager = GridLayoutManager(requireContext(),if (isUsingGrid) 2 else 1)
        }
        adapter?.submitData(dataSource.getMenuList())
    }

    private fun navigateToDetail(item: ListMenu){
        val navController = findNavController()
        val bundle = bundleOf(Pair(MenuDetailActivity.EXTRAS_ITEM,item))
        navController.navigate(R.id.action_menuListFragment_to_menuDetailActivity, bundle)
    }

}