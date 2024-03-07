package com.ayush.work

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Nav(){
    val navController= rememberNavController()
    NavHost(navController = navController, startDestination = " "){
        composable(route= "Login"){

        }
        composable(route= "Register Screen"){

        }
        composable(route= "Forgot password"){

        }
    }
}