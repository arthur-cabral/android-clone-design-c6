package com.example.projectdesignc6.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.projectdesignc6.R

class RegisterFormActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_form)

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container_register_form_activity, LoginFragment())
        transaction.commit()
    }
}