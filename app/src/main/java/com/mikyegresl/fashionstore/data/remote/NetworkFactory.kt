package com.mikyegresl.fashionstore.data.remote

import com.mikyegresl.fashionstore.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkFactory {
    private val loggingInterceptor by lazy { HttpLoggingInterceptor().also { it.level = HttpLoggingInterceptor.Level.BODY } }

    private val gsonConverterFactory by lazy { GsonConverterFactory.create() }

    private val httpClient by lazy {
        OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()
    }

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(gsonConverterFactory)
            .client(httpClient)
            .build()
    }

    val fashionStoreNetworkService: FashionStoreApi by lazy { retrofit.create(FashionStoreApi::class.java) }
}