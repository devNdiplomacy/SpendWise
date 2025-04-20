package com.devndiplomacy.spendwise

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.devndiplomacy.spendwise.commonUi.SpendWiseText

@Composable
fun ExpenseListScreen(
    amount:String,
    category:String,
    modifier: Modifier = Modifier
) {

    Column (horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){

        SpendWiseText(
            text = "Expense List Screen",
            style = Typography().h6
        )

        SpendWiseText(
            text = "Amount: $amount",
            style = Typography().body1
        )

        SpendWiseText(
            text = "Category: $category",
            style = Typography().body1
        )
    }

}

