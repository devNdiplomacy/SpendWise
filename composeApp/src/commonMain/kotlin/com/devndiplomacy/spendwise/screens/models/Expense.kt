package com.devndiplomacy.spendwise.screens.models

import kotlinx.serialization.Serializable

@Serializable
data class Expense(
    val id: Int = 0,
    val amount: Double,
    val category: String
)
