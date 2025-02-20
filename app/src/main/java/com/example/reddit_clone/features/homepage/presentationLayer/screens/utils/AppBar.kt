package com.example.reddit_clone.features.homepage.presentationLayer.screens.utils

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage


@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun AppBar(
){
    var query = remember{ mutableStateOf("")}
    var isActive = remember {
        mutableStateOf(false)
    }


    TopAppBar(
        actions = {
            IconButton(
                onClick = { /*TODO*/ }
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