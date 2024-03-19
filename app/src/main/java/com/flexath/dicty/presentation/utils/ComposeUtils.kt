package com.flexath.dicty.presentation.utils

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.flexath.dicty.ui.theme.colorTextDark
import com.flexath.dicty.ui.theme.colorTextLight

@Composable
fun dynamicTextColor(): Color {
    return if(isSystemInDarkTheme()) {
        colorTextLight
    } else {
        colorTextDark
    }
}