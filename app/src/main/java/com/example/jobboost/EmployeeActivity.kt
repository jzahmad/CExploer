package com.example.jobboost

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class EmployeeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee)

        val loginButton: Button = findViewById(R.id.login)
        val signupButton: Button = findViewById(R.id.Resume)

        loginButton.setOnClickListener {
            startActivity(Intent(this, EmployeeLoginActivity::class.java))
        }

        signupButton.setOnClickListener {
            startActivity(Intent(this, EmployeeSignupActivity::class.java))
        }
    }
}