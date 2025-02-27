package com.example.reddit_clone.features.auth.dataModels

sealed class AuthState {

    object Loding:AuthState()

    data class Authenticated(
        val name:String?,
        val email:String?,
        val profilePicUrl:String?,
        val phoneNumber:String?
    ):AuthState()

    object  UnAuthenticated:AuthState()

    data class Error(val message:String) : AuthState()
}