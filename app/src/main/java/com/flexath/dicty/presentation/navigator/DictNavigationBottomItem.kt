package com.flexath.dicty.presentation.navigator

import androidx.annotation.DrawableRes
import com.flexath.dicty.R
import com.flexath.dicty.presentation.navgraph.Route

data class BottomNavigationItem(
    val title: String,
    val route: String,
    @DrawableRes val icon: Int
)

val bottomNavigationItemList = listOf(
    BottomNavigationItem(
        "Search",
        Route.SearchScreen.route,
        R.drawable.baseline_search_24dp
    ),
    BottomNavigationItem(
        "Saved",
        Route.SearchScreen.route,
        R.drawable.ic_bookmark
    ),
    BottomNavigationItem(
        "History",
        Route.SearchScreen.route,
        R.drawable.history_icon
    ),
    BottomNavigationItem(
        "Setting",
        Route.SearchScreen.route,
        R.drawable.ic_setting
    )
)