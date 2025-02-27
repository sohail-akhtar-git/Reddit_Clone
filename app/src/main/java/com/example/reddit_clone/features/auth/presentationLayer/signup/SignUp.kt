package com.example.reddit_clone.features.auth.presentationLayer.signup

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.reddit_clone.features.auth.dataModels.AuthState
import com.example.reddit_clone.features.auth.presentationLayer.LogInScreens
import com.example.reddit_clone.features.auth.viewModel.AuthViewModel


@SuppressLint("StateFlowValueCalledInComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUp(navController: NavHostController, authViewModel: AuthViewModel) {
    
    var email by remember {
        mutableStateOf("")
    }

    val context = LocalContext.current

    var pass by remember {
        mutableStateOf("")
    }

    var modalBottomAppBarState = rememberModalBottomSheetState()

    var modalBtmStatu by remember {
        mutableStateOf(false
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Box(
                        modifier = Modifier.fillMaxSize()
                            .padding(start = 50.dp),
                        contentAlignment = Alignment.Center
                    ){
                        AsyncImage(
                            modifier = Modifier.size(40.dp),
                            model = "https://redditinc.com/hs-fs/hubfs/Reddit%20Inc/Brand/Reddit_Logo.png?width=400&height=400&name=Reddit_Logo.png",
                            contentDescription = null,
                        )
                    }
                },
                actions =
                {
                    TextButton(
                        modifier = Modifier.padding(horizontal = 5.dp),
                        onClick = { navController.navigate(LogInScreens.LoginWithUserName.toString()) }
                    )
                    {
                        Text(text = "LogIn")
                    }
                },
                navigationIcon = { Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)}
            )
        }
    )
    { pd->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(pd)
        ) {
            Card(
                border = BorderStroke(
                    color = Color(0xFF464A61),
                    width = 1.dp
                )
            ) {
                TextField(
                    label = { Text(text = "Email")},
                    value = email,
                    onValueChange =
                    {
                        email = it
                    }
                )
            }


            Spacer(modifier = Modifier.height(20.dp))

            Card(
                border = BorderStroke(
                    color = Color(0xFF464A61),
                    width = 1.dp
                )
            ) {

                TextField(
                    label = { Text(text = "Password")},
                    value = pass,
                    onValueChange =
                    {
                        pass = it
                    }
                )
            }

            ElevatedButton(
                enabled = authViewModel.authState.value!=AuthState.Loding,
                onClick =
                {
                    authViewModel.signUp(email = email, password = pass)

                    if (authViewModel.authState.value is AuthState.Authenticated) {
                       navController.navigate(LogInScreens.MainScreen.toString())
                        Toast.makeText(context, "Logged in ",Toast.LENGTH_SHORT).show()
                    }
                    if(authViewModel.authState.value is AuthState.Error) {
                        Toast.makeText(context, (authViewModel.authState.value as AuthState.Error).message,
                            Toast.LENGTH_SHORT).show()
                       modalBtmStatu = true
                    }


                },
            ) {

                    Text(text = "SignUp")


            }

        }

    }

    if(modalBtmStatu){
        ModalBottomSheet(
            sheetState = modalBottomAppBarState,
            onDismissRequest = { modalBtmStatu = false }
        ) {

            Text(text = " Somethig wrong" )
        }
    }
    
    


}