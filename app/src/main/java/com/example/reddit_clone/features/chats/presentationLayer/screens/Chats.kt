package com.example.reddit_clone.features.explore.presentationLayer.screens.utils

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier


@Composable
fun Chat(){
    Box(
        modifier = Modifier.fillMaxSize(),

        contentAlignment = Alignment.Center){
        Text(text = "ChatPage")
    }
}