package com.devndiplomacy.spendwise.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.devndiplomacy.spendwise.db.models.ExpenseEntity

@Dao
interface ExpenseDao {

     @Insert
     suspend fun insertExpense(expense: ExpenseEntity)

     @Query("SELECT * FROM expense")
     suspend fun getAllExpenses(): List<ExpenseEntity>

     @Delete
     suspend fun deleteExpense(expense: ExpenseEntity)
}