package com.example.jobboost

data class StudentJobPosting(
    val companyName: String,
    val companyDescription: String,
    val jobLocation: String,
    val jobField: String,
    val jobTitle: String,
    val jobDuration: String,
    val jobHours: String,
    val rolesResponsibilities: String,
    val qualifications: String,
    val hourlyPay: Double,
    val applicationDeadline: String,
    val requiredDocuments: String,
    val submissionInstructions: String,
    val employerContactInfo: String
)
