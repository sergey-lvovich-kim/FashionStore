package com.mikyegresl.fashionstore.domain.landing

import com.mikyegresl.fashionstore.domain.utils.Resource

interface ILandingInteractor {

    suspend fun getLandingData(): Resource<Landing>
}