package com.mikyegresl.fashionstore.di

import com.mikyegresl.fashionstore.domain.landing.ILandingInteractor
import com.mikyegresl.fashionstore.domain.landing.LandingInteractor
import com.mikyegresl.fashionstore.domain.promotions.IPromotionInteractor
import com.mikyegresl.fashionstore.domain.promotions.PromotionInteractor
import com.mikyegresl.fashionstore.presentation.common.IEventBus
import com.mikyegresl.fashionstore.presentation.features.home.HomeEventBus
import com.mikyegresl.fashionstore.presentation.features.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal val featureHomeModule = module {

    single<ILandingInteractor> { LandingInteractor(get()) }
    single<IPromotionInteractor> { PromotionInteractor(get()) }
    single<IEventBus> { HomeEventBus }

    viewModel {
        HomeViewModel(
            landingInteractor = get(),
            promotionInteractor = get(),
            eventBus = get()
        )
    }
}