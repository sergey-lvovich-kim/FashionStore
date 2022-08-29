package com.mikyegresl.fashionstore.presentation.features.home

import com.mikyegresl.fashionstore.presentation.common.IIntent

sealed interface HomeIntent: IIntent {
    object Initialize: HomeIntent
    object Clear : HomeIntent
}