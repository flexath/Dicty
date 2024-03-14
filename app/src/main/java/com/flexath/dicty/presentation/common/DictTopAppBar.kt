package com.flexath.dicty.presentation.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.flexath.dicty.R
import com.flexath.dicty.presentation.navgraph.Route
import com.flexath.dicty.presentation.utils.Dimens.MediumPadding3
import com.flexath.dicty.ui.theme.Typography
import com.flexath.dicty.ui.theme.colorBackground
import com.flexath.dicty.ui.theme.colorSecondary
import com.flexath.dicty.ui.theme.colorTextLight

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DictTopAppBar(
    title: String,
    route: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors().copy(
            containerColor = colorSecondary,
            navigationIconContentColor = colorBackground,
            titleContentColor = colorTextLight
        ),
        title = {
            Text(
                text = title,
                style = Typography.titleLarge,
                color = colorTextLight,
                textAlign = TextAlign.Center,
                modifier = modifier
            )
        },
        navigationIcon = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(start = MediumPadding3)
            ) {
                if (route == Route.DetailScreen.route) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_arrow_left_24_white),
                        contentDescription = "Back Button",
                        modifier = Modifier.clickable {
                            onClick()
                        }
                    )
                } else {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_menu_24_white),
                        contentDescription = "Back Button",
                        modifier = Modifier.clickable {
                            onClick()
                        }
                    )
                }
            }
        }
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun DictTopAppBarPreview() {
    DictTopAppBar(
        title = stringResource(id = R.string.lbl_search),
        route = Route.SearchScreen.route,
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = MediumPadding3),
        onClick = {

        }
    )
}