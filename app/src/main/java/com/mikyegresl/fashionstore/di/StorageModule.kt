package com.mikyegresl.fashionstore.di

import com.mikyegresl.fashionstore.data.local.FashionStoreDb
import org.koin.dsl.module

internal val storageModule = module {

    single { FashionStoreDb.getDatabase(get()) }
    single { get<FashionStoreDb>().landingDao() }
    single { get<FashionStoreDb>().promotionDao() }
}