package com.mikyegresl.fashionstore.data.remote.landing

import com.google.gson.annotations.SerializedName

data class HeadingDto(
    @SerializedName("isHidden")
    val isHidden: Boolean = false,
    @SerializedName("text")
    val text: String? = null
)