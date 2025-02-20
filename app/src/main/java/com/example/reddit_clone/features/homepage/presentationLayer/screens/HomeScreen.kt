package com.example.reddit_clone.features.homepage.presentationLayer.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.reddit_clone.Composables.PostCard
import com.example.reddit_clone.features.homepage.dataLayer.dataModels.postList


@Composable
fun HomeScreen(){
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(horizontal = 4.dp, vertical = 5.dp),
        state = remember {
            LazyListState()
        }
    ) {
        item {
            postList.forEach { PostCard(post =it) }
        }
    }
}