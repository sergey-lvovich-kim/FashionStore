package com.mikyegresl.fashionstore.presentation.features.home.landing

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.mikyegresl.fashionstore.R
import com.mikyegresl.fashionstore.domain.landing.Category
import com.mikyegresl.fashionstore.presentation.ui.Padding

@Composable
fun CategoryList(
    categoryList: List<Category>
) {
    if (categoryList.isEmpty()) {
        EmptyList()
    }
    else {
        //todo: implement adaptive grid for 1 & 2 column layouts
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = 8.dp),
            verticalArrangement = Arrangement.Center,
            horizontalArrangement = Arrangement.Center,
        ) {
            itemsIndexed(
                items = categoryList
            ) { index, category ->
                if (category.isQuadro) {
                    CategoryHeaderContent(
                        category = category
                    )
                }
                else {
                    CategoryItemContent(
                        category = category
                    )
                }
                if (index != categoryList.lastIndex) {
                    Spacer(modifier = Modifier.padding(bottom = Padding.Medium))
                }
            }
        }
    }
}

@Composable
private fun EmptyList() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = stringResource(id = R.string.empty_categories_text),
            style = MaterialTheme.typography.body1,
            color = Color.Gray
        )
    }
}