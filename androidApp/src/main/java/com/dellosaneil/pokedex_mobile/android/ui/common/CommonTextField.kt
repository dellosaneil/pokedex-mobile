package com.dellosaneil.pokedex_mobile.android.ui.common

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dellosaneil.pokedex_mobile.android.R
import com.dellosaneil.pokedex_mobile.android.theme.ComposeColorFactory.getComposeColors
import com.dellosaneil.pokedex_mobile.android.theme.ComposeTypographyFactory.getComposeTypography

@Composable
fun CommonTextField(
    modifier: Modifier,
    text: MutableState<String>,
    @StringRes placeholderRes: Int,
    @DrawableRes leadingIcon: Int? = null,
    @DrawableRes trailingIcon: Int? = null,
    maxLines: Int = Int.MAX_VALUE,
    keyboardOptions: KeyboardOptions = KeyboardOptions(),
    keyboardActions: KeyboardActions = KeyboardActions(),
    isError: Boolean = false,
) {
    TextField(
        modifier = modifier,
        value = text.value,
        onValueChange = { newText ->
            text.value = newText
        },
        placeholder = {
            Text(text = stringResource(id = placeholderRes))
        },
        leadingIcon = {
            if (leadingIcon != null) {
                Icon(painter = painterResource(id = leadingIcon),
                    contentDescription = null,
                    modifier = Modifier.size(18.dp))
            }
        },
        shape = RoundedCornerShape(size = 8.dp),
        maxLines = maxLines,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        isError = isError,
        trailingIcon = {
            if (trailingIcon != null) {
                Icon(
                    painter = painterResource(id = trailingIcon),
                    contentDescription = null,
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(size = 4.dp))
                        .clickable {
                            text.value = ""
                        }
                        .size(size = 18.dp)
                        .padding(all = 2.dp)

                )
            }
        },
        colors = TextFieldDefaults.textFieldColors(
            textColor = getComposeColors().commonColors.black,
            backgroundColor = getComposeColors().commonColors.lightGray2,
            cursorColor = getComposeColors().commonColors.black,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
        ),
        textStyle = getComposeTypography().regular14,
        singleLine = maxLines == 1,
    )
}

@SuppressLint("UnrememberedMutableState")
@Preview(showBackground = true)
@Composable
private fun PreviewCommonTextField() {
    Box(
        modifier = Modifier
            .background(color = getComposeColors().commonColors.lightGray1)
            .size(500.dp),
        contentAlignment = Alignment.Center,
    ) {
        CommonTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            text = mutableStateOf(""),
            placeholderRes = R.string.pokemon_list_search_placeholder,
            leadingIcon = R.drawable.search,
            trailingIcon = R.drawable.close,
        )
    }
}
