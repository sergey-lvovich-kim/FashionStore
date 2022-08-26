package com.mikyegresl.fashionstore.di

import com.mikyegresl.fashionstore.data.repository.ILandingRepository
import com.mikyegresl.fashionstore.data.repository.IPromotionRepository
import com.mikyegresl.fashionstore.data.repository.LandingRepository
import com.mikyegresl.fashionstore.data.repository.PromotionRepository
import org.koin.dsl.module

internal val repositoryModule = module {

    single<ILandingRepository> { LandingRepository(get(), get()) }
    single<IPromotionRepository> { PromotionRepository(get(), get()) }
}