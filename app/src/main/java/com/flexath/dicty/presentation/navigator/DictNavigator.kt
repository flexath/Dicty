package com.flexath.dicty.presentation.navigator

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.flexath.dicty.R
import com.flexath.dicty.presentation.common.DictTopAppBar
import com.flexath.dicty.presentation.navgraph.NavGraph
import com.flexath.dicty.presentation.navgraph.Route

@Composable
fun DictNavigator() {
    val navController = rememberNavController()
    val backStackEntry = navController.currentBackStackEntryAsState().value
    val context = LocalContext.current

    val route by rememberSaveable {
        mutableStateOf(Route.SearchScreen.route)
    }

    val appBarTitle by rememberSaveable {
        mutableStateOf("Search")
    }

    val bottomBarVisibility = remember(key1 = backStackEntry) {
        backStackEntry?.destination?.route == Route.SearchScreen.route ||
                backStackEntry?.destination?.route == Route.BookmarkScreen.route ||
                backStackEntry?.destination?.route == Route.SettingScreen.route
    }

    Scaffold(
        topBar = {
            DictTopAppBar(
                title = appBarTitle,
                route = route,
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    // state hoisting
                    Toast.makeText(context,"menu is clicked",Toast.LENGTH_SHORT).show()
                }
            )
        },
        bottomBar = {
            if (bottomBarVisibility) {

            }
        },

        ) {
        val bottomPadding = it.calculateBottomPadding()

        NavGraph(
            navController = navController,
            startDestination = Route.SearchScreen.route,
            bottomPadding = bottomPadding
        )
    }
}