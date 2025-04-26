package com.devndiplomacy.spendwise.splash_screen.domain

import com.devndiplomacy.spendwise.splash_screen.data.SaveExpenseRepository

class SaveExpenseUseCase (
    private val saveExpense: SaveExpenseRepository
){

    suspend operator fun invoke(amount: Double, category:String ){

        saveExpense.saveExpense(
            amount = amount,
            category = category
        )
    }
}