package com.flexath.dicty.presentation.navgraph

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.flexath.dicty.presentation.screens.search.SearchScreen

@Composable
fun NavGraph(
    navController: NavHostController,
    startDestination: String,
    bottomPadding: Dp,
    topPadding: Dp
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = Modifier.padding(bottom = bottomPadding,top = topPadding)
    ) {
        composable(
            route = Route.SearchScreen.route
        ) {
            SearchScreen(
                modifier = Modifier
            )
        }

        composable(
            route = Route.BookmarkScreen.route
        ) {

        }

        composable(
            route = Route.HistoryScreen.route
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

@Preview(showSystemUi = true)
@Composable
private fun NavGraphPreview() {
    NavGraph(
        navController = rememberNavController(),
        startDestination = Route.SearchScreen.route,
        bottomPadding = 20.dp,
        topPadding = 20.dp
    )
}