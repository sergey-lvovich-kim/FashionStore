package com.mikyegresl.fashionstore.data.repository

import com.mikyegresl.fashionstore.data.local.landing.BannerEntity
import com.mikyegresl.fashionstore.data.local.landing.CategoryEntity
import com.mikyegresl.fashionstore.data.remote.landing.LandingDto

interface ILandingRepository {

    suspend fun loadLanding(): LandingDto

    suspend fun getBanner(): BannerEntity

    suspend fun getCategories(): List<CategoryEntity>

    suspend fun saveBanner(banner: BannerEntity)

    suspend fun saveCategories(categories: List<CategoryEntity>)
}