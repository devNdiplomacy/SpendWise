package com.devndiplomacy.spendwise.commonUi

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SpendWiseOutlineTextField(
    value: String,
    label: String,
    placeHolder:String,
    keyboardOptions: KeyboardOptions,
    onValueChange: (String) -> Unit,
    isError: Boolean = false,
    modifier: Modifier = Modifier
) {

    OutlinedTextField(
        value = value,
        onValueChange = { newValue->

            onValueChange(newValue)
        },
        label = { Text(label) },
        placeholder = { Text(placeHolder) },
        isError = isError,
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        singleLine = true,
        keyboardOptions = keyboardOptions,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color(0xFF06402B),
            focusedLabelColor = Color(0xFF06402B)
        )
    )
}