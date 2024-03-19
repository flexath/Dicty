package com.flexath.dicty.presentation.navigator

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalAbsoluteTonalElevation
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.flexath.dicty.R
import com.flexath.dicty.presentation.common.DictTopAppBar
import com.flexath.dicty.presentation.navgraph.NavGraph
import com.flexath.dicty.presentation.navgraph.Route
import com.flexath.dicty.presentation.utils.Dimens.SmallPadding1
import com.flexath.dicty.presentation.utils.Dimens.SmallPadding2
import com.flexath.dicty.presentation.utils.Dimens.SmallPadding5
import com.flexath.dicty.ui.theme.colorBackground
import com.flexath.dicty.ui.theme.colorFavorite
import com.flexath.dicty.ui.theme.colorPrimary
import com.flexath.dicty.ui.theme.colorSecondary

@Composable
fun DictNavigator(
    modifier: Modifier = Modifier,
    onClickFab: () -> Unit
) {
    val navController = rememberNavController()
    val backStackEntry = navController.currentBackStackEntryAsState().value
    val context = LocalContext.current

    val route by rememberSaveable {
        mutableStateOf(Route.SearchScreen.route)
    }

    val appBarTitle by rememberSaveable {
        mutableStateOf("Search")
    }

    var favoriteButtonColor by rememberSaveable {
        mutableStateOf(false)
    }

    val bottomBarVisibility = remember(key1 = backStackEntry) {
        backStackEntry?.destination?.route == Route.SearchScreen.route ||
                backStackEntry?.destination?.route == Route.BookmarkScreen.route ||
                backStackEntry?.destination?.route == Route.HistoryScreen.route ||
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
                    Toast.makeText(context, "menu is clicked", Toast.LENGTH_SHORT).show()
                }
            )
        },
        bottomBar = {
            if (bottomBarVisibility) {
                DictBottomNavigation(navController = navController)
            }
        },
        modifier = modifier.background(color = colorBackground)
    ) {
        val bottomPadding = it.calculateBottomPadding()
        val topPadding = it.calculateTopPadding()

        NavGraph(
            navController = navController,
            startDestination = Route.SearchScreen.route,
            bottomPadding = bottomPadding,
            topPadding = topPadding
        )
    }
}

@Preview(showSystemUi = true)
@Composable
private fun DictNavigatorPreview() {
    DictNavigator(
        onClickFab = {

        }
    )
}