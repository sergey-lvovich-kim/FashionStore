package com.mikyegresl.fashionstore.data.remote.landing

import com.google.gson.annotations.SerializedName

data class CategoryDto(
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("linkUrl")
    val linkUrl: String? = null,
    @SerializedName("backgroundColor")
    val backgroundColor: String? = null,
    @SerializedName("image")
    val image: ImageDto? = null
)