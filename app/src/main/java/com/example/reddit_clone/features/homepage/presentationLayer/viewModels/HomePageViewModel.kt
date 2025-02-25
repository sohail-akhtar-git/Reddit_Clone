package com.example.reddit_clone.features.homepage.presentationLayer.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.reddit_clone.features.homepage.domainLayer.dataModels.Post
import com.example.reddit_clone.features.homepage.domainLayer.repository.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomePageViewModel @Inject constructor(
    private val apiRepo: ApiRepository
) : ViewModel()
{

    init {
        getPostData()
    }

    val  postData :StateFlow<List<Post>>
    get() = apiRepo.postData

    private var _isLoding = true

    private fun getPostData(){
        _isLoding = true
        viewModelScope.launch {
            apiRepo.getData()
        }

        _isLoding = false
    }

    fun likePost(index:Int){
        viewModelScope.launch {
            apiRepo.likePost(index)
        }

    }


    fun disLikePost(index:Int){
        viewModelScope.launch {
            apiRepo.disLikePost(index)
        }

    }

}