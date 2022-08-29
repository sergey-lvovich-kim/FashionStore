package com.mikyegresl.fashionstore.domain.landing

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.Alignment
import com.mikyegresl.fashionstore.Constants

data class Banner(
    val heading: String = Constants.EMPTY_STRING,
    val description: String = Constants.EMPTY_STRING,
    val imageUrl: String = Constants.EMPTY_STRING,
    val videoUrl: String = Constants.EMPTY_STRING,
    val link: String = Constants.EMPTY_STRING,
    val size: BannerSize = BannerSize.LARGE,
    val backgroundColor: String = Constants.EMPTY_STRING,
    val textColor: String = Constants.EMPTY_STRING,
    val xPosition: Alignment.Horizontal = Alignment.CenterHorizontally,
    val yPosition: Arrangement.Vertical = Arrangement.Bottom,
    val isHeadingHidden: Boolean = false,
    val isInverted: Boolean = false
)

enum class BannerSize(val value: String) {
    LARGE("large"),
    MEDIUM("medium"),
    SMALL("small")
}