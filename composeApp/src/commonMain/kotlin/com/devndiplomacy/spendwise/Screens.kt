package com.devndiplomacy.spendwise

import kotlinx.serialization.Serializable

@Serializable
sealed class Screen () {

     @Serializable
     data object ExpenseAddScreen: Screen()
     @Serializable
     data class ExpenseListScreen(val amount:String,val  category:String): Screen()
}