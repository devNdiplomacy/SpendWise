package com.devndiplomacy.spendwise

import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.devndiplomacy.spendwise.db.SpendWiseDatabaseConstructor
import com.devndiplomacy.spendwise.db.dao.ExpenseDao
import com.devndiplomacy.spendwise.db.models.ExpenseEntity
import com.devndiplomacy.spendwise.screensUi.ExpenseAddScreen
import com.devndiplomacy.spendwise.screensUi.ExpenseListScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = Screen.ExpenseAddScreen,
        ){

            composable<Screen.ExpenseAddScreen> {
                ExpenseAddScreen(
                    onBack = { navController.popBackStack() },
                    onSave = { amount, category ->
                        // Handle save action
                        navController.navigate(Screen.ExpenseListScreen(amount, category))
                    }
                )
            }

            composable<Screen.ExpenseListScreen> {

                val params = it.toRoute<Screen.ExpenseListScreen>()
                val coroutineScope = rememberCoroutineScope()
                var isLoading by remember { mutableStateOf(true) }
                var amount by remember { mutableStateOf("") } // or whatever default you need
                var category by remember { mutableStateOf("") } // or another appropriate default

                LaunchedEffect(Unit) {
                    CoroutineScope(Dispatchers.Default).launch {
                        val db = getDataBase()
                        delay(2000)
                        db.getExpenseDao().insertExpense(ExpenseEntity(amount = params.amount, category = params.category))
                        val expense = db.getExpenseDao().getAllExpenses().firstOrNull()
                        if (expense != null) {
                            amount = expense.amount
                            category = expense.category
                        }
                        isLoading = false
                    }
                }

// Show loading state or content based on data availability
                if (isLoading) {
                    // Show loading indicator
                    CircularProgressIndicator()
                } else {
                    // Show the screen with data only when ready
                    ExpenseListScreen(
                        amount = amount,
                        category = category,
                    )
                }
            }
        }
    }
}
