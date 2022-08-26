package com.mikyegresl.fashionstore.presentation.common

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.mapNotNull

interface IEventBus {

    val events: SharedFlow<IIntent>

    suspend fun send(intent: IIntent)

    fun emit(intent: IIntent)
}

inline fun <reified T : IIntent> IEventBus.receive(): Flow<T> =
    events.mapNotNull { it as? T }