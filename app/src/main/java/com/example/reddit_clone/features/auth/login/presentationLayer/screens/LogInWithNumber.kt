package com.example.reddit_clone.features.auth.login.presentationLayer.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Flag
import androidx.compose.material.icons.filled.RemoveRedEye
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ModalBottomSheetDefaults
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import com.example.reddit_clone.Screens
import com.example.reddit_clone.features.auth.login.presentationLayer.LogInScreens
import com.example.reddit_clone.features.explore.presentationLayer.screens.utils.Chat
import com.example.reddit_clone.features.homepage.presentationLayer.utils.AppBar


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnrememberedMutableState")
@Composable
fun LogInWithNumber(navController: NavHostController) {

    var countryCode by remember {
        mutableStateOf("")
    }

    var number by remember {
        mutableStateOf("")
    }

    var sheetState = rememberModalBottomSheetState()
    var showModel by remember {
        mutableStateOf(false)
    }


    Scaffold(
        topBar = {
            TopAppBar(
                title = { /*TODO*/ },
                navigationIcon = {
                    Icon(
                        imageVector = Icons.Rounded.ArrowBack,
                        contentDescription = null )
                }


            )
        },
    ) {it->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            Column {
                Text(
                    modifier = Modifier.padding(
                        top = 20.dp,
                        bottom = 20.dp,
                        start = 5.dp,
                        end = 5.dp
                    ),
                    text = "Sign up or log in with your phone number",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp

                )

                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Card(
                        border = BorderStroke(color = Color.Black, width = 1.dp),
                        onClick = {
                            showModel = true
                        }) {
                        Row(
                            modifier = Modifier.padding(top = 15.dp, bottom = 15.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            //flag
                            Icon(imageVector = Icons.Default.Flag, contentDescription = null)
                            Text(text = "+91")
                            Icon(
                                imageVector = Icons.Rounded.KeyboardArrowDown,
                                contentDescription = null
                            )
                        }
                    }

                    Card(
                        border = BorderStroke(color = Color.Black, width = 1.dp),
                    ) {
                        TextField(
                            shape = RoundedCornerShape(
                                topEnd = 10.dp,
                                topStart = 10.dp,
                                bottomStart = 10.dp,
                                bottomEnd = 10.dp
                            ),
                            value = number,
                            onValueChange = {
                                number = it
                            },
                            label = { Text("Phone Number") },
                            enabled = true,
                        )
                    }
                }
                Box(modifier = Modifier.padding(10.dp))
                {
                    Text(
                        fontSize = 10.sp,
                        text = "Reddit will use your phone number for account verification and to personalize your ads and experience. By entering your phone number, you agree that Reddit may send you verification messages via either WhatsApp or SMS. SMS fees may apply."
                    )
                }


                TextButton(
                    onClick = { /*TODO*/ }) {
                    Text(text = "Learn more.")
                }
            }

            ElevatedButton(
                enabled = number.length == 10,
                colors = ButtonColors(
                    contentColor = Color.White,
                    containerColor = Color(0xFFF4511D),
                    disabledContentColor = Color.LightGray,
                    disabledContainerColor = Color.Gray
                ),
                modifier = Modifier.fillMaxWidth(),
                onClick = { /*TODO*/ }
            ) {
                Text(
                    text = "Continue",
                    fontSize = 30.sp,
                    modifier = Modifier.padding(5.dp)
                )
            }
            if(showModel){
                ModalBottomSheet(
                    onDismissRequest = {
                        showModel=false
                                       },
                    sheetState = sheetState
                    ) {

                }

            }


        }
    }


}