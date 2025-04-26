package com.devndiplomacy.spendwise

import com.devndiplomacy.spendwise.db.tables.Expense
import com.devndiplomacy.spendwise.screens.models.Expense

fun List<com.devndiplomacy.spendwise.db.tables.Expense>.getExpenses(): List<Expense>{

    return this.map { expenseEntity ->
        Expense(
            id = expenseEntity.id,
            amount = expenseEntity.amount,
            category = expenseEntity.category
        )
    }
}