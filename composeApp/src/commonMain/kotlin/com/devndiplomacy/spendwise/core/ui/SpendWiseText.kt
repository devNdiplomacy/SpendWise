package com.devndiplomacy.spendwise.core.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import com.devndiplomacy.spendwise.core.SPEND_WISE_COLOR

@Composable
fun SpendWiseText(
    text:String,
    style: TextStyle,
    color: Color = Color(SPEND_WISE_COLOR),
    fontWeight: FontWeight,
){

  Text(text =  text, style = style, color = color, fontWeight = fontWeight)
}