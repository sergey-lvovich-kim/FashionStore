package com.mikyegresl.fashionstore.domain.landing

import com.mikyegresl.fashionstore.Constants
import com.mikyegresl.fashionstore.data.remote.utils.NetworkErrorHandler
import com.mikyegresl.fashionstore.data.repository.ILandingRepository
import com.mikyegresl.fashionstore.domain.converters.*
import com.mikyegresl.fashionstore.domain.utils.Resource
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class LandingInteractor (
    private val landingRepository: ILandingRepository
): ILandingInteractor {

    override suspend fun getLandingData(): Resource<Landing> =
        NetworkErrorHandler.handleError(
            action = {
                val landing = landingRepository.loadLanding().toLanding()

                if (landing.banner != null) {
                    coroutineScope {
                        launch {
                            landingRepository.saveBanner(landing.banner.toBannerEntity())
                        }
                    }
                }
                if (landing.categories.isNotEmpty()) {
                    coroutineScope {
                        launch {
                            landingRepository.saveCategories(landing.categories.toCategoryEntities())
                        }
                    }
                }
                Resource.Success(data = landing)
            },
            onNetworkException = {
                val deferredBanner = coroutineScope {
                    async {
                        landingRepository.getBanner()
                    }
                }
                val deferredCategories = coroutineScope {
                    async {
                        landingRepository.getCategories()
                    }
                }
                try {
                    Resource.Success(
                        data = Landing(
                            banner = deferredBanner.await().toBanner(),
                            categories = deferredCategories.await().toCategories()
                        )
                    )
                } catch (e: Exception) {
                    Resource.Error(error = e.message ?: Constants.UNKNOWN_ERROR)
                }
            },
        )
}