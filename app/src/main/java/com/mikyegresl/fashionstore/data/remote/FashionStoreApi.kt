package com.mikyegresl.fashionstore.data.remote

import com.mikyegresl.fashionstore.BuildConfig
import com.mikyegresl.fashionstore.data.remote.landing.LandingDto
import com.mikyegresl.fashionstore.data.remote.promotions.PromotionDto
import retrofit2.http.GET
import retrofit2.http.Header

interface FashionStoreApi {

    @GET("m/v1/page:type=landing")
    suspend fun getLandingData(
        @Header("bf-api-key") apiKey: String = BuildConfig.API_KEY,
        @Header("bf-localization") localization: String = BuildConfig.LOCALIZATION
    ): LandingDto

    @GET("m/v1/user:proline")
    suspend fun getPromotionData(
        @Header("bf-api-key") apiKey: String = BuildConfig.API_KEY,
        @Header("bf-localization") localization: String = BuildConfig.LOCALIZATION
    ): PromotionDto
}