package com.mikyegresl.fashionstore.data.remote.landing

import com.google.gson.annotations.SerializedName

data class PositionDto(
    @SerializedName("x")
    val x: HorizontalPosition? = null,
    @SerializedName("y")
    val y: VerticalPosition? = null
)

enum class HorizontalPosition(val value: String) {
    @SerializedName("start")
    START("start"),
    @SerializedName("center")
    CENTER("center"),
    @SerializedName("end")
    END("end")
}

enum class VerticalPosition(val value: String) {
    @SerializedName("top")
    TOP("top"),
    @SerializedName("bottom")
    BOTTOM("bottom")
}