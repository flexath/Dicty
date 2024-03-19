package com.flexath.dicty.presentation.screens.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.flexath.dicty.presentation.utils.Dimens.MediumPadding3

@Composable
fun SearchScreen(
    modifier: Modifier = Modifier
) {
    val query by rememberSaveable {
        mutableStateOf("")
    }

    Column(
        modifier = modifier
    ) {
        SearchBar(
            query = query,
            modifier = Modifier
                .padding(
                    top = MediumPadding3,
                    start = MediumPadding3,
                    end = MediumPadding3
                )
                .fillMaxWidth()
                .background(color = Color.Transparent)
        ) {

        }


    }
}

@Preview(showSystemUi = true)
@Composable
private fun SearchScreenPreview() {
    SearchScreen(
        modifier = Modifier.fillMaxSize()
    )
}