package com.example.reddit_clone.features.auth.viewModel

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.reddit_clone.features.auth.dataModels.AuthState
import com.google.firebase.Firebase
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.auth
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {




    private val firbase = Firebase.auth

    private val _authStatus = MutableStateFlow<AuthState>(AuthState.UnAuthenticated)

    val authState  =  _authStatus.onStart { isLoggedIn() }.stateIn(viewModelScope,
        SharingStarted.WhileSubscribed(5000L), false)





    fun logInWithEmail(
        email: String,
        password:String
    ){
        _authStatus.value = AuthState.Loding

        viewModelScope.launch {
            firbase.signInWithEmailAndPassword(
                email,
                password
            ).addOnCompleteListener {
                    status->

                if(status.isSuccessful){
                    _authStatus.value = AuthState.Authenticated
                }else{
                    _authStatus.value = AuthState.Error(status.exception?.message?:"Something Wrong")
                }
            }
        }

    }


    fun logInWithNumber(
        number:Int
    ){

    }


    fun isLoggedIn(){
       if(firbase.currentUser!=null){
           _authStatus.value = AuthState.Authenticated
       }else{
           _authStatus.value = AuthState.UnAuthenticated
       }
    }


    fun signUp(email: String,password: String){
        _authStatus.value = AuthState.Loding
        viewModelScope.launch {
            firbase.createUserWithEmailAndPassword(email,password).addOnCompleteListener { res->
                if(res.isSuccessful){
                    _authStatus.value = AuthState.Authenticated
                }else{
                    _authStatus.value = AuthState.Error(res?.exception?.message?:"Something wrong while signup")
                }
            }
        }
    }

    fun logOut(){
        _authStatus.value = AuthState.UnAuthenticated
        viewModelScope.launch {
            firbase.signOut()
        }
    }


}
