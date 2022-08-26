package com.mikyegresl.fashionstore.presentation.features.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.mikyegresl.fashionstore.domain.landing.Landing
import com.mikyegresl.fashionstore.presentation.features.home.landing.BannerContent
import com.mikyegresl.fashionstore.presentation.features.home.landing.CategoryList
import com.mikyegresl.fashionstore.presentation.features.home.promotions.PromotionContent

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
                CircularProgressIndicator(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.CenterHorizontally),
                    color = Color.Red
                )
            }
        }
        else {
            viewState.currentPromotion?.let { PromotionContent(promotion = it) }
            viewState.landing?.let { LandingContent(landing = it) }
        }
    }
}

@Composable
fun LandingContent(
    landing: Landing
) {
    CategoryList(
        landing.categories
    )
    BannerContent(

    )
}
