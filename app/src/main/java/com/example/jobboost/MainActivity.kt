package com.example.jobboost

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.jobboost.notificationSettings.NotificationSettings

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        val employeeButton: Button = findViewById(R.id.employee)
        val studentButton: Button = findViewById(R.id.student)

        employeeButton.setOnClickListener {
            startActivity(Intent(this, EmployeeActivity::class.java))
        }

        studentButton.setOnClickListener {
            startActivity(Intent(this, StudentActivity::class.java))
        }
    }
}




