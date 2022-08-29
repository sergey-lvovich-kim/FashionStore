package com.mikyegresl.fashionstore.presentation.ui.composable

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.mikyegresl.fashionstore.R
import com.mikyegresl.fashionstore.presentation.ui.BottomNavItem

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        BottomNavItem.Menu,
        BottomNavItem.Home,
        BottomNavItem.Bag,
        BottomNavItem.Search,
        BottomNavItem.Favorites
    )
    BottomNavigation(
        backgroundColor = colorResource(id = R.color.black),
        contentColor = colorResource(id = R.color.white)
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(painterResource(id = item.icon), contentDescription = stringResource(id = item.title)) },
                label = { Text(text = stringResource(id = item.title), fontSize = 9.sp) },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.Gray,
                alwaysShowLabel = true,
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let { screen_route ->
                            popUpTo(screen_route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}