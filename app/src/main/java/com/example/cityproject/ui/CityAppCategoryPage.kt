package com.example.cityproject.ui

import android.graphics.Picture
import androidx.annotation.DrawableRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cityproject.R
import com.example.cityproject.data.Category
import com.example.cityproject.data.Place
import com.example.cityproject.data.Subject
import com.example.cityproject.data.local.LocalPlacesDataProvider
import com.example.cityproject.data.local.LocalPlacesDataProvider.allCategories
import com.example.cityproject.data.local.LocalPlacesDataProvider.allPlaces

@Composable
fun CityAppCategoryPage(
    items: List<Subject>,
    onClick: (Subject) -> Unit,
    modifier: Modifier
) {
    LazyColumn(
        modifier = Modifier
            .padding(
                end = 16.dp,
                top = 20.dp,
            )
    ) {
        items(items) { item ->
            CityItemCard(
                subject = item,
                onClick = onClick,
                modifier = Modifier
                    .clip(MaterialTheme.shapes.medium)
                    .fillMaxWidth()
                    .padding(16.dp)
                    .animateContentSize(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioMediumBouncy,
                            stiffness = Spring.StiffnessHigh
                        )
                    )
            )
        }


    }

}

@Composable
fun CityItemCard(
    subject: Subject,
    onClick: (Subject) -> Unit,
    modifier: Modifier
) {
    Card(modifier) {
        Column {
            Row(
                modifier = Modifier.clickable(
                    enabled = true,
                    onClick = {
                        onClick(subject)
                    })
            ) {
                Image(
                    painter = painterResource(id = subject.imageId),
                    contentDescription = stringResource(id = subject.name),
                    modifier = Modifier.height(72.dp)
                )
                Text(
                    text = stringResource(id = subject.name),
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.padding(
                        top = dimensionResource(R.dimen.email_list_item_header_subject_spacing),
                        bottom = dimensionResource(R.dimen.email_list_item_subject_body_spacing),
                        start = 15 .dp,
                        end = 15 .dp
                    ),
                )
            }
        }


    }
}

@Preview
@Composable
fun CityItemCardPreview() {
//    val viewModel: CityViewModel = viewModel()
//    val replyUiState = viewModel.uiState.collectAsState().value
    CityAppCategoryPage(
        items = allCategories,
        onClick = { subject: Subject ->  },
        modifier = Modifier
    )

}