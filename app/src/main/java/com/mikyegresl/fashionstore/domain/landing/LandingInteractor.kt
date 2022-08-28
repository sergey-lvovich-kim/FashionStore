package com.mikyegresl.fashionstore.domain.landing

import com.mikyegresl.fashionstore.Constants
import com.mikyegresl.fashionstore.data.remote.utils.NetworkErrorHandler
import com.mikyegresl.fashionstore.data.repository.ILandingRepository
import com.mikyegresl.fashionstore.domain.converters.*
import com.mikyegresl.fashionstore.domain.utils.Resource

class LandingInteractor (
    private val landingRepository: ILandingRepository
): ILandingInteractor {

    override suspend fun getLandingData(): Resource<Landing> =
        NetworkErrorHandler.handleError(
            action = {
                val landing = landingRepository.loadLanding().toLanding()

                //todo: do these async
                if (landing.banner != null) {
                    landingRepository.saveBanner(landing.banner.toBannerEntity())
                }
                if (landing.categories.isNotEmpty()) {
                    landingRepository.saveCategories(landing.categories.toCategoryEntities())
                }
                Resource.Success(data = landing)
            },
            onNetworkException = {
                //todo: do these async
                val bannerEntity = landingRepository.getBanner()
                val categoryEntities = landingRepository.getCategories()

                try {
                    Resource.Success(
                        data = Landing(
                            banner = bannerEntity.toBanner(),
                            categories = categoryEntities.toCategories()
                        )
                    )
                } catch (e: Exception) {
                    Resource.Error(error = e.message ?: Constants.UNKNOWN_ERROR)
                }
            },
        )
}