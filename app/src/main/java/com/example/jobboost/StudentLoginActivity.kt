package com.example.jobboost

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class StudentLoginActivity : AppCompatActivity() {

    private lateinit var signupHelper: SignupDBHelper
    private lateinit var loginUsers: StudentLoginUsers
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_login)

        val email: EditText = findViewById(R.id.email)
        val password: EditText = findViewById(R.id.password)
        val loginButton: Button = findViewById(R.id.login)

        signupHelper = SignupDBHelper(this)
        loginUsers = StudentLoginUsers(this)

        loginButton.setOnClickListener {
            val email = email.text.toString()
            val password = password.text.toString()

            val checkLogin = signupHelper.checkLoginCredentials(email, password)


            if (checkLogin) {
                // Login successful
                Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show()

                // Save the email to SharedPreferences
                loginUsers.saveEmail(email)

                //Redirect to the profile creation activity
                val intent = Intent(this, StudentProfileActivity::class.java)
                startActivity(intent)

            } else {
                // Login failed
                Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
