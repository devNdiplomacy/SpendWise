package com.devndiplomacy.spendwise.commonUi

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle

@Composable
fun SpendWiseText(
    text:String,
    style: TextStyle
){

    Text(
       text =  text,
        style = style
    )
}