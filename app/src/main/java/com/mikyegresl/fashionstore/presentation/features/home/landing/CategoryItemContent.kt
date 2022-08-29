package com.mikyegresl.fashionstore.presentation.features.home.landing

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.mikyegresl.fashionstore.domain.landing.Category
import com.mikyegresl.fashionstore.presentation.ui.Padding
import com.mikyegresl.fashionstore.presentation.ui.composable.FashionStoreProgress
import com.skydoves.landscapist.coil.CoilImage

@Composable
fun CategoryItemContent(
    category: Category
) {
    CategoryItem(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = Padding.Small)
            .padding(top = Padding.Tiny, bottom = Padding.Medium)
            .clip(RoundedCornerShape(corner = CornerSize(Padding.SmallLess))),
        imageModifier = Modifier
            .clip(RoundedCornerShape(corner = CornerSize(Padding.SmallLess))),
        textModifier = Modifier
            .padding(horizontal = Padding.Medium)
            .padding(top = Padding.Huge, bottom = Padding.Large),
        category = category,
        isFeatured = category.backgroundColor.isEmpty()
    )
}

@Composable
fun CategoryItem(
    modifier: Modifier = Modifier,
    imageModifier: Modifier = Modifier,
    textModifier: Modifier = Modifier,
    category: Category,
    isFeatured: Boolean
) {
    Box(
        modifier = if (isFeatured) {
            modifier
                .size(Padding.FeatureCategoryImage)
        } else {
            modifier
                .background(Color(android.graphics.Color.parseColor(category.backgroundColor)))
        },
        contentAlignment = Alignment.BottomCenter
    ) {
        CoilImage(
            modifier = if (isFeatured) {
                imageModifier
            } else {
                imageModifier
                    .padding(horizontal = Padding.Large)
                    .padding(vertical = Padding.Superb)
            },
            imageModel = category.image,
            contentScale = if (isFeatured) {
                ContentScale.FillHeight
            } else {
                ContentScale.Crop
            },
            loading = { FashionStoreProgress() },
            failure = {

            }
        )
        Text(
            modifier = if (isFeatured) {
                textModifier
                    .drawBehind {
                        drawRect(
                            color = Color.White,
                            topLeft = Offset(x =-48f, y = -12f),
                            size = Size(
                                width = this.size.maxDimension + 96f,
                                height = this.size.minDimension + 24f
                            )
                        )
                    }
            } else {
                textModifier
            },
            text = category.title.uppercase(),
            fontSize = 15.sp,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center,
            color = Color.Black,
        )
    }
}