package com.example.cityproject.ui

import androidx.lifecycle.ViewModel
import com.example.cityproject.data.Category
import com.example.cityproject.data.Place
import com.example.cityproject.data.local.LocalPlacesDataProvider
import com.example.cityproject.ui.utils.PlacesContentType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class CityViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(CityUiState(LocalPlacesDataProvider.allPlaces))
    val uiState: StateFlow<CityUiState> = _uiState

    fun updateCurrentCategory(chosenCategory: Category) {
        val currentPlacesMap: List<Place> =
            LocalPlacesDataProvider.allPlaces.filter { it.category == chosenCategory }
        _uiState.update {
            it.copy(
                currentCategory = chosenCategory,
                currentPlacesMap = currentPlacesMap
            )
        }


    }

    fun updateCurrentPlace(chosenPlace: Place) {
        _uiState.update {
            it.copy(
                currentPlace = chosenPlace,
                currentCategory = chosenPlace.category
            )
        }
    }

    fun resetCityPlace() {
        _uiState.update {
            it.copy(
                currentPlace = null
            )
        }
    }

    fun resetCityCategory() {
        _uiState.update {
            it.copy(
                currentCategory = null,
                currentPlace = null
            )
        }
    }

    fun updateContentType(placeContentType: PlacesContentType) {
        _uiState.update {
            it.copy(
                placesContentType = placeContentType
            )
        }

    }

}