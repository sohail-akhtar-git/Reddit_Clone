package com.example.reddit_clone.features.auth.presentationLayer.login.screens

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.reddit_clone.features.auth.dataModels.AuthState
import com.example.reddit_clone.features.auth.presentationLayer.LogInScreens
import com.example.reddit_clone.features.auth.utils.validateEmail
import com.example.reddit_clone.features.auth.utils.validatePass
import com.example.reddit_clone.features.auth.viewModel.AuthViewModel
import kotlinx.coroutines.withContext


@SuppressLint("StateFlowValueCalledInComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LogInWithUserName(navController: NavHostController, authViewModel: AuthViewModel){

    var email by remember {
        mutableStateOf("")
    }

    var emailError by remember {
        mutableStateOf(false)
    }

    var passError by remember {
        mutableStateOf(false)
    }

    var pass by remember {
        mutableStateOf("")
    }



    var context = LocalContext.current

    val modalBottomAppBarState = rememberModalBottomSheetState()

    var modalBtmStatu by remember {
        mutableStateOf(false
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(start = 60.dp),
                        contentAlignment = Alignment.Center
                        ){
                        AsyncImage(
                            modifier = Modifier.size(40.dp),
                            model = "https://redditinc.com/hs-fs/hubfs/Reddit%20Inc/Brand/Reddit_Logo.png?width=400&height=400&name=Reddit_Logo.png",
                            contentDescription = null,
                        )
                    }
                },
                actions = {
                    TextButton(
                        modifier = Modifier.padding(horizontal = 5.dp),
                        onClick =
                        {
                            navController.navigate(LogInScreens.SignUp.toString())
                        }
                    )
                    {
                        Text(text = "SignUp")
                    }
                },
                navigationIcon = { Icon(imageVector = Icons.AutoMirrored.Outlined.ArrowBack, contentDescription = null) }
            )
        }
    )
    { pd->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxSize()
                .padding(pd)
        ) {


            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    contentAlignment = Alignment.Center
                )
                {
                    Text(
                        text = "Log in",
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 25.sp,
                    )
                }

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    border = BorderStroke(
                        color = if(emailError) Color.Red else Color(0xFF464A61),
                        width = 1.dp
                    )
                ) {
                    TextField(
                        maxLines = 1,
                        isError = emailError,
                        label = { Text(text = "Email") },
                        value = email,
                        onValueChange =
                        {
                            email = it
                        }
                    )
                }


                Spacer(modifier = Modifier.height(20.dp))

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    border = BorderStroke(
                        color = if(passError) Color.Red else Color(0xFF464A61),
                        width = 1.dp
                    )
                ) {

                    TextField(
                        isError = passError,
                        label = { Text(text = "Password") },
                        value = pass,
                        onValueChange =
                        {
                            pass = it
                        },
                        maxLines = 1
                    )
                }

                TextButton(
                    colors = ButtonColors(
                        contentColor = Color.Red,
                        containerColor = Color.Transparent,
                        disabledContentColor = Color.Unspecified,
                        disabledContainerColor = Color.Unspecified
                    ),
                    onClick = { /*TODO*/ }
                ) {
                    Text(text = "Forgot password?")
                }

                TextButton(
                    colors = ButtonColors(
                        contentColor = Color.Red,
                        containerColor = Color.Transparent,
                        disabledContentColor = Color.Unspecified,
                        disabledContainerColor = Color.Unspecified
                    ),
                    onClick = { /*TODO*/ }
                ) {
                    Text(text = "Email me a login link instead")
                }

            }

            ElevatedButton(
                colors = ButtonColors(
                    contentColor = Color.White,
                    containerColor = Color(0xFFF4511D),
                    disabledContentColor = Color.LightGray,
                    disabledContainerColor = Color.Gray
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                enabled = email.length!=0 && pass.length>=8,
                onClick =
                {

                    if(!validateEmail(email)){
                        emailError = true

                    }else{
                        emailError = false
                    }

                    if(!validatePass(pass)){
                        passError = true
                    }else{
                        passError = false
                    }


                    if(!emailError && !passError){
                        authViewModel.logInWithEmail(email = email, password = pass)
                        if (authViewModel.authState.value is AuthState.Authenticated) {

                            navController.navigate(LogInScreens.MainScreen.toString())
                        }
                        if(authViewModel.authState.value is AuthState.Error) {
                            modalBtmStatu = true
                        }
                    }else{
                        Toast.makeText(context , "Email or password is not valid",Toast.LENGTH_SHORT).show()
                    }

                },
            ) {
                Text(text = "LogIn")
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

