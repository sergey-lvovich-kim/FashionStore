package com.mikyegresl.fashionstore.data.repository

import com.mikyegresl.fashionstore.data.local.promotions.PromotionDao
import com.mikyegresl.fashionstore.data.local.promotions.PromotionEntity
import com.mikyegresl.fashionstore.data.remote.FashionStoreApi
import com.mikyegresl.fashionstore.data.remote.promotions.PromotionDto

class PromotionRepository(
    private val networkService: FashionStoreApi,
    private val localCache: PromotionDao
): IPromotionRepository {

    override suspend fun loadPromotions(): PromotionDto =
        networkService.getPromotionData()

    override suspend fun savePromotions(promotions: List<PromotionEntity>) =
        localCache.insertPromotions(promotions = promotions)

    override suspend fun getPromotions(): List<PromotionEntity> =
        localCache.getPromotions()
}