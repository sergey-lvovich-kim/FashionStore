package com.mikyegresl.fashionstore.presentation.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.mikyegresl.fashionstore.Constants
import com.mikyegresl.fashionstore.R

sealed class BottomNavItem(@StringRes val title: Int, @DrawableRes val icon: Int, val route: String) {
    object Menu: BottomNavItem(R.string.bottom_menu_text, R.drawable.ic_menu, Constants.NAV_MENU)
    object Home: BottomNavItem(R.string.bottom_home_text, R.drawable.ic_home, Constants.NAV_HOME)
    object Bag: BottomNavItem(R.string.bottom_bag_text, R.drawable.ic_bag, Constants.NAV_BAG)
    object Search: BottomNavItem(R.string.bottom_search_text, R.drawable.ic_search, Constants.NAV_SEARCH)
    object Favorites: BottomNavItem(R.string.bottom_favorites_text, R.drawable.ic_favorites, Constants.NAV_FAVORITES)
}
