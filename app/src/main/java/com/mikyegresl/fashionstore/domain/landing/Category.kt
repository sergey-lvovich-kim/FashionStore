package com.mikyegresl.fashionstore.domain.landing

data class Category(
    val title: String,
    val link: String,
    val backgroundColor: String,
    val image: String,
    val isQuadro: Boolean = false
)
