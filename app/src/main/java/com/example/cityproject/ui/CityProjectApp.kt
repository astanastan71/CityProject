package com.example.cityproject.ui

import android.app.Activity
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cityproject.R
import com.example.cityproject.data.Category
import com.example.cityproject.data.Place
import com.example.cityproject.data.Subject
import com.example.cityproject.data.local.LocalPlacesDataProvider
import com.example.cityproject.ui.utils.ContentState
import com.example.cityproject.ui.utils.PlacesContentType

@Composable
fun CityProjectApp(
    windowsSize: WindowWidthSizeClass,
    modifier: Modifier = Modifier
) {
    val viewModel: CityViewModel = viewModel()
    val cityUiState = viewModel.uiState.collectAsState().value

    if (windowsSize == WindowWidthSizeClass.Expanded) {
        viewModel.updateContentType(PlacesContentType.LIST_AND_DETAIL)
    }
    if (cityUiState.placesContentType == PlacesContentType.LIST_ONLY) {
        Column() {


            var titleForAppBar: String = stringResource(id = R.string.app_name)
            var cityContentState: ContentState = ContentState.CATEGORY_SCREEN
            var backActionButton: () -> Unit = { viewModel.resetCityCategory() }

            if (cityUiState.currentCategory == null && cityUiState.currentPlace == null) {
                cityContentState = ContentState.CATEGORY_SCREEN
                titleForAppBar = stringResource(id = R.string.app_name)
            } else if (cityUiState.currentCategory != null && cityUiState.currentPlace == null) {
                cityContentState = ContentState.PLACES_SCREEN
                titleForAppBar = stringResource(id = cityUiState.currentCategory!!.name)
                backActionButton = {
                    viewModel.resetCityCategory()
                }
            } else if (cityUiState.currentCategory != null && cityUiState.currentPlace != null) {
                cityContentState = ContentState.PLACE_DETAIL
                titleForAppBar = stringResource(id = cityUiState.currentPlace!!.name)
                backActionButton = {
                    viewModel.resetCityPlace()
                }
            }
            CityAppBar(
                title = titleForAppBar,
                contentState = cityContentState,
                onClick = backActionButton
            )

            when (cityContentState) {
                ContentState.CATEGORY_SCREEN -> {
                    CityAppCategoryPage(
                        items = LocalPlacesDataProvider.allCategories,
                        onClick = { subject: Subject ->
                            viewModel.updateCurrentCategory(subject as Category)
                        },
                        modifier = Modifier
                    )
                }

                ContentState.PLACES_SCREEN -> {
                    CityAppCategoryPage(
                        items = cityUiState.currentPlacesMap,
                        onClick = { subject: Subject ->
                            viewModel.updateCurrentPlace(subject as Place)
                        },
                        modifier = Modifier
                    )
                }

                ContentState.PLACE_DETAIL -> {
                    CityPlaceDetailContent(
                        item = cityUiState.currentPlace!!,
                        modifier = Modifier
                    )

                }
            }

        }
    } else {
        Column() {
            Row() {
                CityAppBar(
                    title = stringResource(id = R.string.app_name),
                    contentState = ContentState.CATEGORY_SCREEN,
                    onClick = { }
                )
            }
            Row() {
                Column(modifier = Modifier.weight(1f)) {
                    CityAppCategoryPage(
                        items = LocalPlacesDataProvider.allCategories,
                        onClick = { subject: Subject ->
                            viewModel.resetCityPlace()
                            viewModel.updateCurrentCategory(subject as Category)
                        },
                        modifier = Modifier
                    )
                }
                Column(modifier = Modifier.weight(1f)) {
                    if (cityUiState.currentCategory != null) {
                        CityAppCategoryPage(
                            items = cityUiState.currentPlacesMap,
                            onClick = { subject: Subject ->
                                viewModel.updateCurrentPlace(subject as Place)
                            },
                            modifier = Modifier
                        )
                    }
                }

                Column(modifier = Modifier.weight(1f)) {
                    if (cityUiState.currentPlace != null) {
                        CityPlaceDetailContent(
                            item = cityUiState.currentPlace!!,
                            modifier = Modifier
                                .padding(10 .dp)
                        )
                    }
                }

            }

        }


    }


}