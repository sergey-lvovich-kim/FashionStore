package com.mikyegresl.fashionstore.presentation.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mikyegresl.fashionstore.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

abstract class StateViewModel<T: IState>: ViewModel() {

    private val ioDispatcher: CoroutineContext = viewModelScope.coroutineContext + Dispatchers.IO

    protected abstract val _state: MutableStateFlow<T>
    val state: StateFlow<T> by lazy { _state }
    val currentState: T get() = _state.value

    private val _globalViewState = MutableStateFlow<ViewState>(ViewState.Content)
    val globalViewState: StateFlow<ViewState> by lazy { _globalViewState }

    private fun setError(e: Exception) {
        _globalViewState.value = ViewState.Error(e.message ?: Constants.UNKNOWN_ERROR)
    }

    private fun setLoading() {
        _globalViewState.value = ViewState.Loading
    }

    private fun setContent() {
        _globalViewState.value = ViewState.Content
    }

    protected fun updateState(value: T) {
        _state.value = value
    }

    protected fun updateState(
        dispatcher: CoroutineContext = ioDispatcher,
        calculateState: suspend () -> T,
        loaderEnabled: Boolean = false,
        onErrorUpdate: ((e: Throwable) -> T)? = null
    ) {
        doBackground(
            dispatcher = dispatcher,
            work = { _state.value = calculateState() },
            onError = { error ->
                onErrorUpdate?.let { _state.value = onErrorUpdate(error) }
            },
            loaderEnabled = loaderEnabled
        )
    }

    protected fun doBackground(
        dispatcher: CoroutineContext = ioDispatcher,
        work: suspend () -> Unit,
        loaderEnabled: Boolean = false,
        onError: ((e: Throwable) -> Unit)? = null
    ) {
        viewModelScope.launch {
            if (loaderEnabled) {
                setLoading()
            }
            try {
                withContext(dispatcher) { work() }
            } catch (e: Exception) {
                onError?.invoke(e)
                setError(e)
            }
        }
    }
}