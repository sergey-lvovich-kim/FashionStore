package com.mikyegresl.fashionstore.data.repository

import com.mikyegresl.fashionstore.data.local.landing.BannerEntity
import com.mikyegresl.fashionstore.data.local.landing.CategoryEntity
import com.mikyegresl.fashionstore.data.local.landing.LandingDao
import com.mikyegresl.fashionstore.data.remote.FashionStoreApi
import com.mikyegresl.fashionstore.data.remote.landing.LandingDto

class LandingRepository(
    private val networkService: FashionStoreApi,
    private val localCache: LandingDao
): ILandingRepository {

    override suspend fun loadLanding(): LandingDto =
        networkService.getLandingData()

    override suspend fun getBanner(): BannerEntity =
        localCache.getBanner()

    override suspend fun getCategories(): List<CategoryEntity> =
        localCache.getCategories()

    override suspend fun saveBanner(banner: BannerEntity) =localCache.insertBanner(banner = banner)

    override suspend fun saveCategories(categories: List<CategoryEntity>) =localCache.insertCategories(categories = categories)
}