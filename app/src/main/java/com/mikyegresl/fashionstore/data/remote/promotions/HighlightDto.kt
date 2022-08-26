package com.mikyegresl.fashionstore.data.remote.promotions

import com.google.gson.annotations.SerializedName

data class HighlightDto(
    @SerializedName("backgroundColor")
    val backgroundColor: String? = null,
    @SerializedName("periodicity")
    val periodicity: Int? = null,
    @SerializedName("textColor")
    val textColor: String? = null
)