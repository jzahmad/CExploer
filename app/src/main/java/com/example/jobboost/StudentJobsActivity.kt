package com.example.jobboost

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jobboost.notificationSettings.NotificationSettings

class StudentJobsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_job_posting)

        val studentJobPosting1 = StudentJobPosting(
            companyName = "Tech Innovators Inc.",
            companyDescription = "A leading technology company specializing in innovative solutions.",
            jobLocation = "San Francisco, CA",
            jobField = "Software Development",
            jobTitle = "Senior Software Engineer",
            jobDuration = "Full-Time",
            jobHours = "40 hours per week",
            rolesResponsibilities = "Develop and maintain high-quality software applications.",
            qualifications = "Bachelor's degree in Computer Science, 5+ years of experience.",
            hourlyPay = 60.0,
            applicationDeadline = "2023-12-01",
            requiredDocuments = "Resume, Cover Letter, Portfolio",
            submissionInstructions = "Submit your application via email to hr@techinnovators.com.",
            employerContactInfo = "HR Department, Tech Innovators Inc."
        )

        val studentJobPosting2 = StudentJobPosting(
            companyName = "GreenTech Solutions",
            companyDescription = "A sustainable technology company committed to environmental conservation.",
            jobLocation = "Seattle, WA",
            jobField = "Environmental Engineering",
            jobTitle = "Environmental Scientist",
            jobDuration = "Part-Time",
            jobHours = "20 hours per week",
            rolesResponsibilities = "Conduct environmental impact assessments, analyze data, and provide recommendations.",
            qualifications = "Master's degree in Environmental Science, 2+ years of relevant experience.",
            hourlyPay = 35.0,
            applicationDeadline = "2023-12-15",
            requiredDocuments = "Resume, Academic Transcripts, References",
            submissionInstructions = "Apply through our online portal at greentechsolutions.com/careers.",
            employerContactInfo = "Recruitment Team, GreenTech Solutions"
        )

        val jobsList= listOf(studentJobPosting1,
            studentJobPosting2)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val adapter = StudentJobsAdapter(jobsList)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter.onItemClick = {clickedJobPosting ->
            val intent = Intent(this, StudentJobDescription::class.java)

            intent.putExtra("companyName", clickedJobPosting.companyName)
            intent.putExtra("companyDescription", clickedJobPosting.companyDescription)
            intent.putExtra("companyName", clickedJobPosting.companyName)
            intent.putExtra("companyDescription", clickedJobPosting.companyDescription)
            intent.putExtra("jobLocation", clickedJobPosting.jobLocation)
            intent.putExtra("jobField", clickedJobPosting.jobField)
            intent.putExtra("jobTitle", clickedJobPosting.jobTitle)
            intent.putExtra("jobDuration", clickedJobPosting.jobDuration)
            intent.putExtra("jobHours", clickedJobPosting.jobHours)
            intent.putExtra("rolesResponsibilities", clickedJobPosting.rolesResponsibilities)
            intent.putExtra("qualifications", clickedJobPosting.qualifications)
            intent.putExtra("hourlyPay", clickedJobPosting.hourlyPay)
            intent.putExtra("applicationDeadline", clickedJobPosting.applicationDeadline)
            intent.putExtra("requiredDocuments", clickedJobPosting.requiredDocuments)
            intent.putExtra("submissionInstructions", clickedJobPosting.submissionInstructions)
            intent.putExtra("employerContactInfo", clickedJobPosting.employerContactInfo)

            startActivity(intent)
        }
        recyclerView.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.nav_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //Menu options created
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Log.d("MenuClick", "Item ID: ${item.itemId}")
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
