package com.example.reddit_clone.features.homepage.domainLayer.repository

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.reddit_clone.features.homepage.dataLayer.remote.api.PostApi
import com.example.reddit_clone.features.homepage.domainLayer.dataModels.Post
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class ApiRepository @Inject constructor(
    private val postApi: PostApi
) {


    private  val _postData = MutableStateFlow<List<Post>>(emptyList())



    val postData: StateFlow<List<Post>>
        get() = _postData


    suspend fun getData() {
        val response = postApi.getInitialData()
        val data = response.body()
        if (response.isSuccessful) {
            data?.let {
                _postData.value =  it
            }

            Log.d("Sameer","data aa gya hai")
        } else {
            //
            Log.d("Sameer","Something wrong")
        }
    }

    suspend fun likePost(inde:Int) {
    }

    suspend fun disLikePost(inde: Int){

        _postData.value?.let {
            it[inde].likeCount-=1
        }

    }
}