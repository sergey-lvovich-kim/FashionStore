package com.mikyegresl.fashionstore.data.remote.landing

import com.google.gson.annotations.SerializedName

data class CaptionDto(
    @SerializedName("cta")
    val cta: CtaDto? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("heading")
    val heading: HeadingDto? = null,
    @SerializedName("isInverted")
    val isInverted: Boolean = false,
    @SerializedName("position")
    val position: PositionDto? = null
)