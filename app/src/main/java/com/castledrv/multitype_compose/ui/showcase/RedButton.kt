package com.castledrv.multitype_compose.ui.showcase

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ExperimentalComposeApi
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp


@ExperimentalUnitApi
@ExperimentalComposeApi
@Composable
fun RedButton(
    modifier: Modifier = Modifier,
    text: String,
    isAdded: Boolean = false,
    isDark: Boolean = false
) {
    Box(
        modifier = modifier
            .size(height = 28.dp, width = 88.dp)
            .clip(RoundedCornerShape(2.dp))
            .background(
                color = RedButtonColorDelegate(
                    isDark = isDark,
                    isAdded = isAdded
                ).btnColor
            )
    ) {
        Text(
            text = text,
            color = RedButtonColorDelegate(
                isDark = isDark,
                isAdded = isAdded
            ).textColor,
            fontSize = TextUnit(14f, TextUnitType.Sp),
            fontWeight = FontWeight(600),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .align(Alignment.Center)
                .padding(start = 8.dp, end = 8.dp)
        )
    }
}


class RedButtonColorDelegate(private val isDark: Boolean, private val isAdded: Boolean) {
    val btnColor: Color = if (isAdded) {
        btnColorAdded
    } else {
        btnColorAdd
    }
    val textColor: Color = if (isAdded) {
        textColorAdded
    } else {
        textColorAdd
    }


    private val btnColorAdd: Color
        get() =
            if (isDark) {
                Color(0xFFFE2C55)
            } else {
                Color(0xFFFE2C55)
            }

    private val textColorAdd: Color
        get() = Color.White


    private val btnColorAdded: Color
        get() =
            if (isDark) {
                Color(0x14FFFFFF)
            } else {
                Color(0xF161823)
            }

    private val textColorAdded: Color
        get() =
            if (isDark) {
                Color(0x57FFFFFF)
            } else {
                Color(0x57161823)
            }
}