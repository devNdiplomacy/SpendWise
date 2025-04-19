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
import kotlinx.serialization.Serializable
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import spendwise.composeapp.generated.resources.Res
import spendwise.composeapp.generated.resources.compose_multiplatform

@Composable
@Preview
fun App() {
    MaterialTheme {
        Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {

            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = Screen1,
                modifier = Modifier.fillMaxWidth()
            ) {
                composable<Screen1> {
                    Screen1(){
                        navController.navigate(Screen2)
                    }
                }

                composable<Screen2> {
                    Screen2(){
                        navController.navigate(Screen3)
                    }
                }

                composable<Screen3> {

                    Screen3()
                }
            }
        }
    }
}

@Composable
fun Screen1(
    nextScreenClick: ()->Unit
){

    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){

        Text("This is screen 1")
        Button(
           onClick = { nextScreenClick() }
        ){
            Text("Click to move to next screen")
        }
    }

}

@Composable
fun Screen2(
    nextScreenClick: ()->Unit
){

    Column (horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){

    Text("This is screen 2")
        Button(
            onClick = { nextScreenClick() }
        ){
            Text("Click to move to next screen")
        }
    }
}

@Composable
fun Screen3(){
    Text("This is screen 3")
}

@Serializable
object Screen1

@Serializable
object Screen2

@Serializable
object Screen3