package com.mikyegresl.fashionstore.data.remote.promotions

import com.google.gson.annotations.SerializedName

data class PromotionContentDto(
    @SerializedName("activeBefore")
    val activeBefore: String? = null,
    @SerializedName("activeAfter")
    val activeAfter: String? = null,
    @SerializedName("finished")
    val finished: String? = null,
)
