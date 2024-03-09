package com.ayush.work

import androidx.compose.runtime.Composable

import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun Nav(){
    val navController= rememberNavController()
    NavHost(navController = navController, startDestination = "Login"){
        composable(route= "Login"){
            loginscreen(navController)
        }
        composable(route= "Register Screen"){
            signupscreen(navController)
        }
        composable(route= "Home/{name}", arguments = listOf(navArgument(name = "name"){type=
            NavType.StringType})){
            backstackEntry->
            Home(name = backstackEntry.arguments?.getString("name"),navController)
        }
        composable(route= "Your Profile/{name}/{age}/{email}", arguments = listOf(
            navArgument(name = "name"){type= NavType.StringType},
            navArgument(name = "age"){type= NavType.StringType},
            navArgument(name = "email"){type= NavType.StringType})

        ){
            backstackEntry1 ->Profile(name = backstackEntry1.arguments?.getString("name"), age =backstackEntry1.arguments?.getString("age"), emailID = backstackEntry1.arguments?.getString("email"),navController)
        }
        composable(route= "Edit Profile"){
            finalEditProfile(navController)
        }
        composable(route= "Change Password"){
            finalChangePassword(navController)
        }
    }
}