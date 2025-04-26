package com.devndiplomacy.spendwise.splash_screen.data

import com.devndiplomacy.spendwise.db.dao.CategoryDao
import com.devndiplomacy.spendwise.db.dao.ExpenseDao
import com.devndiplomacy.spendwise.db.tables.Category
import com.devndiplomacy.spendwise.db.tables.Expense
import kotlinx.datetime.Clock

class SaveExpenseRepository(
    private val expenseDao: ExpenseDao,
    private val categoryDao: CategoryDao
) {

    suspend fun saveExpense(amount: Double, category: String) {

        // For now storing it in Local Db

        if( categoryDao.getCategoryByName(category) == null){

            categoryDao.insertCategory(
                Category(
                    name = category,
                    createdAt = Clock.System.now().toEpochMilliseconds(),
                    updatedAt = Clock.System.now().toEpochMilliseconds()
                )
            )
        }

        val catId = categoryDao.getCategoryByName(category)?.id ?: throw Exception("Category not found")
        expenseDao.insertExpense(
            Expense(
                amount = amount,
                categoryId = catId,
                createdAt = Clock.System.now().toEpochMilliseconds(),
                updateAt = Clock.System.now().toEpochMilliseconds()
            )
        )
    }
}