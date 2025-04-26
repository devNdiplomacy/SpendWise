package com.devndiplomacy.spendwise.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.devndiplomacy.spendwise.Screen
import com.devndiplomacy.spendwise.db.tables.Category
import com.devndiplomacy.spendwise.db.tables.Expense
import com.devndiplomacy.spendwise.getDataBase
import kotlinx.coroutines.launch
import kotlinx.datetime.Clock


val spendwiseGreen = Color(0xFF438883)

@Composable
fun SpendWiseSplashScreen(modifier: Modifier = Modifier) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.SpendWiseSplashScreen){

        composable<Screen.SpendWiseSplashScreen> {
            Box(
                modifier = modifier
                    .fillMaxSize()
                    .drawBehind {
                        drawRect(spendwiseGreen)
                    },
                contentAlignment = Alignment.Center
            ) {
                // Logo text
                Text(
                    text = "SpendWise",
                    color = Color.White,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            LaunchedEffect(Unit) {

                val expenseDao = getDataBase().getExpenseDao()
                if (expenseDao.getAllExpenses().isEmpty()) {

                    navController.navigate(Screen.SpendWiseAddExpenseScreen)
                } else {

                    navController.navigate(Screen.SpendWiseShowExpenseScreen)
                }
            }
        }

        composable<Screen.SpendWiseAddExpenseScreen> {

            val coroutineScope = rememberCoroutineScope()
            SpendWiseExpenseAddScreen(
                onBack = {},
                onSave = { amount, category->

                    coroutineScope.launch {
                        val cat = Category(
                            name = category,
                            createdAt = Clock.System.now().toEpochMilliseconds(),
                            updatedAt = Clock.System.now().toEpochMilliseconds()
                        )
                        getDataBase().getCategoryDao().insertCategory(cat)
                        println("Category id is ${getDataBase().getCategoryDao().getAllCategory()}")
                        val catId = getDataBase().getCategoryDao().getCategoryByName(category).id
                        println("Category id is $catId")
                        val exp = Expense(
                            amount = amount.toDouble(),
                            categoryId = catId,
                            createdAt = Clock.System.now().toEpochMilliseconds(),
                            updateAt = Clock.System.now().toEpochMilliseconds()
                        )
                        getDataBase().getExpenseDao().insertExpense(exp)
                        navController.navigate(Screen.SpendWiseShowExpenseScreen)
                    }
                }
            )
        }

        composable<Screen.SpendWiseShowExpenseScreen> {
            SpendWiseShowExpenseScreen{
                navController.navigate(Screen.SpendWiseAddExpenseScreen)
            }
        }


    }

}

@Composable
fun SpendWiseLoadingScreen(
    modifier: Modifier = Modifier
) {

    Box(
        modifier = modifier
            .fillMaxSize()
            .drawBehind {
                drawRect(spendwiseGreen)
            },
        contentAlignment = Alignment.Center
    ) {
        // Logo text
        Text(
            text = "SpendWise",
            color = Color.White,
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold
        )
    }
}