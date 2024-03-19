package com.flexath.dicty.presentation.navigator

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalAbsoluteTonalElevation
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.flexath.dicty.R
import com.flexath.dicty.presentation.navgraph.Route
import com.flexath.dicty.presentation.utils.Dimens.MediumText3
import com.flexath.dicty.presentation.utils.Dimens.SmallPadding3
import com.flexath.dicty.presentation.utils.Dimens.SmallPadding5
import com.flexath.dicty.ui.theme.colorBackground
import com.flexath.dicty.ui.theme.colorPrimary
import com.flexath.dicty.ui.theme.colorSecondary
import com.flexath.dicty.ui.theme.colorUnselected

@Composable
fun DictBottomNavigation(
    navController: NavHostController
) {

    val backStackEntry = navController.currentBackStackEntryAsState().value

    var selectedBottomItemIndex by rememberSaveable {
        mutableIntStateOf(0)
    }

    selectedBottomItemIndex = when (backStackEntry?.destination?.route) {
        Route.SearchScreen.route -> 0
        Route.BookmarkScreen.route -> 1
        Route.HistoryScreen.route -> 2
        Route.SettingScreen.route -> 3
        else -> 0
    }

    NavigationBar(
        modifier = Modifier.fillMaxWidth(),
        containerColor = colorSecondary,
        tonalElevation = BottomAppBarDefaults.ContainerElevation
    ) {
        bottomNavigationItemList.forEachIndexed { index, bottomNavigationItem ->
            NavigationBarItem(
                selected = selectedBottomItemIndex == index,
                onClick = {
                    selectedBottomItemIndex = index
                    navController.navigate(bottomNavigationItem.route) {
                        navController.graph.startDestinationRoute?.let { startDestinationRoute ->
                            popUpTo(startDestinationRoute) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                label = {
                       Text(
                           text = bottomNavigationItem.title,
                           color = if(selectedBottomItemIndex == index) {
                               colorPrimary
                           } else {
                               colorUnselected
                           },
                           fontFamily = FontFamily(
                               Font(
                                   R.font.urbanist_regular
                               )
                           ),
                           fontSize = MediumText3
                       )
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.Transparent
                ),
                icon = {
                    Icon(
                        painter = painterResource(id = bottomNavigationItem.icon),
                        contentDescription = bottomNavigationItem.title,
                        tint = if (selectedBottomItemIndex == index) {
                            colorPrimary
                        } else {
                            colorUnselected
                        }
                    )
                },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview
@Composable
private fun DictBottomNavigationPreview() {
    DictBottomNavigation(rememberNavController())
}