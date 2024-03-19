package com.example.and_km6_refandadickypradana_challengechapter2.data.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize
import java.util.UUID

@Parcelize
data class ListMenu (
    var id : String= UUID.randomUUID().toString(),
    @DrawableRes
    var image: Int,
    var price: Double,
    var name: String,
    var detailMenu: String,
    var address: String,
    var mapsUrl: String
) : Parcelable