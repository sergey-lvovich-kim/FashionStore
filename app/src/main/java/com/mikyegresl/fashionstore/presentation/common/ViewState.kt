package com.mikyegresl.fashionstore.presentation.common

sealed class ViewState {
    object Loading: ViewState()
    object Content: ViewState()
    data class Error(val error: String): ViewState()
}
