package com.mikyegresl.fashionstore.domain.converters

import com.mikyegresl.fashionstore.Constants.EMPTY_STRING
import com.mikyegresl.fashionstore.data.local.landing.BannerEntity
import com.mikyegresl.fashionstore.data.local.landing.CategoryEntity
import com.mikyegresl.fashionstore.data.remote.landing.LandingContentType
import com.mikyegresl.fashionstore.data.remote.landing.LandingDto
import com.mikyegresl.fashionstore.domain.landing.*

fun Banner.toBannerEntity(): BannerEntity =
    BannerEntity(
        heading = heading,
        description = description,
        imageUrl = imageUrl,
        videoUrl = videoUrl,
        link = link,
        size = size,
        backgroundColor = backgroundColor,
        textColor = textColor,
        xPosition = xPosition,
        yPosition = yPosition,
        isHeadingHidden = isHeadingHidden,
        isInverted = isInverted,
    )

fun BannerEntity.toBanner(): Banner =
    Banner(
        heading = heading,
        description = description,
        imageUrl = imageUrl,
        videoUrl = videoUrl,
        link = link,
        size = size,
        backgroundColor = backgroundColor,
        textColor = textColor,
        xPosition = xPosition,
        yPosition = yPosition,
        isHeadingHidden = isHeadingHidden,
        isInverted = isInverted,
    )

fun List<Category>.toCategoryEntities(): List<CategoryEntity> =
    this.map {
        CategoryEntity(
            title = it.title,
            link = it.link,
            backgroundColor = it.backgroundColor,
            image = it.image,
            isHeader = it.isHeader
        )
    }

fun List<CategoryEntity>.toCategories(): List<Category> =
    this.map {
        Category(
            title = it.title,
            link = it.link,
            backgroundColor = it.backgroundColor,
            image = it.image,
            isHeader = it.isHeader
        )
    }

fun LandingDto.toLanding(): Landing {
    var banner: Banner? = null
    val categories = mutableListOf<Category>()

    this.page?.content?.forEach { landingContent ->
        if (landingContent.name == LandingContentType.BANNER) {
            banner = Banner(
                heading = landingContent.data.caption?.heading?.text ?: EMPTY_STRING,
                description = landingContent.data.caption?.description ?: EMPTY_STRING,
                imageUrl = landingContent.data.image?.src ?: EMPTY_STRING,
                videoUrl = landingContent.data.video?.src ?: EMPTY_STRING,
                link = landingContent.data.linkUrl ?: EMPTY_STRING,
                size = mapBannerSize(landingContent.data.size),
                backgroundColor = landingContent.data.caption?.cta?.backgroundColor ?: EMPTY_STRING,
                textColor = landingContent.data.caption?.cta?.textColor ?: EMPTY_STRING,
                xPosition = mapHorizontalPosition(landingContent.data.caption?.position?.x),
                yPosition = mapVerticalPosition(landingContent.data.caption?.position?.y),
                isHeadingHidden = landingContent.data.caption?.heading?.isHidden ?: false,
                isInverted = landingContent.data.caption?.isInverted ?: false,
            )
        } else if (landingContent.name == LandingContentType.QUADRO) {
            categories.add(
                Category(
                    title = landingContent.data.title ?: EMPTY_STRING,
                    link = landingContent.data.linkUrl ?: EMPTY_STRING,
                    backgroundColor = EMPTY_STRING,
                    image = landingContent.data.image?.src ?: EMPTY_STRING,
                    isHeader = true
                )
            )
        }
        landingContent.data.categories?.forEach { category ->
            categories.add(
                Category(
                    title = category.title ?: EMPTY_STRING,
                    link = category.linkUrl ?: EMPTY_STRING,
                    backgroundColor = category.backgroundColor ?: EMPTY_STRING,
                    image = category.image?.src ?: EMPTY_STRING,
                    isHeader = false
                )
            )
        }
    }
    return Landing(
        banner = banner,
        categories = categories
    )
}

private fun mapBannerSize(size: String?): BannerSize =
    size?.let {
        when (it) {
            "large" -> BannerSize.LARGE
            "medium" -> BannerSize.MEDIUM
            "small" -> BannerSize.SMALL
            else -> null
        }
    } ?: BannerSize.LARGE

private fun mapHorizontalPosition(x: String?): HorizontalPosition =
    x?.let {
        when (it) {
            "start" -> HorizontalPosition.START
            "center" -> HorizontalPosition.CENTER
            "end" -> HorizontalPosition.END
            else -> null
        }
    } ?: HorizontalPosition.CENTER

private fun mapVerticalPosition(y: String?): VerticalPosition =
    y?.let {
        when (y) {
            "top" -> VerticalPosition.TOP
            "bottom" -> VerticalPosition.BOTTOM
            else -> null
        }
    } ?: VerticalPosition.BOTTOM
