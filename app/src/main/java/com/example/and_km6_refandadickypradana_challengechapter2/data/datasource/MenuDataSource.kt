package com.example.and_km6_refandadickypradana_challengechapter2.data.datasource

import com.example.and_km6_refandadickypradana_challengechapter2.R
import com.example.and_km6_refandadickypradana_challengechapter2.data.model.ListMenu

interface MenuDataSource{
    fun getMenuList() : List<ListMenu>
}
class MenuDataSourceImpl() : MenuDataSource {
    override fun getMenuList(): List<ListMenu> {
        return mutableListOf(
            ListMenu(image = R.drawable.img_menu_grilled_chicken, name = "Ayam Bakar", price = 50000.0, address = "Jl. BSD Green Office Park Jl. BSD Grand Boulevard, Sampora, BSD, Kabupaten Tangerang, Banten 15345", mapsUrl = "https://maps.app.goo.gl/h4wQKqaBuXzftGK77"),
            ListMenu(image = R.drawable.img_menu_fried_chicken, name = "Ayam Goreng", price = 40000.0, address = "Jl. BSD Green Office Park Jl. BSD Grand Boulevard, Sampora, BSD, Kabupaten Tangerang, Banten 15345", mapsUrl = "https://maps.app.goo.gl/h4wQKqaBuXzftGK77"),
            ListMenu(image = R.drawable.img_menu_chicken_smashed, name = "Ayam Geprek", price = 40000.0, address = "Jl. BSD Green Office Park Jl. BSD Grand Boulevard, Sampora, BSD, Kabupaten Tangerang, Banten 15345", mapsUrl = "https://maps.app.goo.gl/h4wQKqaBuXzftGK77"),
            ListMenu(image = R.drawable.img_menu_chicken_intestine_satay, name = "Sate Usus Ayam", price = 5000.0, address = "Jl. BSD Green Office Park Jl. BSD Grand Boulevard, Sampora, BSD, Kabupaten Tangerang, Banten 15345", mapsUrl = "https://maps.app.goo.gl/h4wQKqaBuXzftGK77"),
            ListMenu(image = R.drawable.img_menu_french_fries, name = "Kentang Goreng", price = 15000.0, address = "Jl. BSD Green Office Park Jl. BSD Grand Boulevard, Sampora, BSD, Kabupaten Tangerang, Banten 15345", mapsUrl = "https://maps.app.goo.gl/h4wQKqaBuXzftGK77"),
            ListMenu(image = R.drawable.img_menu_ice_coffee, name = "Ice Coffee", price = 35000.0, address = "Jl. BSD Green Office Park Jl. BSD Grand Boulevard, Sampora, BSD, Kabupaten Tangerang, Banten 15345", mapsUrl = "https://maps.app.goo.gl/h4wQKqaBuXzftGK77")
        )
    }
}