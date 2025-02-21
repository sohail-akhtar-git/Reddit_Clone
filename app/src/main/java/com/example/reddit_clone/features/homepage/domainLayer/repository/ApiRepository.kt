package com.example.reddit_clone.features.homepage.domainLayer.repository

import android.util.Log
import com.example.reddit_clone.features.homepage.dataLayer.remote.api.RetroFitInstance
import com.example.reddit_clone.features.homepage.domainLayer.dataModels.Post
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ApiRepository {
    private val postApi = RetroFitInstance.postApi

    private  val _postData = MutableStateFlow<List<Post>>(emptyList())



    val postData: StateFlow<List<Post>>
        get() = _postData


    suspend fun getData() {
        val response = postApi.getInitialData()
        if (response.isSuccessful && response.body() != null) {
            _postData.emit(response.body()!!)
            Log.d("Sameer","data aa gya hai")
        } else {
            //
            Log.d("Sameer","Something wrong")
        }
    }
}