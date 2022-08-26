package com.mikyegresl.fashionstore.data.remote.promotions

import com.google.gson.annotations.SerializedName

data class ItemDto(
    @SerializedName("content")
    val content: String? = null,
    @SerializedName("countdown")
    val countdown: CountdownDto? = null,
    @SerializedName("duration")
    val duration: Int? = null,
    @SerializedName("highlight")
    val highlight: HighlightDto? = null
)