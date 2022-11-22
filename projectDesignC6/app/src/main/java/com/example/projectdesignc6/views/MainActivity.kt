package com.example.projectdesignc6.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.projectdesignc6.R
import com.example.projectdesignc6.views.AppFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, AppFragment())
        transaction.commit()
    }
}