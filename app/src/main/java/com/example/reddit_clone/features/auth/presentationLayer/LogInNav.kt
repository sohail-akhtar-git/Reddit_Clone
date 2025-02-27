package com.example.reddit_clone.features.auth.presentationLayer

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.reddit_clone.MainScreen
import com.example.reddit_clone.Screens
import com.example.reddit_clone.features.auth.presentationLayer.login.screens.LogInWithNumber
import com.example.reddit_clone.features.auth.presentationLayer.login.screens.LogInWithUserName
import com.example.reddit_clone.features.auth.presentationLayer.signup.SignUp
import com.example.reddit_clone.features.auth.viewModel.AuthViewModel


@Composable
fun LogInNavigation(authViewModel: AuthViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.Login.toString()) {
        composable(Screens.Login.toString()) { AuthMainScreen(navController,authViewModel) }
        composable(LogInScreens.LogInWithNumber.toString()) { LogInWithNumber(navController) }
        composable(LogInScreens.LoginWithUserName.toString()) { LogInWithUserName(navController,authViewModel) }
        composable(LogInScreens.MainScreen.toString()) { MainScreen(authViewModel) }
        composable(LogInScreens.SignUp.toString()) { SignUp(navController,authViewModel) }
    }
}


enum class LogInScreens {
    LogInWithNumber,
    LoginWithUserName,
    SignUp,
    MainScreen
}