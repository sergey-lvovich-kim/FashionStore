package com.mikyegresl.fashionstore.data.remote.landing

import com.google.gson.annotations.SerializedName

data class ContentDataDto(
    @SerializedName("caption")
    val caption: CaptionDto? = null,
    @SerializedName("categories")
    val categories: List<CategoryDto>? = null,
    @SerializedName("image")
    val image: ImageDto? = null,
    @SerializedName("isMainImageRight")
    val isMainImageRight: Boolean = false,
    @SerializedName("linkUrl")
    val linkUrl: String? = null,
    @SerializedName("size")
    val size: String? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("video")
    val video: VideoDto? = null
)

data class ImageDto(
    @SerializedName("src")
    val src: String? = null
)

data class VideoDto(
    @SerializedName("src")
    val src: String? = null
)