package com.mikyegresl.fashionstore.data.remote.utils

import retrofit2.HttpException
import java.io.IOException

object NetworkErrorHandler {
    suspend fun <T> handleError(
        action: suspend () -> T,
        onNetworkException: suspend (Throwable) -> T
    ): T =
        try {
            action()
        } catch (e: Throwable) {
            if (e is HttpException || e is IOException) {
                onNetworkException.invoke(e)
            }
            e.printStackTrace()
            throw e
        }
}