package com.mikyegresl.fashionstore.data.remote.landing

import com.google.gson.annotations.SerializedName

data class LandingDto(
    @SerializedName("page")
    val page: PageDto? = null
)

data class PageDto(
    @SerializedName("content")
    val content: List<LandingContentDto>? = null,
    @SerializedName("meta")
    val meta: MetaDto? = null
)