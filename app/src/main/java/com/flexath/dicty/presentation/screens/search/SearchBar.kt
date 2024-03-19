package com.flexath.dicty.presentation.screens.search

import android.graphics.Typeface
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.flexath.dicty.R
import com.flexath.dicty.presentation.utils.Dimens.MediumPadding3
import com.flexath.dicty.ui.theme.colorBackground
import com.flexath.dicty.ui.theme.colorPrimary
import com.flexath.dicty.ui.theme.colorSecondary
import com.flexath.dicty.ui.theme.colorTextDark
import com.flexath.dicty.ui.theme.colorUnselected

@Composable
fun SearchBar(
    query: String,
    modifier: Modifier = Modifier,
    onChangeValue: (String) -> Unit,
) {
    var text by remember {
        mutableStateOf(query)
    }

    TextField(
        value = text,
        onValueChange = {
            text = it
            onChangeValue(text)
        },
        singleLine = true,
        textStyle = TextStyle(
            color = colorTextDark,
            fontFamily = FontFamily(
                Font(
                    R.font.urbanist_medium
                )
            )
        ),
        placeholder = {
            Text(
                text = stringResource(R.string.lbl_search_for_words),
                color = colorUnselected,
                fontFamily = FontFamily(
                    Font(
                        R.font.urbanist_regular
                    )
                )
            )
        },
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.baseline_search_24dp),
                contentDescription = "SearchBar Icon",
                tint = if (text.isEmpty()) {
                    colorUnselected
                } else {
                    colorPrimary
                }
            )
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Search
        ),
        keyboardActions = KeyboardActions(
            onSearch = {

            }
        ),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = colorBackground,
            unfocusedContainerColor = colorBackground,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            focusedTextColor = colorTextDark,
            unfocusedTextColor = colorUnselected,
            cursorColor = colorPrimary
        ),
        modifier = modifier
            .border(
                width = 1.dp,
                color = colorSecondary,
                shape = RoundedCornerShape(MediumPadding3)
            )
    )
}