package com.example.cityproject.data.local

import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import com.example.cityproject.data.Place
import com.example.cityproject.data.Category
import com.example.cityproject.R

object LocalPlacesDataProvider {

    val allCategories = listOf(
        Category(
            name = R.string.culturalItem,
            imageId = R.drawable.place1
        ),
        Category(
            name = R.string.publicItem,
            imageId = R.drawable.place4
        ),
        Category(
            name = R.string.restarauntItem,
            imageId = R.drawable.place6
        ),
        Category(
            name = R.string.shopsMallItem,
            imageId = R.drawable.place10
        )
    )

    val allPlaces = listOf(
        Place(
            id = 1L,
            name = R.string.place_name_1,
            address = R.string.place_address1,
            description = R.string.place_description1,
            imageId = R.drawable.place1,
            category = allCategories[0]
        ),
        Place(
            id = 2L,
            name = R.string.place_name_2,
            address = R.string.place_address2,
            description = R.string.place_description2,
            imageId = R.drawable.place2,
            category = allCategories[0]
        ),
        Place(
            id = 3L,
            name = R.string.place_name_3,
            address = R.string.place_address3,
            description = R.string.place_description3,
            imageId = R.drawable.place3,
            category = allCategories[0]
        ),
        Place(
            id = 4L,
            name = R.string.place_name_4,
            address = R.string.place_address4,
            description = R.string.place_description4,
            imageId = R.drawable.place4,
            category = allCategories[1]
        ),
        Place(
            id = 5L,
            name = R.string.place_name_5,
            address = R.string.place_address5,
            description = R.string.place_description5,
            imageId = R.drawable.place5,
            category = allCategories[1]
        ),
        Place(
            id = 6L,
            name = R.string.place_name6,
            address = R.string.place_address6,
            description = R.string.place_description6,
            imageId = R.drawable.place6,
            category = allCategories[2]
        ),
        Place(
            id = 7L,
            name = R.string.place_name7,
            address = R.string.place_address7,
            description = R.string.place_description7,
            imageId = R.drawable.place7,
            category = allCategories[2]
        ),
        Place(
            id = 8L,
            name = R.string.place_name8,
            address = R.string.place_address8,
            description = R.string.place_description8,
            imageId = R.drawable.place8,
            category = allCategories[1]
        ),
        Place(
            id = 9L,
            name = R.string.place_name9,
            address = R.string.place_address9,
            description = R.string.place_description9,
            imageId = R.drawable.place9,
            category = allCategories[1]
        ),
        Place(
            id = 10L,
            name = R.string.place_name10,
            address = R.string.place_address10,
            description = R.string.place_description10,
            imageId = R.drawable.place10,
            category = allCategories[3]
        ),
        Place(
            id = 11L,
            name = R.string.place_name11,
            address = R.string.place_address11,
            description = R.string.place_description11,
            imageId = R.drawable.place11,
            category = allCategories[3]
        )

    )
}