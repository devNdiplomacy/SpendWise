package com.devndiplomacy.spendwise.splash_screen.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.devndiplomacy.spendwise.core.ui.components.Screen
import com.devndiplomacy.spendwise.getDataBase
import com.devndiplomacy.spendwise.add_expense.ui.AddExpenseScreen
import com.devndiplomacy.spendwise.list_expense.ui.SpendWiseShowExpenseScreen
import com.devndiplomacy.spendwise.splash_screen.di.SplashScreenModule
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


val spendwiseGreen = Color(0xFF438883)

@Composable
fun SpendWiseSplashScreen(modifier: Modifier = Modifier) {

    val navController = rememberNavController()
    val saveExpenses = remember { SplashScreenModule.getSaveExpenseUseCase() }
    val coroutineScope = rememberCoroutineScope()

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

                delay(2000) // 2 seconds delay
                val expenseDao = getDataBase().getExpenseDao()
                if (expenseDao.getAllExpenses().isEmpty()) {

                    navController.navigate(Screen.SpendWiseAddExpenseScreen)
                } else {

                    navController.navigate(Screen.SpendWiseShowExpenseScreen)
                }
            }
        }

        composable<Screen.SpendWiseAddExpenseScreen> {

            AddExpenseScreen(
                onBack = { navController.navigate(Screen.SpendWiseSplashScreen) },
                onSave = { amount, category,description ->

                    coroutineScope.launch {

                        saveExpenses.invoke(amount = amount.toDouble(), category = category)
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