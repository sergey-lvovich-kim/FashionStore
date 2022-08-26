package com.mikyegresl.fashionstore.data.remote.landing

import com.google.gson.annotations.SerializedName

data class MetaDto(
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("canonicalUrl")
    val canonicalUrl: String? = null,
    @SerializedName("content")
    val content: String? = null
)