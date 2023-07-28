package com.example.cityproject.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Category(
    @StringRes override val name: Int,
    @DrawableRes override val imageId: Int
) : Subject()