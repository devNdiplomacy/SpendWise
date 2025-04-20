package com.devndiplomacy.spendwise

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import spendwise.composeapp.generated.resources.Res
import spendwise.composeapp.generated.resources.compose_multiplatform

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
                ExpenseListScreen(
                   amount =  params.amount,
                   category = params.category
                )
            }
        }
    }
}
