package com.devndiplomacy.spendwise

import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import com.devndiplomacy.spendwise.screensUi.SpendWiseSplashScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {

            SpendWiseSplashScreen()
//            val navController = rememberNavController()
//            NavHost(
//                navController = navController,
//                startDestination = Screen.SpendWiseAddExpenseScreen,
//            ){
//
//                composable<Screen.SpendWiseAddExpenseScreen> {
//                    ExpenseAddScreen(
//                        onBack = { navController.popBackStack() },
//                        onSave = { amount, category ->
//                            // Handle save action
//                            navController.navigate(Screen.SpendWiseShowExpenseScreen(amount, category))
//                        }
//                    )
//                }
//
//                composable<Screen.SpendWiseShowExpenseScreen> {
//
//                    val params = it.toRoute<Screen.SpendWiseShowExpenseScreen>()
//                    val coroutineScope = rememberCoroutineScope()
//                    var isLoading by remember { mutableStateOf(true) }
//                    var amount by remember { mutableStateOf("") } // or whatever default you need
//                    var category by remember { mutableStateOf("") } // or another appropriate default
//
//                    LaunchedEffect(Unit) {
//                        coroutineScope.launch {
//                            val db = getDataBase()
//                            delay(2000)
//                            db.getExpenseDao().insertExpense(ExpenseEntity(amount = params.amount, category = params.category))
//                            val expense = db.getExpenseDao().getAllExpenses().firstOrNull()
//                            if (expense != null) {
//                                amount = expense.amount
//                                category = expense.category
//                            }
//                            isLoading = false
//                        }
//                    }
//
//// Show loading state or content based on data availability
//                    if (isLoading) {
//                        // Show loading indicator
//                        CircularProgressIndicator()
//                    } else {
//                        // Show the screen with data only when ready
//                        ExpenseListScreen(
//                            amount = amount,
//                            category = category,
//                        )
//                    }
//                }
//            }
//        }
    }
}
