package com.example.reddit_clone.features.auth.utils

fun validatePass(pass: String): Boolean {
    val passwordPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#\\$%^&*(),.?\":{}|<>])[A-Za-z\\d!@#\\$%^&*(),.?\":{}|<>]{8,}\$"
    return pass.matches(Regex(passwordPattern))
}

fun validateEmail(email: String): Boolean {
    val emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"
    return  email.matches(Regex(emailPattern))
}


