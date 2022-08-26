package com.mikyegresl.fashionstore.data.remote.landing

import com.google.gson.annotations.SerializedName

data class CtaDto(
    @SerializedName("backgroundColor")
    val backgroundColor: String? = null,
    @SerializedName("text")
    val text: String? = null,
    @SerializedName("textColor")
    val textColor: String? = null
)