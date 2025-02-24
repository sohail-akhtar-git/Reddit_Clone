package com.example.reddit_clone.features.auth.login.presentationLayer

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.reddit_clone.MainScreen
import com.example.reddit_clone.Screens
import com.example.reddit_clone.features.auth.login.presentationLayer.screens.LogInWithNumber
import com.example.reddit_clone.features.auth.login.presentationLayer.screens.Login


@Composable
fun LogInNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screens.Login.toString()) {

        composable(Screens.Login.toString()) { Login(navController) }
        composable(LogInScreens.LogInWithNumber.toString()) { LogInWithNumber(navController) }
        composable(LogInScreens.LoginWithUserName.toString()) { MainScreen() }
        composable(LogInScreens.MainScreen.toString()) { MainScreen() }
    }
}


enum class LogInScreens {
    LogInWithNumber,
    LoginWithUserName,
    SignUp,
    MainScreen
}