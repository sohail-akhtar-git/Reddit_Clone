package com.example.reddit_clone.features.homepage.presentationLayer.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.reddit_clone.Composables.PostCard
import com.example.reddit_clone.features.auth.dataModels.AuthState
import com.example.reddit_clone.features.auth.viewModel.AuthViewModel
import com.example.reddit_clone.features.homepage.domainLayer.dataModels.Post
import com.example.reddit_clone.features.homepage.presentationLayer.viewModels.HomePageViewModel
import kotlinx.coroutines.launch


@SuppressLint("StateFlowValueCalledInComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(authViewModel: AuthViewModel, homeScreenViewModel: HomePageViewModel) {


    val data = homeScreenViewModel.postData.collectAsState()

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed )
    val scope = rememberCoroutineScope()


    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {

            }
        },
        gesturesEnabled = true,
    ) {
        Scaffold(

            topBar = {

                TopAppBar(
                    actions = {
                        IconButton(
                            onClick = {
                                scope.launch {
                                    drawerState.open()
                                }
                            }
                        )
                        {
                            AsyncImage(
                                contentScale = ContentScale.Crop,
                                model =(authViewModel.authState.value as AuthState.Authenticated).profilePicUrl,
                                contentDescription = "Profile",
                                modifier = Modifier
                                    .clip(CircleShape)

                            )
                        }
                    },
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                authViewModel.logOut()
                            }
                        )
                        {
                            Icon(imageVector = Icons.Rounded.Menu, contentDescription = null)
                        }
                    },
                    title = {
                        TextButton(onClick = { /*TODO*/ }) {
                            Text(text = "reddit")
                        }
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


}

