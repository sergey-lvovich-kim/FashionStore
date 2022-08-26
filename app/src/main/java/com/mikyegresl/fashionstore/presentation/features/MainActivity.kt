package com.mikyegresl.fashionstore.presentation.features

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mikyegresl.fashionstore.presentation.common.StateActivity
import com.mikyegresl.fashionstore.presentation.features.bag.BagScreen
import com.mikyegresl.fashionstore.presentation.features.favorites.FavoriteScreen
import com.mikyegresl.fashionstore.presentation.features.home.HomeScreen
import com.mikyegresl.fashionstore.presentation.features.home.HomeState
import com.mikyegresl.fashionstore.presentation.features.home.HomeViewModel
import com.mikyegresl.fashionstore.presentation.features.menu.MenuScreen
import com.mikyegresl.fashionstore.presentation.features.search.SearchScreen
import com.mikyegresl.fashionstore.presentation.ui.BottomNavItem
import com.mikyegresl.fashionstore.presentation.ui.composable.BottomNavigationBar
import com.mikyegresl.fashionstore.presentation.ui.composable.TopBar
import com.mikyegresl.fashionstore.presentation.ui.theme.FashionStoreTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : StateActivity<HomeState>() {

    override val viewModel: HomeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            FashionStoreTheme {
                MainScreen()
            }
        }

        viewModel.initialize()
    }

    @Composable
    fun MainScreen() {
        val navController = rememberNavController()

        Scaffold(
            topBar = { TopBar() },
            bottomBar = { BottomNavigationBar(navController = navController) }
        ) { offset ->
            Box(modifier = Modifier.padding(offset)) {
                GlobalNavGraph(navController = navController)
            }
        }
    }

    @Composable
    fun GlobalNavGraph(navController: NavHostController) {
        NavHost(
            navController = navController,
            startDestination = BottomNavItem.Home.route
        ) {
            composable(BottomNavItem.Menu.route) {
                MenuScreen()
            }
            composable(BottomNavItem.Home.route) {
                HomeScreen(viewModel = viewModel)
            }
            composable(BottomNavItem.Bag.route) {
                BagScreen()
            }
            composable(BottomNavItem.Search.route) {
                SearchScreen()
            }
            composable(BottomNavItem.Favorites.route) {
                FavoriteScreen()
            }
        }
    }
}

