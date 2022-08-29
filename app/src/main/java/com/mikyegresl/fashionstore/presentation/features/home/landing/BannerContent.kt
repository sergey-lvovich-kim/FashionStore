package com.mikyegresl.fashionstore.presentation.features.home.landing

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.mikyegresl.fashionstore.Constants
import com.mikyegresl.fashionstore.domain.landing.Banner
import com.mikyegresl.fashionstore.presentation.ui.Padding
import com.mikyegresl.fashionstore.presentation.ui.composable.FashionStoreProgress
import com.skydoves.landscapist.coil.CoilImage

@Composable
fun BannerContent(
    modifier: Modifier = Modifier,
    banner: Banner
) {
    val backgroundColor: String = banner.backgroundColor.ifEmpty { Constants.DEFAULT_BACKGROUND_COLOR }
    val textColor: String = banner.textColor.ifEmpty { Constants.DEFAULT_TEXT_COLOR }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = Padding.Small)
            .padding(top = Padding.Tiny, bottom = Padding.Medium),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CoilImage(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = Padding.Medium),
            imageModel = banner.imageUrl,
            contentScale = ContentScale.Crop,
            loading = { FashionStoreProgress() },
            failure = { }
        )
        if (!banner.isHeadingHidden) {
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .background(Color(android.graphics.Color.parseColor(backgroundColor)))
                    .padding(horizontal = Padding.Huge),
                horizontalAlignment = banner.xPosition,
                verticalArrangement = banner.yPosition
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(Padding.Medium),
                    text = banner.heading,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.ExtraBold,
                    textAlign = TextAlign.Center,
                    color = Color(android.graphics.Color.parseColor(textColor)),
                )
            }
        }
    }
}