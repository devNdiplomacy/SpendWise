package com.devndiplomacy.spendwise

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import com.devndiplomacy.spendwise.splash_screen.ui.SpendWiseSplashScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {

       SpendWiseSplashScreen()
    }
}
