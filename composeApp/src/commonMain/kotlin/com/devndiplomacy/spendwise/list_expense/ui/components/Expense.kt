package com.devndiplomacy.spendwise.list_expense.ui.components

import kotlinx.serialization.Serializable

@Serializable
data class Expense(
    val id: Long = 0,
    val amount: Double,
    val category: String
)
