package com.mikyegresl.fashionstore.data.remote.promotions

import com.google.gson.annotations.SerializedName

data class CountdownDto(
    @SerializedName("to")
    val to: String? = null,
    @SerializedName("content")
    val content: PromotionContentDto? = null,
    @SerializedName("isCountHidden")
    val isCountHidden: Boolean = false,
    @SerializedName("hasGlitch")
    val hasGlitch: Boolean = true
)
