package com.devndiplomacy.spendwise.db.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "expense")
data class ExpenseEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int =0,
    val amount: Double,
    val category:String
)
