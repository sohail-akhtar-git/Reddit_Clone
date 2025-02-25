package com.example.reddit_clone.features.homepage.DI

import com.example.reddit_clone.features.homepage.dataLayer.remote.api.PostApi
import com.example.reddit_clone.features.homepage.domainLayer.repository.ApiRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun getPostApi(): PostApi {
        return  Retrofit
            .Builder()
            .baseUrl("https://sohail-akhtar-git.github.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PostApi::class.java)
    }

    @Provides
    @Singleton
    fun getApiRepo(postApi: PostApi) : ApiRepository{
        return  ApiRepository(postApi = postApi)
    }


}