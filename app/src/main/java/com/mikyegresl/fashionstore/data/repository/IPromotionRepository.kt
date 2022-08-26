package com.mikyegresl.fashionstore.data.repository

import com.mikyegresl.fashionstore.data.local.promotions.PromotionEntity
import com.mikyegresl.fashionstore.data.remote.promotions.PromotionDto

interface IPromotionRepository {

    suspend fun loadPromotions(): PromotionDto

    suspend fun savePromotions(promotions: List<PromotionEntity>)

    suspend fun getPromotions(): List<PromotionEntity>
}