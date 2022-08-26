package com.mikyegresl.fashionstore.data.remote.landing

import com.google.gson.annotations.SerializedName

data class PositionDto(
    @SerializedName("x")
    val x: String? = null,
    @SerializedName("y")
    val y: String? = null
)