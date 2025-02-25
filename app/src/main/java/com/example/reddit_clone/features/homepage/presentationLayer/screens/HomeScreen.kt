package com.example.reddit_clone.features.homepage.presentationLayer.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.reddit_clone.Composables.PostCard
import com.example.reddit_clone.Screens
import com.example.reddit_clone.features.auth.viewModel.AuthViewModel
import com.example.reddit_clone.features.homepage.domainLayer.dataModels.Post
import com.example.reddit_clone.features.homepage.presentationLayer.viewModels.HomePageViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(authViewModel: AuthViewModel, homeScreenViewModel: HomePageViewModel) {


    val data = homeScreenViewModel.postData.collectAsState()

    Scaffold(
        topBar = {
            val query = remember{ mutableStateOf("") }
            val isActive = remember {
                mutableStateOf(false)
            }


            TopAppBar(
                actions = {
                    IconButton(
                        onClick = { }
                    )
                    {
                        Icon(tint = Color(0xFF9875E2),imageVector = Icons.Default.Settings, contentDescription = null)
                    }
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            authViewModel.logOut()
                        }
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
    ) {pd->
        Surface (
            modifier = Modifier.padding(pd)
        ){
            if(data.value.isEmpty()){
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                    CircularProgressIndicator(color = Color.Red)
                }
            }else {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentPadding = PaddingValues(horizontal = 4.dp, vertical = 5.dp),
                    state = remember {
                        LazyListState()
                    }
                ) {
                    item {
                        data.value.forEachIndexed { index, it ->
                            PostCard(
                                post = Post(
                                    title = it.title,
                                    comentsCount = it.comentsCount,
                                    uploadTime = it.uploadTime,
                                    author = it.author,
                                    likeCount = it.likeCount,
                                    postItems = it.postItems,
                                    comments = it.comments,
                                ),
                                model=homeScreenViewModel,
                                index = index
                            )
                        }

//                postList.forEach {
//                    PostCard(post = it)
//                }
                    }
                }
            }
        }
    }
}