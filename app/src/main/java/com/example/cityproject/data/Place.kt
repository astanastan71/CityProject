package com.example.cityproject.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.cityproject.data.local.LocalPlacesDataProvider
import com.example.cityproject.data.local.LocalPlacesDataProvider.allCategories

data class Place(
    val id: Long,
    @StringRes override val name: Int,
    @StringRes val address: Int? = null,
    @StringRes val description: Int,
    @DrawableRes override val imageId: Int,
    val category: Category = allCategories[4]
) : Subject()