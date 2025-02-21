package com.example.reddit_clone.features.homepage.dataLayer.remote.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroFitInstance {

    private const val baseUrl = "https://sohail-akhtar-git.github.io/"
    private fun getRetroFit():Retrofit{
        return  Retrofit
            .Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val postApi = getRetroFit().create(PostApi::class.java)
}