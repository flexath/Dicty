package com.flexath.dicty.presentation.navgraph

import com.flexath.dicty.presentation.utils.Constants.BOOKMARK_SCREEN
import com.flexath.dicty.presentation.utils.Constants.DETAIL_SCREEN
import com.flexath.dicty.presentation.utils.Constants.SEARCH_SCREEN
import com.flexath.dicty.presentation.utils.Constants.SETTING_SCREEN

sealed class Route (val route: String) {
    data object SearchScreen: Route(route = SEARCH_SCREEN)
    data object BookmarkScreen: Route(route = BOOKMARK_SCREEN)
    data object SettingScreen: Route(route = SETTING_SCREEN)
    data object DetailScreen: Route(route = DETAIL_SCREEN)
}