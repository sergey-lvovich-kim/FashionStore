package com.mikyegresl.fashionstore.presentation.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.mikyegresl.fashionstore.R

object Padding {

    val Empty: Dp
        @Composable get() = 0.dp

    val TinyLess: Dp
        @Composable get() = dimensionResource(R.dimen.body)

    val Tiny: Dp
        @Composable get() = dimensionResource(R.dimen.space_tiny)

    val SmallLess: Dp
        @Composable get() = dimensionResource(R.dimen.space_small_less)

    val Small: Dp
        @Composable get() = dimensionResource(R.dimen.space_small)

    val Medium: Dp
        @Composable get() = dimensionResource(R.dimen.space_medium)

    val Large: Dp
        @Composable get() = dimensionResource(R.dimen.space_large)

    val Huge: Dp
        @Composable get() = dimensionResource(R.dimen.space_huge)

    val Superb: Dp
        @Composable get() = dimensionResource(R.dimen.space_superb)
}