package com.example.projectdesignc6.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.projectdesignc6.model.UserModel
import com.example.projectdesignc6.repository.UserRepository

class AppViewModel(application: Application): AndroidViewModel(application) {

    private val repository = UserRepository.getInstance(application)

    private val balance = MutableLiveData<String>()
    val textBalance: LiveData<String> = balance

}