package com.example.reddit_clone

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ChatBubble
import androidx.compose.material.icons.filled.Explore
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.ChatBubbleOutline
import androidx.compose.material.icons.outlined.Explore
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.reddit_clone.features.auth.dataModels.AuthState
import com.example.reddit_clone.features.auth.presentationLayer.LogInNavigation
import com.example.reddit_clone.features.auth.presentationLayer.login.Login
import com.example.reddit_clone.features.auth.viewModel.AuthViewModel
import com.example.reddit_clone.features.explore.presentationLayer.screens.utils.Chat
import com.example.reddit_clone.features.explore.presentationLayer.screens.Explore
import com.example.reddit_clone.features.explore.presentationLayer.screens.utils.Notification
import com.example.reddit_clone.features.explore.presentationLayer.screens.utils.Uploads
import com.example.reddit_clone.features.homepage.presentationLayer.viewModels.HomePageViewModel
import com.example.reddit_clone.features.homepage.presentationLayer.screens.HomeScreen
import com.example.reddit_clone.ui.theme.Reddit_CloneTheme
import dagger.hilt.android.AndroidEntryPoint




@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("StateFlowValueCalledInComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            val authViewModel = viewModel<AuthViewModel>()
            val authState by authViewModel.authState.collectAsStateWithLifecycle()
            Reddit_CloneTheme {
                val context = LocalContext.current
                when(authState){
                    is AuthState.Loding-> Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                        CircularProgressIndicator()
                    }
                    is AuthState.Authenticated-> MainScreen(authViewModel)
                    is AuthState.UnAuthenticated-> LogInNavigation(authViewModel)
                    is AuthState.Error->{
                        Toast.makeText(context, (authViewModel.authState.value as AuthState.Error).message,
                            Toast.LENGTH_SHORT).show()
                        LogInNavigation(authViewModel = authViewModel)
                    }
                }

            }
        }
    }



}


enum class Screens{
    Home,
    Explore,
    Chat,
    Upload,
    Notification,
    Login,
    Profile,
    Settings,
}

@Composable
fun MainScreen(authViewModel: AuthViewModel) {
    val  homeScreenViewModel = hiltViewModel<HomePageViewModel>()
    val navController = rememberNavController()
    val selectedIndex = remember {
        mutableStateOf(Screens.Home.toString())
    }
    Scaffold(
        bottomBar = {
            NavigationBar {
               buttomNavBarItems.forEachIndexed { _, buttomNavBarItem ->
                   val isSelected = buttomNavBarItem.destination==selectedIndex.value
                   NavigationBarItem(
                       alwaysShowLabel = false,
                       selected = isSelected ,
                       onClick = {
                           selectedIndex.value = buttomNavBarItem.destination
                           navController.navigate(buttomNavBarItem.destination)
                                 },
                       icon = {
                           Icon(
                               tint = Color(0xFF9875E2),
                               imageVector = if(isSelected){
                                   buttomNavBarItem.selectedIcon
                               }else{
                                   buttomNavBarItem.unSelectedIcon
                               } ,
                               contentDescription =null )
                       },
                   )
               }

            }
        },
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->

        Box(modifier = Modifier
            .fillMaxSize()
        ){


            NavHost(
                navController = navController,
                startDestination = Screens.Home.toString(),
            ) {

                composable(Screens.Home.toString()) { HomeScreen(authViewModel,homeScreenViewModel) }
                composable(Screens.Explore.toString()) { Explore() }
                composable(Screens.Upload.toString()) { Uploads() }
                composable(Screens.Chat.toString()) { Chat() }
                composable(Screens.Notification.toString()) { Notification() }
                composable(Screens.Login.toString()) { Login(navController, authViewModel) }
            }


        }

    }
}




data class ButtomNavBarItem(
    val label:String,
    val selectedIcon: ImageVector,
    val unSelectedIcon: ImageVector,
    val badgeCount: Int?,
    val hasBadge:Boolean,
    val destination:String
)


val buttomNavBarItems = arrayOf(

    ButtomNavBarItem(
        label = "Home",
        unSelectedIcon = Icons.Outlined.Home,
        selectedIcon = Icons.Filled.Home,
        badgeCount = null,
        hasBadge = false,
        destination = Screens.Home.toString()
    ),
    ButtomNavBarItem(
        label = "Explore",
        unSelectedIcon = Icons.Outlined.Explore,
        selectedIcon = Icons.Filled.Explore,
        badgeCount = null,
        hasBadge = false,
        destination = Screens.Explore.toString()
    ),
    ButtomNavBarItem(
        label = "Upload",
        unSelectedIcon = Icons.Outlined.Add,
        selectedIcon = Icons.Filled.Add,
        badgeCount = null,
        hasBadge = false,
        destination = Screens.Upload.toString()
    ),
    ButtomNavBarItem(
        label = "Chat",
        unSelectedIcon = Icons.Outlined.ChatBubbleOutline,
        selectedIcon = Icons.Filled.ChatBubble,
        badgeCount = null,
        hasBadge = false,
        destination = Screens.Chat.toString()
    ),
    ButtomNavBarItem(
        label = "Notification",
        unSelectedIcon = Icons.Outlined.Notifications,
        selectedIcon = Icons.Filled.Notifications,
        badgeCount = null,
        hasBadge = false,
        destination = Screens.Notification.toString()
    ),
)







