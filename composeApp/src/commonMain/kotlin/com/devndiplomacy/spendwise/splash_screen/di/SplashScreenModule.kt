package com.devndiplomacy.spendwise.splash_screen.di

import com.devndiplomacy.spendwise.getDataBase
import com.devndiplomacy.spendwise.splash_screen.data.SaveExpenseRepository
import com.devndiplomacy.spendwise.splash_screen.domain.SaveExpenseUseCase

object SplashScreenModule {

    fun getSaveExpenseUseCase(
        saveExpenseRepository: SaveExpenseRepository = getSaveExpenseRepository()
    ): SaveExpenseUseCase {
        return SaveExpenseUseCase(
            saveExpense = saveExpenseRepository
        )
    }

    private fun getSaveExpenseRepository(): SaveExpenseRepository {
        return SaveExpenseRepository(
            expenseDao = getDataBase().getExpenseDao(),
            categoryDao = getDataBase().getCategoryDao()
        )
    }
}