package com.mikyegresl.fashionstore.presentation.common

import androidx.activity.ComponentActivity

abstract class StateActivity<T: IState>: ComponentActivity() {

    protected abstract val viewModel: StateViewModel<T>
}