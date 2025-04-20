package com.devndiplomacy.spendwise.screensUi

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.devndiplomacy.spendwise.commonUi.SpendWiseBackground
import com.devndiplomacy.spendwise.commonUi.SpendWiseButton
import com.devndiplomacy.spendwise.commonUi.SpendWiseOutlineTextField
import com.devndiplomacy.spendwise.commonUi.SpendWiseText

@Composable
fun SpendWiseExpenseAddScreen(
    onBack: () -> Unit,
    onSave: (String, String) -> Unit
) {
    SpendWiseBackground {

        ExpenseAddScreenContent(
            onBack = onBack,
            onSave = onSave
        )
    }
}

@Composable
fun ExpenseAddScreenContent(
    onBack: () -> Unit,
    onSave: (String, String) -> Unit
) {
    var amount by remember { mutableStateOf("") }
    var category by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Top Bar with back button
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            SpendWiseText(
                text = "Add New Expense",
                style = MaterialTheme.typography.h6
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        SpendWiseOutlineTextField(
            value = amount,
            onValueChange = { newValue ->

                amount = newValue
            },
            label = "Amount",
            placeHolder = "Enter amount",
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
        )

        Spacer(modifier = Modifier.height(16.dp))

        SpendWiseOutlineTextField(
            value = category,
            onValueChange = { newValue ->

                category = newValue
            },
            label = "Category",
            placeHolder = "Enter category (e.g., Food, Transport)",
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.weight(1f))

        // Save button
        SpendWiseButton(
            onClick = {
                onSave(amount, category)
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            text = "Save Expense"
        )
    }
}