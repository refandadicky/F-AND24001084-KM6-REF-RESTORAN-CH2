package com.example.and_km6_refandadickypradana_challengechapter2.model

import androidx.annotation.DrawableRes
import java.util.UUID

data class ListMenu (
    var id : String= UUID.randomUUID().toString(),
    @DrawableRes
    var image: Int,
    var price: Double,
    var name: String,
)