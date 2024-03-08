package com.example.and_km6_refandadickypradana_challengechapter2.model

import androidx.annotation.DrawableRes
import java.util.UUID

data class Category (
    var id : String= UUID.randomUUID().toString(),
    @DrawableRes
    var image: Int,
    var name: String,
)