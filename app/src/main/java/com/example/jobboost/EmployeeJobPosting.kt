package com.example.jobboost

import android.annotation.SuppressLint
import android.content.ContentValues
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity

class EmployeeJobPosting : ComponentActivity() {
    @SuppressLint("WrongViewCast", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee_jobs_posting)

        val jobDatabaseHelper = JobPostingHelper(this)

        val postJobButton = findViewById<Button>(R.id.postJob)
        postJobButton.setOnClickListener {
            // Retrieve values from EditText views
            val companyName = findViewById<EditText>(R.id.postCom).text.toString()
            val companyDescription = findViewById<EditText>(R.id.postComDesc).text.toString()
            val jobLocation = findViewById<EditText>(R.id.postComLoc).text.toString()
            val jobField = findViewById<EditText>(R.id.postJobField).text.toString()
            val jobTitle = findViewById<EditText>(R.id.postJobTitle).text.toString()
            val jobDuration = findViewById<EditText>(R.id.postJobDur).text.toString()
            val jobHours = findViewById<EditText>(R.id.postJobHours).text.toString()
            val rolesResponsibilities = findViewById<EditText>(R.id.postJobRR).text.toString()
            val qualifications = findViewById<EditText>(R.id.postJobQua).text.toString()
            val hourlyPay = findViewById<EditText>(R.id.postJobPay).text.toString()
            val applicationDeadline = findViewById<EditText>(R.id.postJobD).text.toString()
            val requiredDocuments = findViewById<EditText>(R.id.postRD).text.toString()
            val submissionInstructions = findViewById<EditText>(R.id.postSI).text.toString()
            val employerContactInfo = findViewById<EditText>(R.id.postComCon).text.toString()

            // Check if any required field is empty
            if (companyName.isEmpty() || companyDescription.isEmpty() || jobLocation.isEmpty() ||
                jobField.isEmpty() || jobTitle.isEmpty() || jobDuration.isEmpty() || jobHours.isEmpty() ||
                rolesResponsibilities.isEmpty() || qualifications.isEmpty() || hourlyPay.isEmpty() ||
                applicationDeadline.isEmpty() || requiredDocuments.isEmpty() || submissionInstructions.isEmpty() ||
                employerContactInfo.isEmpty()
            ) {
                // Display a Toast message asking the user to fill in all details
                Toast.makeText(this, "Please fill in all details", Toast.LENGTH_SHORT).show()
            } else {
                val db = jobDatabaseHelper.writableDatabase
                val values = ContentValues().apply {
                    put(JobPostingHelper.COLUMN_COMPANY_NAME, companyName)
                    put(JobPostingHelper.COLUMN_COMPANY_DESCRIPTION, companyDescription)
                    put(JobPostingHelper.COLUMN_COMPANY_LOCATION, jobLocation)
                    put(JobPostingHelper.COLUMN_JOB_FIELD, jobField)
                    put(JobPostingHelper.COLUMN_JOB_TITLE, jobTitle)
                    put(JobPostingHelper.COLUMN_JOB_DURATION, jobDuration)
                    put(JobPostingHelper.COLUMN_JOB_HOURS, jobHours)
                    put(JobPostingHelper.COLUMN_ROLES_RESPONSIBILITIES, rolesResponsibilities)
                    put(JobPostingHelper.COLUMN_QUALIFICATIONS, qualifications)
                    put(JobPostingHelper.COLUMN_HOURLY_PAY, hourlyPay)
                    put(JobPostingHelper.COLUMN_APPLICATION_DEADLINE, applicationDeadline)
                    put(JobPostingHelper.COLUMN_REQUIRED_DOCUMENTS, requiredDocuments)
                    put(JobPostingHelper.COLUMN_SUBMISSION_INSTRUCTIONS, submissionInstructions)
                    put(JobPostingHelper.COLUMN_EMPLOYER_CONTACT_INFO, employerContactInfo)
                }
                db.insert(JobPostingHelper.TABLE_NAME, null, values)
                Toast.makeText(this, "Job Posted by $companyName", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
