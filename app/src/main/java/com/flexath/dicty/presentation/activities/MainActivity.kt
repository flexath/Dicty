package com.flexath.dicty.presentation.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import com.flexath.dicty.presentation.navigator.DictNavigator
import com.flexath.dicty.ui.theme.DictyTheme
import com.flexath.dicty.ui.theme.colorBackground
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window,false)
        installSplashScreen().apply {
            setKeepOnScreenCondition {
                false
            }
        }

        setContent {
            DictyTheme(
                dynamicColor = false
            ) {
                val systemController = rememberSystemUiController()
                val isSystemBarDark = isSystemInDarkTheme()
                val scrollState = rememberScrollState()

                SideEffect {
                    systemController.setSystemBarsColor(
                        color = Color.Transparent,
                        darkIcons = isSystemBarDark
                    )
                }

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    DictNavigator(
                        onClickFab = {

                        }
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DictyTheme {
        Greeting("Android")
    }
}