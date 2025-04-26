package com.devndiplomacy.spendwise.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.devndiplomacy.spendwise.db.tables.Expense

@Dao
interface ExpenseDao {

     @Insert
     suspend fun insertExpense(expense: Expense)

     @Query("SELECT * FROM expense")
     suspend fun getAllExpenses(): List<Expense>

     @Delete
     suspend fun deleteExpense(expense: Expense)
}