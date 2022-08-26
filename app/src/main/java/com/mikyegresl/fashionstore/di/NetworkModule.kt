package com.mikyegresl.fashionstore.di

import com.mikyegresl.fashionstore.data.remote.NetworkFactory
import org.koin.dsl.module

internal val networkModule = module {

    single { NetworkFactory() }
    single { get<NetworkFactory>().fashionStoreNetworkService }
}