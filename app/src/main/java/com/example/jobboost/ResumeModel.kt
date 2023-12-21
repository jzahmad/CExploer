package com.example.jobboost

//This class defines the resume model object to be inserted into the resume_table
data class ResumeModel(
    var firstName: String,
    var lastName: String,
    var phoneNumber: String,
    var email: String,
    var address: String,
    var description: String,
    var jobTitle1: String,
    var jobDescription1: String,
    var jobTitle2: String,
    var jobDescription2: String,
    var jobTitle3: String,
    var jobDescription3: String,
    var programName: String,
    var programLevel: String,
    var portfolioName: String,
    var portfolioLink: String
)
