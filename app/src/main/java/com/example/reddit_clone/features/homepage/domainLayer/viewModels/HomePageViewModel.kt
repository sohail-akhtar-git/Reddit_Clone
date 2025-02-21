package com.example.reddit_clone.features.homepage.domainLayer.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.reddit_clone.features.homepage.domainLayer.dataModels.Post
import com.example.reddit_clone.features.homepage.domainLayer.repository.ApiRepository
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlin.math.truncate


class HomePageViewModel : ViewModel() {

    private val apiRepo = ApiRepository()

    init {
        getPostData()
    }

    val  postData :StateFlow<List<Post>>
    get() = apiRepo.postData

    var _isLoding = true

    fun getPostData(){
        _isLoding = true
        viewModelScope.launch {
            apiRepo.getData()
        }
        _isLoding = false
    }

}