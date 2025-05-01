package com.devndiplomacy.spendwise.core.ui.components

import kotlinx.serialization.Serializable

@Serializable
sealed class Screen () {

     @Serializable
     data object SpendWiseSplashScreen: Screen()

     @Serializable
     data object SpendWiseAddExpenseScreen: Screen()
     
     @Serializable
     data object SpendWiseShowExpenseScreen: Screen()

}

