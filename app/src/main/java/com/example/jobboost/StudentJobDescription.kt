package com.example.jobboost

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.jobboost.notificationSettings.NotificationSettings


@SuppressLint("RestrictedApi")
class StudentJobDescription : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_job_description)

        // Retrieve data from Intent
        val companyName = intent.getStringExtra("companyName")
        val companyDescription = intent.getStringExtra("companyDescription")
        val jobLocation = intent.getStringExtra("jobLocation")
        val jobField = intent.getStringExtra("jobField")
        val jobTitle = intent.getStringExtra("jobTitle")
        val jobDuration = intent.getStringExtra("jobDuration")
        val jobHours = intent.getStringExtra("jobHours")
        val rolesResponsibilities = intent.getStringExtra("rolesResponsibilities")
        val qualifications = intent.getStringExtra("qualifications")
        val hourlyPay = intent.getDoubleExtra("hourlyPay", 0.0)
        val applicationDeadline = intent.getStringExtra("applicationDeadline")
        val requiredDocuments = intent.getStringExtra("requiredDocuments")
        val submissionInstructions = intent.getStringExtra("submissionInstructions")
        val employerContactInfo = intent.getStringExtra("employerContactInfo")

        // Set the text of TextView elements with the retrieved data
        findViewById<TextView>(R.id.ComName).text = companyName
        findViewById<TextView>(R.id.ComDesc).text = companyDescription
        findViewById<TextView>(R.id.ComLoc).text = jobLocation
        findViewById<TextView>(R.id.ComFie).text = jobField
        findViewById<TextView>(R.id.JobTit).text = jobTitle
        findViewById<TextView>(R.id.JobDur).text = jobDuration
        findViewById<TextView>(R.id.JobHour).text = jobHours
        findViewById<TextView>(R.id.JobRR).text = rolesResponsibilities
        findViewById<TextView>(R.id.JobQua).text = qualifications
        findViewById<TextView>(R.id.JobPay).text = "$$hourlyPay" // Formatting as currency
        findViewById<TextView>(R.id.JobDL).text = applicationDeadline
        findViewById<TextView>(R.id.JobRD).text = requiredDocuments
        findViewById<TextView>(R.id.JobSI).text = submissionInstructions
        findViewById<TextView>(R.id.ComCon).text = employerContactInfo

        val button = findViewById<Button>(R.id.applyJobButton)

        button.setOnClickListener {
            applyToJob(it)
        }
    }

    fun applyToJob(view: View) {
        var i = Intent(this, ApplyJobActivity::class.java)
        startActivity(i)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.nav_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //Menu options created
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.Resume -> {
                var i = Intent(this, Template_Main::class.java);
                startActivity(i);
                true
            }
            R.id.profile -> {
                var i = Intent(this, StudentProfileActivity::class.java);
                startActivity(i);
                true
            }
            R.id.chatgpt -> {
                var i = Intent(this, ChatbotActivity::class.java);
                startActivity(i);
                true
            }
            R.id.logout -> {
                var i = Intent(this, MainActivity::class.java);
                startActivity(i);
                true
            }
            R.id.searchFilter-> {
                var i = Intent(this, SearchFilterActivity::class.java);
                startActivity(i);
                true
            }
            R.id.posting-> {
                var i = Intent(this, StudentJobsActivity::class.java);
                startActivity(i);
                true
            }
            R.id.Review-> {
                var i = Intent(this, ReviewMain::class.java);
                startActivity(i);
                true
            }
            R.id.Settings-> {
                var intent = Intent(applicationContext, NotificationSettings::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
