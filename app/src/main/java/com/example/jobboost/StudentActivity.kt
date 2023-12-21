package com.example.jobboost

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class StudentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student)

        val loginButton: Button = findViewById(R.id.login)
        val signupButton: Button = findViewById(R.id.signup)

        loginButton.setOnClickListener {
            startActivity(Intent(this, StudentLoginActivity::class.java))
        }

        signupButton.setOnClickListener {
            startActivity(Intent(this, StudentSignupActivity::class.java))
        }
    }
}