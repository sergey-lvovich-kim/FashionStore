package com.mikyegresl.fashionstore.presentation.features.home.landing

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.mikyegresl.fashionstore.domain.landing.Category
import com.mikyegresl.fashionstore.presentation.ui.Padding
import com.skydoves.landscapist.coil.CoilImage

@Composable
fun CategoryHeaderContent(
    modifier: Modifier = Modifier,
    category: Category
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = Padding.Small)
            .padding(top = Padding.Tiny, bottom = Padding.Medium),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = Padding.Huge),
            text = category.title.uppercase(),
            fontSize = 24.sp,
            fontWeight = FontWeight.ExtraBold,
            textAlign = TextAlign.Center,
            color = Color.Black,
        )
        CoilImage(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = Padding.Medium),
            imageModel = category.image,
            contentScale = ContentScale.Crop,
            loading = { },
            failure = { }
        )
    }
}