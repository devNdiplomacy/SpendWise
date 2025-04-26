package com.devndiplomacy.spendwise.db.tables

import androidx.room.Entity

@Entity(
    tableName = "expense",
    foreignKeys = [
        androidx.room.ForeignKey(
            entity = Category::class,
            parentColumns = ["id"],
            childColumns = ["categoryId"],
            onDelete = androidx.room.ForeignKey.CASCADE
        )
    ]
)
data class Expense(
    val id: Long = 0,
    val amount: Double,
    val categoryId: Long,
    val createdAt: Long,
    val updateAt:Long
)
