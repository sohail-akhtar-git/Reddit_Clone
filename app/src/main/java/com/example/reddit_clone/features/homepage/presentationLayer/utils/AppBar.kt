package com.example.reddit_clone.features.homepage.presentationLayer.utils

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.reddit_clone.Screens


@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun AppBar(navController: NavHostController) {
    val query = remember{ mutableStateOf("")}
    val isActive = remember {
        mutableStateOf(false)
    }


    TopAppBar(
        actions = {
            IconButton(
                onClick = { navController.navigate(Screens.Login.toString()) }
            )
            {
                Icon(tint = Color(0xFF9875E2),imageVector = Icons.Default.Settings, contentDescription = null)
            }
        },
        navigationIcon = {
            IconButton(
                onClick = { /*TODO*/ }
            )
            {
                AsyncImage(
                    contentScale = ContentScale.Crop,
                    model = "https://imgs.search.brave.com/ul1ELzJhn3eDT8eV6L6sFVf3Ca6nEr9s5DHA1JybFYE/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9tZWRp/YS5zcHJvdXRzb2Np/YWwuY29tL3VwbG9h/ZHMvMjAyMi8wNi9w/cm9maWxlLXBpY3R1/cmUuanBlZw",
                    contentDescription = "Profile",
                    modifier = Modifier
                        .clip(CircleShape)

                )
            }
        },
        title = {
            SearchBar(
                modifier = Modifier.height(50.dp),
                query = query.value,
                onQueryChange ={query.value = it} ,
                placeholder = { Text(text = "Search")},
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Search, contentDescription = null)
                },
                onSearch =
                {
                    println(query.value)
                } ,
                active =isActive.value ,
                onActiveChange ={isActive.value = it}
            ){}
        },


    )
}