package com.example.projectdesignc6.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.projectdesignc6.repository.UserRepository

class LoginViewModel(application: Application): AndroidViewModel(application) {
    private val repository = UserRepository.getInstance(application.applicationContext)

    fun loginUser(email: String, password: String) {
        repository.login(email, password)
    }
}