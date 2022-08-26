package com.mikyegresl.fashionstore.domain.landing

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
    val xPosition: HorizontalPosition = HorizontalPosition.CENTER,
    val yPosition: VerticalPosition = VerticalPosition.BOTTOM,
    val isHeadingHidden: Boolean = false,
    val isInverted: Boolean = false
)

enum class BannerSize(val value: String) {
    LARGE("large"),
    MEDIUM("medium"),
    SMALL("small")
}

enum class HorizontalPosition(val value: String) {
    START("start"),
    CENTER("center"),
    END("end")
}

enum class VerticalPosition(val value: String) {
    TOP("top"),
    BOTTOM("bottom")
}