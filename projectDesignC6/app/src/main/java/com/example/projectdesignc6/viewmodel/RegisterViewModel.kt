package com.example.projectdesignc6.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.projectdesignc6.model.UserModel
import com.example.projectdesignc6.repository.UserRepository

class RegisterViewModel(application: Application) : AndroidViewModel(application){
    private val repository = UserRepository.getInstance(application.applicationContext)

    fun registerUser(user: UserModel) {
        repository.insert(user)
    }
}