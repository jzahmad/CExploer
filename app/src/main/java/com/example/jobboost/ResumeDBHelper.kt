import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.jobboost.ResumeModel
import com.example.jobboost.SignupDBHelper

/*
    This file is responsible for handling the database queries for resume_table in database
 */
class ResumeDBHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_VERSION = 2
        private const val DATABASE_NAME = "signup.db"
        private const val Resume_Table = "resume_table"
        private const val FIRSTNAME = "fname"
        private const val LASTNAME = "lname"
        private const val PHONENUMBER = "phone_number"
        private const val EMAIL = "email"
        private const val ADDRESS = "address"
        private const val DESCRIPTION = "description"
        private const val JOBTITLE1 = "job_title_1"
        private const val JOBDESCRIPTION1 = "job_description_1"
        private const val JOBTITLE2 = "job_title_2"
        private const val JOBDESCRIPTION2 = "job_description_2"
        private const val JOBTITLE3 = "job_title_3"
        private const val JOBDESCRIPTION3 = "job_description_3"
        private const val PROGRAMNAME = "program_name"
        private const val PROGRAMLEVEL = "program_level"
        private const val PORTFOLIONAME = "portfolio_name"
        private const val PORTFOLIOLINK = "portfolio_link"
    }
    override fun onCreate(db: SQLiteDatabase?) {
        // Create the resume table
        val resumeTable = ("CREATE TABLE $Resume_Table ("
                // Add columns for the resume table as needed
                +"$FIRSTNAME TEXT, "
                +"$LASTNAME TEXT, "
                +"$PHONENUMBER TEXT, "
                +"$EMAIL TEXT, "
                +"$ADDRESS TEXT, "
                +"$DESCRIPTION TEXT, "
                +"$JOBTITLE1 TEXT, "
                +"$JOBDESCRIPTION1 TEXT, "
                +"$JOBTITLE2 TEXT, "
                +"$JOBDESCRIPTION2 TEXT, "
                +"$JOBTITLE3 TEXT, "
                +"$JOBDESCRIPTION3 TEXT, "
                +"$PROGRAMNAME TEXT, "
                +"$PROGRAMLEVEL TEXT, "
                +"$PORTFOLIONAME TEXT, "
                + "$PORTFOLIOLINK TEXT)")
        db?.execSQL(resumeTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        // Drop the existing resume table
        db!!.execSQL("DROP TABLE IF EXISTS $Resume_Table")

        // Recreate the resume table
        onCreate(db)
    }

    //Insert resume in the resume_table
    fun insertResume(resumeModel: ResumeModel): Long {
        val resumeDatabase = this.writableDatabase
        val contentValues = ContentValues().apply {
            put(FIRSTNAME, resumeModel.firstName)
            put(LASTNAME, resumeModel.lastName)
            put(PHONENUMBER, resumeModel.phoneNumber)
            put(EMAIL, resumeModel.email)
            put(ADDRESS, resumeModel.address)
            put(DESCRIPTION, resumeModel.description)
            put(JOBTITLE1, resumeModel.jobTitle1)
            put(JOBDESCRIPTION1, resumeModel.jobDescription1)
            put(JOBTITLE2, resumeModel.jobTitle2)
            put(JOBDESCRIPTION2, resumeModel.jobDescription2)
            put(JOBTITLE3, resumeModel.jobTitle3)
            put(JOBDESCRIPTION3, resumeModel.jobDescription3)
            put(PROGRAMNAME, resumeModel.programName)
            put(PROGRAMLEVEL, resumeModel.programLevel)
            put(PORTFOLIONAME, resumeModel.portfolioName)
            put(PORTFOLIOLINK, resumeModel.portfolioLink)
        }

        val insertedResume = resumeDatabase.insert(Resume_Table, null, contentValues)
        resumeDatabase.close()
        return insertedResume
    }

    //Get resume by email if resume saved in the table
    fun getResumeByEmail(email: String): ResumeModel? {
        val db = readableDatabase
        val columns = arrayOf(
            FIRSTNAME, LASTNAME, PHONENUMBER, EMAIL, ADDRESS,
            DESCRIPTION, JOBTITLE1, JOBDESCRIPTION1, JOBTITLE2,
            JOBDESCRIPTION2, JOBTITLE3, JOBDESCRIPTION3, PROGRAMNAME,
            PROGRAMLEVEL, PORTFOLIONAME, PORTFOLIOLINK
        )
        val selection = "$EMAIL = ?"
        val selectionArgs = arrayOf(email)

        val cursor: Cursor = db.query(Resume_Table, columns, selection, selectionArgs, null, null, null)

        val resume: ResumeModel? = if (cursor.moveToFirst()) {
            val firstNameIndex = cursor.getColumnIndex(FIRSTNAME)
            val lastNameIndex = cursor.getColumnIndex(LASTNAME)
            val phoneNumberIndex = cursor.getColumnIndex(PHONENUMBER)
            val emailIndex = cursor.getColumnIndex(EMAIL)
            val addressIndex = cursor.getColumnIndex(ADDRESS)
            val descriptionIndex = cursor.getColumnIndex(DESCRIPTION)
            val jobTitle1Index = cursor.getColumnIndex(JOBTITLE1)
            val jobDescription1Index = cursor.getColumnIndex(JOBDESCRIPTION1)
            val jobTitle2Index = cursor.getColumnIndex(JOBTITLE2)
            val jobDescription2Index = cursor.getColumnIndex(JOBDESCRIPTION2)
            val jobTitle3Index = cursor.getColumnIndex(JOBTITLE3)
            val jobDescription3Index = cursor.getColumnIndex(JOBDESCRIPTION3)
            val programNameIndex = cursor.getColumnIndex(PROGRAMNAME)
            val programLevelIndex = cursor.getColumnIndex(PROGRAMLEVEL)
            val portfolioNameIndex = cursor.getColumnIndex(PORTFOLIONAME)
            val portfolioLinkIndex = cursor.getColumnIndex(PORTFOLIOLINK)

            if (
                firstNameIndex >= 0 && lastNameIndex >= 0 && phoneNumberIndex >= 0 && emailIndex >= 0 &&
                addressIndex >= 0 && descriptionIndex >= 0 && jobTitle1Index >= 0 && jobDescription1Index >= 0 &&
                jobTitle2Index >= 0 && jobDescription2Index >= 0 && jobTitle3Index >= 0 && jobDescription3Index >= 0 &&
                programNameIndex >= 0 && programLevelIndex >= 0 && portfolioNameIndex >= 0 && portfolioLinkIndex >= 0
            ) {
                ResumeModel(
                    cursor.getString(firstNameIndex),
                    cursor.getString(lastNameIndex),
                    cursor.getString(phoneNumberIndex),
                    cursor.getString(emailIndex),
                    cursor.getString(addressIndex),
                    cursor.getString(descriptionIndex),
                    cursor.getString(jobTitle1Index),
                    cursor.getString(jobDescription1Index),
                    cursor.getString(jobTitle2Index),
                    cursor.getString(jobDescription2Index),
                    cursor.getString(jobTitle3Index),
                    cursor.getString(jobDescription3Index),
                    cursor.getString(programNameIndex),
                    cursor.getString(programLevelIndex),
                    cursor.getString(portfolioNameIndex),
                    cursor.getString(portfolioLinkIndex)
                )
            } else {
                null
            }
        } else {
            null
        }

        cursor.close()
        db.close()

        return resume
    }


    //Insert test data for testing purposes
    fun insertTestData() {
        val db = writableDatabase

        val values = ContentValues()
        values.put(FIRSTNAME, "John")
        values.put(LASTNAME, "Doe")
        values.put(PHONENUMBER, "123456789")
        values.put(EMAIL, "john.doe@example.com")
        values.put(ADDRESS, "123 Main St")
        values.put(DESCRIPTION, "Description")
        values.put(JOBTITLE1, "Job Title 1")
        values.put(JOBDESCRIPTION1, "Job Description 1")
        values.put(JOBTITLE2, "Job Title 2")
        values.put(JOBDESCRIPTION2, "Job Description 2")
        values.put(JOBTITLE3, "Job Title 3")
        values.put(JOBDESCRIPTION3, "Job Description 3")
        values.put(PROGRAMNAME, "Program Name")
        values.put(PROGRAMLEVEL, "Program Level")
        values.put(PORTFOLIONAME, "Portfolio Name")
        values.put(PORTFOLIOLINK, "Portfolio Link")

        db.insert(Resume_Table, null, values)
        db.close()
    }
}