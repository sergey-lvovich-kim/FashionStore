package com.mikyegresl.fashionstore.domain.promotions

import com.mikyegresl.fashionstore.domain.utils.Resource

interface IPromotionInteractor {

    suspend fun getPromotions(): Resource<List<Promotion>>
}