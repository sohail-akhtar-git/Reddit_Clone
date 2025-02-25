package com.example.reddit_clone.features.auth.dataModels

sealed class AuthState {

    object Loding:AuthState()

    object Authenticated:AuthState()

    object  UnAuthenticated:AuthState()

    data class Error(val message:String) : AuthState()
}