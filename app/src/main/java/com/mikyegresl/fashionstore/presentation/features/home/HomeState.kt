package com.mikyegresl.fashionstore.presentation.features.home

import com.mikyegresl.fashionstore.domain.landing.Landing
import com.mikyegresl.fashionstore.domain.promotions.Promotion
import com.mikyegresl.fashionstore.presentation.common.IState

data class HomeState(
    val landing: Landing? = null,
    val promotions: List<Promotion> = emptyList(),
    val currentPromotion: Promotion? = null,
    val isLoading: Boolean = false,
    val errorMessage: String? = null
): IState
