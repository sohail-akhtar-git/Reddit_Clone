package com.example.reddit_clone.features.homepage.domainLayer.repository

import android.util.Log
import com.example.reddit_clone.features.homepage.dataLayer.remote.api.PostApi
import com.example.reddit_clone.features.homepage.domainLayer.dataModels.Post
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class ApiRepository @Inject constructor(
    private val postApi: PostApi
) {


    private  val _postData = MutableStateFlow<List<Post>>(emptyList())

    private var data= emptyList<Post>()

    val postData: StateFlow<List<Post>>
        get() = _postData


    suspend fun getData() {
        val response = postApi.getInitialData()
        if (response.isSuccessful && response.body() != null) {
            _postData.emit(response.body()!!)
            data = _postData.value
            Log.d("Sameer","data aa gya hai")
        } else {
            //
            Log.d("Sameer","Something wrong")
        }
    }

    suspend fun likePost(inde:Int) {
        data[inde].likeCount += 1
        _postData.emit(data)
    }

    suspend fun disLikePost(inde: Int){
        _postData.value[inde].likeCount -=1
        _postData.emit(_postData.value)

    }
}