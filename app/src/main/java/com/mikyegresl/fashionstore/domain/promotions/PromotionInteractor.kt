package com.mikyegresl.fashionstore.domain.promotions

import com.mikyegresl.fashionstore.Constants
import com.mikyegresl.fashionstore.data.remote.utils.NetworkErrorHandler
import com.mikyegresl.fashionstore.data.repository.IPromotionRepository
import com.mikyegresl.fashionstore.domain.converters.toPromotionEntities
import com.mikyegresl.fashionstore.domain.converters.toPromotions
import com.mikyegresl.fashionstore.domain.utils.Resource
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class PromotionInteractor(
    private val promotionRepository: IPromotionRepository
): IPromotionInteractor {

    override suspend fun getPromotions(): Resource<List<Promotion>> =
        NetworkErrorHandler.handleError(
            action = {
                val promotions = promotionRepository.loadPromotions().toPromotionEntities()
                coroutineScope {
                    launch {
                        promotionRepository.savePromotions(promotions = promotions)
                    }
                }
                Resource.Success(
                    data = promotions.toPromotions()
                )
            },
            onNetworkException = {
                try {
                    Resource.Success(
                        data = promotionRepository.getPromotions().toPromotions()
                    )
                } catch (e: Exception) {
                    Resource.Error(error = it.message ?: Constants.UNKNOWN_ERROR)
                }
            },
        )
}