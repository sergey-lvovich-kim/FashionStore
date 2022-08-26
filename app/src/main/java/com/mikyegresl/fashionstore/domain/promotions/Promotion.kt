package com.mikyegresl.fashionstore.domain.promotions

data class Promotion(
    val duration: Int,
    val content: String,
    val countdown: String,
    val backgroundColor: String,
    val textColor: String
)
