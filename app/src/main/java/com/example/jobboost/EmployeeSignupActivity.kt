package com.example.jobboost

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class EmployeeSignupActivity : AppCompatActivity() {
    private lateinit var signupHelper: SignupDBHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eployee_signup)

        val passwordEditText: EditText = findViewById(R.id.password)
        val NameEditText: EditText = findViewById(R.id.Name)
        val emailEditText: EditText = findViewById(R.id.emailAddress)
        val signupButton: Button = findViewById(R.id.Resume)
        signupHelper = SignupDBHelper(this)

        signupButton.setOnClickListener {
            val password = passwordEditText.text.toString()
            val name = NameEditText.text.toString()
            val email = emailEditText.text.toString()

            val checkEmail = signupHelper.isEmailExists(email)

            if (name.isEmpty() || email.isEmpty() || password.isEmpty() ) {
                Toast.makeText(this, "please fill all the information", Toast.LENGTH_SHORT).show()
            }
            //check email returns true if the email already has been used
            else if(!checkEmail){
                val signupModel = SignupModel (name, email, password)
                val status = signupHelper.insertSignup(signupModel)

                //check if the information was stored in the database
                if(status > -1) {
                    Toast.makeText(this, "Signup successful!", Toast.LENGTH_LONG).show()
                   val intent = Intent(this, EmployeeJobPosting::class.java)
                    startActivity(intent)
                }
                else{
                    Toast.makeText(this,"information not stored", Toast.LENGTH_SHORT).show()
                }
            }
            else {
                Toast.makeText(this,"Email already used please try a different email", Toast.LENGTH_SHORT).show()
            }
        }
    }
}