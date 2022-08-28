package com.mikyegresl.fashionstore.presentation.features.home.landing

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.mikyegresl.fashionstore.domain.landing.Category
import com.mikyegresl.fashionstore.presentation.ui.Padding
import com.skydoves.landscapist.coil.CoilImage

@Composable
fun CategoryItemContent(
    category: Category
) {
    val isFeatured = category.backgroundColor.isEmpty()
    var boxModifier = Modifier
        .fillMaxSize()
        .padding(horizontal = Padding.Small)
        .padding(top = Padding.Tiny, bottom = Padding.Medium)
        .clip(RoundedCornerShape(corner = CornerSize(Padding.SmallLess)))
    var imageModifier = Modifier
        .clip(RoundedCornerShape(corner = CornerSize(Padding.SmallLess)))
    val textModifier = Modifier
        .padding(horizontal = Padding.Medium)
        .padding(top = Padding.Small, bottom = Padding.Large)

    if (isFeatured) {
        imageModifier = imageModifier
            .fillMaxHeight()
    } else {
        boxModifier = boxModifier
            .background(Color(android.graphics.Color.parseColor(category.backgroundColor)))
        imageModifier
            .padding(horizontal = Padding.Large)
            .padding(top = Padding.Huge, bottom = Padding.Large)
            .wrapContentSize()
    }
    CategoryItem(
        modifier = boxModifier,
        imageModifier = imageModifier,
        textModifier = textModifier,
        category = category
    )
}

@Composable
fun CategoryItem(
    modifier: Modifier = Modifier,
    imageModifier: Modifier = Modifier,
    textModifier: Modifier = Modifier,
    category: Category
) {
    Box(
        modifier = modifier
    ) {
        CoilImage(
            imageModel = category.image,
            modifier = imageModifier,
            contentScale = ContentScale.Crop,
            loading = { },
            failure = { }
        )
        Text(
            modifier = textModifier,
            text = category.title.uppercase(),
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center,
            color = Color.Black,
        )
    }
}