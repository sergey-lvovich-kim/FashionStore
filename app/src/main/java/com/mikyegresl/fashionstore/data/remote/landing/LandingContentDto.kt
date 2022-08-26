package com.mikyegresl.fashionstore.data.remote.landing

import com.google.gson.annotations.SerializedName

data class LandingContentDto(
    @SerializedName("name")
    val name: LandingContentType,
    @SerializedName("data")
    val data: ContentDataDto
)

enum class LandingContentType(val value: String) {
    BANNER("banner"),
    QUADRO("quadro"),
    FEATURED("featured-categories")
}