package com.devndiplomacy.spendwise

import com.devndiplomacy.spendwise.db.models.ExpenseEntity
import com.devndiplomacy.spendwise.screensUi.models.Expense
import kotlinx.serialization.Serializable

@Serializable
sealed class Screen () {

     @Serializable
     data object SpendWiseHomeScreen: Screen()

     @Serializable
     data object SpendWiseSplashScreen: Screen()

     @Serializable
     data object SpendWiseAddExpenseScreen: Screen()
     
     @Serializable
     data object SpendWiseShowExpenseScreen: Screen()

}

