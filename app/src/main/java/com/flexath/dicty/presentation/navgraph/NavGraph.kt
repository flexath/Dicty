package com.flexath.dicty.presentation.navgraph

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavGraph(
    navController: NavHostController,
    startDestination: String,
    bottomPadding: Dp
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = Modifier.padding(bottom = bottomPadding)
    ) {
        composable(
            route = Route.SearchScreen.route
        ) {

        }

        composable(
            route = Route.BookmarkScreen.route
        ) {

        }

        composable(
            route = Route.SettingScreen.route
        ) {

        }

        composable(
            route = Route.DetailScreen.route
        ) {

        }
    }
}