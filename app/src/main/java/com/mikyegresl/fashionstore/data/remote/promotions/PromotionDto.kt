package com.mikyegresl.fashionstore.data.remote.promotions

import com.google.gson.annotations.SerializedName

data class PromotionDto(
    @SerializedName("user")
    val user: PromotionUserDto? = null
)

data class PromotionUserDto(
    @SerializedName("proline")
    val proline: ProlineDto? = null
)

data class ProlineDto(
    @SerializedName("left")
    val left: String? = null,
    @SerializedName("center")
    val center: CenterDto? = null,
    @SerializedName("right")
    val right: String? = null
)

data class CenterDto(
    @SerializedName("items")
    val items: List<ItemDto>? = null
)
