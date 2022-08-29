package com.mikyegresl.fashionstore.presentation.features.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.mikyegresl.fashionstore.R
import com.mikyegresl.fashionstore.domain.landing.Landing
import com.mikyegresl.fashionstore.presentation.features.home.landing.BannerContent
import com.mikyegresl.fashionstore.presentation.features.home.landing.CategoryHeaderContent
import com.mikyegresl.fashionstore.presentation.features.home.landing.CategoryItemContent
import com.mikyegresl.fashionstore.presentation.features.home.promotions.PromotionContent
import com.mikyegresl.fashionstore.presentation.ui.Padding
import com.mikyegresl.fashionstore.presentation.ui.composable.FashionStoreProgress

@Composable
fun HomeScreen(
    viewModel: HomeViewModel
) {
    val viewState: HomeState by remember { viewModel.state }.collectAsState()

    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (viewState.isLoading) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                FashionStoreProgress()
            }
        }
        else {
            viewState.currentPromotion?.let { PromotionContent(promotion = it) }
            viewState.landing?.let { LandingContent(landing = it) }
        }
    }
}

@Composable
fun LandingContent(landing: Landing) {
    if (landing.categories.isEmpty()) {
        EmptyList()
    }
    else {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = Padding.Small),
            verticalArrangement = Arrangement.Center,
            horizontalArrangement = Arrangement.Center,
        ) {
            landing.banner?.let {
                item(
                    span = { GridItemSpan(2) }
                ) {
                    BannerContent(banner = it)
                }
            }
            itemsIndexed(
                items = landing.categories,
                span = { _, item ->
                    val spanCount = if (item.isHeader) 2 else 1
                    GridItemSpan(spanCount)
                }
            ) { index, category ->
                if (category.isHeader) {
                    CategoryHeaderContent(category = category)
                } else {
                    CategoryItemContent(category = category)
                }
                if (index != landing.categories.lastIndex) {
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
