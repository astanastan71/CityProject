package com.example.cityproject.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cityproject.data.Place
import com.example.cityproject.data.local.LocalPlacesDataProvider

@Composable
fun CityPlaceDetailContent(
    item: Place,
    modifier: Modifier
) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = item.imageId),
                contentDescription = stringResource(id = item.name)
            )
        }
        Row(
            modifier = Modifier
                .padding(15.dp)
        ) {
            Text(
                text = stringResource(id = item.description),
                textAlign = TextAlign.Justify
            )

        }

    }
}

@Preview
@Composable
fun CityPlaceDetailContentPreview() {
    CityPlaceDetailContent(item = LocalPlacesDataProvider.allPlaces[0], modifier = Modifier)
}