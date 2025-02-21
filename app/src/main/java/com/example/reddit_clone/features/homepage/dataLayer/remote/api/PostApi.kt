package com.example.reddit_clone.features.homepage.dataLayer.remote.api

import com.example.reddit_clone.features.homepage.domainLayer.dataModels.Post
import retrofit2.Response
import retrofit2.http.GET

interface PostApi {

    @GET("tempdata/temp.json")
    suspend fun getInitialData(): Response<List<Post>>
}