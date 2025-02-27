package com.example.reddit_clone.features.auth.viewModel

import android.content.Context
import android.util.Log
import androidx.credentials.CredentialManager
import androidx.credentials.CustomCredential
import androidx.credentials.GetCredentialRequest
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.reddit_clone.features.auth.dataModels.AuthState
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import com.google.firebase.Firebase
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.auth
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class AuthViewModel : ViewModel() {



    private  val  webClientId = "128740427861-1i63lcosleoeqpp3h09e1ullqpkienul.apps.googleusercontent.com"

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
                    _authStatus.value = AuthState.Authenticated(
                        email = email,
                        phoneNumber = null,
                        name = null,
                        profilePicUrl = null
                    )
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


    private fun isLoggedIn(){
       if(firbase.currentUser!=null){
           val user = firbase.currentUser

           _authStatus.value = AuthState.Authenticated(
               email = user?.email,
               phoneNumber = user?.phoneNumber,
               name = user?.displayName,
               profilePicUrl = user?.photoUrl.toString()
           )
       }else{
           _authStatus.value = AuthState.UnAuthenticated
       }
    }


    fun signUp(email: String,password: String){
        _authStatus.value = AuthState.Loding
        viewModelScope.launch {
            firbase.createUserWithEmailAndPassword(email,password).addOnCompleteListener { res->
                if(res.isSuccessful){
                    _authStatus.value = AuthState.Authenticated(
                        email = email,
                        phoneNumber = null,
                        name = null,
                        profilePicUrl = null
                    )
                }else{
                    _authStatus.value = AuthState.Error(res.exception?.message?:"Something wrong while signup")
                }
            }
        }
    }

    fun logInWithGoogle(context:Context){

        viewModelScope.launch {
            try {
                val loginManager = CredentialManager.create(context = context)
                val request = getCredentialRequest()
                val response = loginManager.getCredential(context = context, request = request )

                val  credential = response.credential
                Log.d("Login",credential.data.toString())

                _authStatus.value = AuthState.Loding

                if(
                    credential is CustomCredential &&
                    credential.type ==  GoogleIdTokenCredential.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL
                ){

                    val googleCredential = GoogleIdTokenCredential.createFrom(credential.data)
                    val res = firbase.signInWithCredential(
                        GoogleAuthProvider.getCredential(googleCredential.idToken,null)
                    ).await()

                    if(res.user == null){
                        _authStatus.value = AuthState.UnAuthenticated
                    }else{
                        _authStatus.value = AuthState.Authenticated(
                            email = res.user?.email,
                            name = res.user?.displayName,
                            profilePicUrl = res.user?.photoUrl.toString(),
                            phoneNumber = res.user?.phoneNumber.toString()
                        )
                    }
                }
            }catch (e:Exception){
                _authStatus.value = AuthState.Error(
                    e.message?:"No user found"
                )
            }
        }
    }

    private fun getCredentialRequest(): GetCredentialRequest {
        val googleIdOption = GetGoogleIdOption.Builder()
            .setFilterByAuthorizedAccounts(false)
            .setServerClientId(webClientId)
            .setAutoSelectEnabled(false)
            .build()

        val request = GetCredentialRequest.Builder()
            .addCredentialOption(googleIdOption)
            .build()

        return request
    }




    fun logOut(){
        _authStatus.value = AuthState.UnAuthenticated
        viewModelScope.launch {
            firbase.signOut()
        }
    }


}
