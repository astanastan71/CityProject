package com.example.cityproject.ui

import com.example.cityproject.data.Category
import com.example.cityproject.data.Place
import com.example.cityproject.data.local.LocalPlacesDataProvider
import com.example.cityproject.data.local.LocalPlacesDataProvider.allCategories
import com.example.cityproject.ui.utils.PlacesContentType

data class CityUiState(
    val currentPlacesMap: List<Place>,
    val currentCategory: Category? = null,
    val currentPlace: Place? = null,
    val placesContentType: PlacesContentType = PlacesContentType.LIST_ONLY
)

