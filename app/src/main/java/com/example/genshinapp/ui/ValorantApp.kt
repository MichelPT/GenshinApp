package com.example.genshinapp.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.genshinapp.R
import com.example.genshinapp.ui.navigation.NavigationItem
import com.example.genshinapp.ui.navigation.Route
import com.example.genshinapp.ui.screens.detail.DetailScreen
import com.example.genshinapp.ui.screens.home.HomeScreen
import com.example.genshinapp.ui.utilities.favorite

@Composable
fun ValorantApp(
    modifier: Modifier = Modifier,
    navHostController: NavHostController = rememberNavController(),
) {
    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(bottomBar = {
        if (currentRoute == Route.Detail.route) return@Scaffold
        BottomBar(
            navHostController = navHostController,
            modifier = modifier,
            currentRoute = currentRoute
        )
    }) { padding ->
        NavHost(
            navController = navHostController,
            startDestination = Route.Home.route,
            modifier = Modifier.padding(padding)
        ) {
            composable(Route.Home.route) {
                HomeScreen(modifier = modifier, detailNavigation = { uuid ->
                    navHostController.navigate(Route.Detail.createRoute(uuid))
                })
            }
            favorite { uuid ->
                navHostController.navigate(Route.Detail.createRoute(uuid))
            }
            composable(
                Route.Detail.route,
                arguments = listOf(navArgument("agentId") { type = NavType.StringType })
            ) {
                val id = it.arguments?.getString("agentId") ?: ""
                DetailScreen(
                    modifier = Modifier, agentId = id
                )
            }
        }
    }
}


@Composable
private fun BottomBar(
    modifier: Modifier,
    navHostController: NavHostController,
    currentRoute: String?,
) {
    NavigationBar(
        modifier = modifier
    ) {
        val navigationItems = listOf(
            NavigationItem(
                title = stringResource(R.string.home),
                icon = Icons.Outlined.Home,
                route = Route.Home
            ), NavigationItem(
                title = stringResource(R.string.favorite),
                icon = Icons.Outlined.Star,
                route = Route.Favorite
            )
        )
        navigationItems.map { item ->
            NavigationBarItem(icon = {
                Icon(
                    imageVector = item.icon, contentDescription = item.title
                )
            },
                label = { Text(item.title) },
                selected = currentRoute == item.route.route,
                onClick = {
                    navHostController.navigate(item.route.route) {
                        popUpTo(navHostController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                })
        }
    }
}

