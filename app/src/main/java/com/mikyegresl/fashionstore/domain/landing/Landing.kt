package com.mikyegresl.fashionstore.domain.landing

data class Landing(
    val banner: Banner? = null,
    val categories: List<Category> = emptyList()
)