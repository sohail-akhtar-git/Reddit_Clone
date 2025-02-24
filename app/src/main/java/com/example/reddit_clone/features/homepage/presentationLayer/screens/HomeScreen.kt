package com.example.reddit_clone.features.homepage.presentationLayer.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.reddit_clone.Composables.PostCard
import com.example.reddit_clone.features.homepage.domainLayer.dataModels.Post
import com.example.reddit_clone.features.homepage.domainLayer.dataModels.postList
import com.example.reddit_clone.features.homepage.presentationLayer.viewModels.HomePageViewModel


@Composable
fun HomeScreen(homeScreenViewModel: HomePageViewModel) {



    val data = homeScreenViewModel.postData.collectAsState()

    if(data.value.isEmpty()){
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
            Text(text="Loding")
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