package com.example.reddit_clone.features.auth.presentationLayer

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MobileFriendly
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.reddit_clone.features.auth.dataModels.AuthState
import com.example.reddit_clone.features.auth.viewModel.AuthViewModel

@Composable
fun AuthMainScreen(navController: NavHostController, authViewModel: AuthViewModel) {



    val context = LocalContext.current

    var isSignUp  by remember {
        mutableStateOf(false)
    }


    Surface {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .weight(3f)
                    .padding(20.dp)

            ){
                Column(Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,

                    )
                {

                    AsyncImage(
                        modifier = Modifier
                            .size(80.dp)
                            .padding(20.dp),
                        model = "https://redditinc.com/hs-fs/hubfs/Reddit%20Inc/Brand/Reddit_Logo.png?width=400&height=400&name=Reddit_Logo.png",
                        contentDescription = null,
                    )

                    Text(
                        modifier = Modifier.padding(20.dp),
                        text = if(isSignUp) "Sign up for Reddit" else "Log in to Reddit",
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 30.sp,

                        )

                    Card(
                        border = BorderStroke(
                            color = Color.Black,
                            width = 1.dp
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                        ,
                        onClick = { navController.navigate(LogInScreens.LogInWithNumber.toString()) },
                    )
                    {
                        Row (
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(10.dp)
                        ) {
                            Icon(modifier = Modifier.weight(1f),imageVector = Icons.Default.MobileFriendly, contentDescription = null)

//                        Spacer(modifier = Modifier.width(20.dp))

                            Text(
                                modifier = Modifier.weight(4f),
                                text = "Continue with phone number",
                                textAlign = TextAlign.Center
                            )
                        }
                    }


                    Card(
                        border = BorderStroke(
                            color = Color.Black,
                            width = 1.dp
                        ),
//
                        modifier = Modifier
                            .fillMaxWidth()
                        ,
                        onClick = {

                            authViewModel.logInWithGoogle(context = context)

                            if(authViewModel.authState.value is AuthState.Authenticated){
                                navController.navigate(LogInScreens.MainScreen.toString())
                            }

                            if(authViewModel.authState.value is AuthState.Error){

                                Toast.makeText(
                                    context,
                                    (authViewModel.authState.value as AuthState.Error).message,
                                    Toast.LENGTH_SHORT

                                ).show()
                            }

                        },
                    )
                    {
                        Row (
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(10.dp)
                        ) {


                            Icon(modifier = Modifier.weight(1f),imageVector = Icons.Outlined.Email, contentDescription = null)

//                        Spacer(modifier = Modifier.width(20.dp))

                            Text(
                                modifier = Modifier.weight(4f),
                                text = "Continue with Google",
                                textAlign = TextAlign.Center
                            )
                        }
                    }

                    Card(
                        border = BorderStroke(
                            color = Color.Black,
                            width = 1.dp
                        ),

                        modifier = Modifier
                            .fillMaxWidth()
                        ,
                        onClick = {
                            if(isSignUp){
                                navController.navigate(LogInScreens.SignUp.toString())
                            }else{
                                navController.navigate(LogInScreens.LoginWithUserName.toString())
                            }

                        },
                    )
                    {
                        Row (
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(10.dp)
                        ){
                            Icon(
                                modifier = Modifier.weight(1f),
                                imageVector = Icons.Default.Person, contentDescription =null )

//                        Spacer(modifier = Modifier.width(15.dp))

                            Text(
                                modifier = Modifier.weight(4f),
                                text = "Continue with email",
                                textAlign = TextAlign.Center
                            )
                        }

                    }


                }
            }



            Box(modifier = Modifier
                .weight(1f)
                .padding(20.dp)
                .fillMaxWidth()

            ){

                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "By continuing, you agree to our User Agreement and acknowledge that you understand the Privacy Policy.",
                        fontWeight = FontWeight.Normal,
                        fontSize = 10.sp,
                    )

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        var selected  by remember{mutableStateOf(false)}

                        Checkbox(
                            checked = selected,
                            onCheckedChange = {
                                selected  = it
                            }
                        )
                        Text(
                            fontWeight = FontWeight.Normal,
                            fontSize = 10.sp,
                            text = "I agree to receve emails about cool stuff on Reddit")
                    }

                    HorizontalDivider(thickness = 1.dp)

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = if(isSignUp) "Already have an account?" else  "Don't have account? ")
                        TextButton(onClick = { isSignUp = !isSignUp }) {
                            Text(text = if(isSignUp) "Log in " else "SignUp")
                        }
                    }
                }


            }

        }
    }
}