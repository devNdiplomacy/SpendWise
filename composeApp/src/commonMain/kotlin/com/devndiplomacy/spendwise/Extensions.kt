package com.devndiplomacy.spendwise

import com.devndiplomacy.spendwise.db.models.ExpenseEntity
import com.devndiplomacy.spendwise.screensUi.models.Expense

fun List<ExpenseEntity>.getExpenses(): List<Expense>{

    return this.map { expenseEntity ->
        Expense(
            id = expenseEntity.id,
            amount = expenseEntity.amount,
            category = expenseEntity.category
        )
    }
}