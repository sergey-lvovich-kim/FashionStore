package com.mikyegresl.fashionstore.presentation.features.home

import com.mikyegresl.fashionstore.presentation.common.IEventBus
import com.mikyegresl.fashionstore.presentation.common.IIntent
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

object HomeEventBus: IEventBus {
    private val _events = MutableSharedFlow<IIntent>()

    override val events = _events.asSharedFlow()

    override suspend fun send(intent: IIntent) {
        _events.emit(intent)
    }

    override fun emit(intent: IIntent) {
        _events.tryEmit(intent)
    }
}