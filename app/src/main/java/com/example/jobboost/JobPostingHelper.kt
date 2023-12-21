package com.example.jobboost

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class JobPostingHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        const val DATABASE_NAME = "Jobs.db"
        const val DATABASE_VERSION = 1
        const val TABLE_NAME = "Jobs"
        const val COLUMN_COMPANY_NAME = "comp_name"
        const val COLUMN_COMPANY_DESCRIPTION = "comp_desc"
        const val COLUMN_COMPANY_LOCATION = "comp_loc"
        const val COLUMN_JOB_FIELD = "job_field"
        const val COLUMN_JOB_TITLE = "job_title"
        const val COLUMN_JOB_DURATION = "job_duration"
        const val COLUMN_JOB_HOURS = "job_hours"
        const val COLUMN_ROLES_RESPONSIBILITIES = "job_rr"
        const val COLUMN_QUALIFICATIONS = "job_qualify"
        const val COLUMN_HOURLY_PAY = "job_pay"
        const val COLUMN_APPLICATION_DEADLINE = "app_doc"
        const val COLUMN_REQUIRED_DOCUMENTS="app_document"
        const val COLUMN_SUBMISSION_INSTRUCTIONS = "sub_instr"
        const val COLUMN_EMPLOYER_CONTACT_INFO = "comp_cont"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTableQuery = """
            CREATE TABLE $TABLE_NAME (
                $COLUMN_COMPANY_NAME TEXT,
                $COLUMN_COMPANY_DESCRIPTION TEXT,
                $COLUMN_COMPANY_LOCATION TEXT,
                $COLUMN_JOB_FIELD TEXT,
                $COLUMN_JOB_TITLE TEXT,
                $COLUMN_JOB_DURATION TEXT,
                $COLUMN_JOB_HOURS TEXT,
                $COLUMN_ROLES_RESPONSIBILITIES TEXT,
                $COLUMN_QUALIFICATIONS TEXT,
                $COLUMN_HOURLY_PAY TEXT,
                $COLUMN_APPLICATION_DEADLINE TEXT,
                $COLUMN_REQUIRED_DOCUMENTS TEXT,
                $COLUMN_SUBMISSION_INSTRUCTIONS TEXT,
                $COLUMN_EMPLOYER_CONTACT_INFO TEXT
            )
        """.trimIndent()
        db?.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
}
