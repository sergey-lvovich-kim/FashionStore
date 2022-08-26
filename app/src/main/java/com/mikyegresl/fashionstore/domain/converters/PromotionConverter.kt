package com.mikyegresl.fashionstore.domain.converters

import com.mikyegresl.fashionstore.Constants
import com.mikyegresl.fashionstore.data.local.promotions.PromotionEntity
import com.mikyegresl.fashionstore.data.remote.promotions.PromotionDto
import com.mikyegresl.fashionstore.domain.promotions.Promotion

fun PromotionDto.toPromotionEntities(): List<PromotionEntity> =
    this.user?.proline?.center?.items?.map { item ->
        val content: String = item.countdown?.to?.let {
            "${item.content} ${item.countdown.to}"
        } ?: item.content ?: Constants.EMPTY_STRING

        PromotionEntity(
            duration = item.duration ?: 0,
            content = content,
            countdown = item.countdown?.to ?: Constants.EMPTY_STRING,
            backgroundColor = item.highlight?.backgroundColor
                ?: Constants.DEFAULT_BACKGROUND_COLOR,
            textColor = item.highlight?.textColor ?: Constants.DEFAULT_TEXT_COLOR
        )
    } ?: emptyList()

fun List<PromotionEntity>.toPromotions(): List<Promotion> =
    this.map { item ->
        Promotion(
            duration = item.duration,
            content = item.content,
            countdown = item.countdown,
            backgroundColor = item.backgroundColor,
            textColor = item.textColor
        )
    }