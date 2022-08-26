package com.mikyegresl.fashionstore.presentation.features.home

import com.mikyegresl.fashionstore.domain.promotions.Promotion

interface IHomeView {

    fun render(state: HomeState)

    fun bindPromotions(promotions: Set<Promotion>)

    fun showEmptyState()

    fun showLoading()
}