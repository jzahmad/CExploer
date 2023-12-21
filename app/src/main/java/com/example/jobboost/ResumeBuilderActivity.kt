package com.example.jobboost
import ResumeDBHelper
import android.Manifest.permission.READ_EXTERNAL_STORAGE
import android.Manifest.permission.WRITE_EXTERNAL_STORAGE
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.*
import android.graphics.pdf.PdfDocument
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.jobboost.notificationSettings.NotificationSettings
import java.io.File
import java.io.FileOutputStream
import kotlin.random.Random


/*
    This activity is responsible for the generation of resume
 */
class ResumeBuilderActivity : AppCompatActivity() {

    //The resume db helper, user shared preferences and other permission variables are defined
    private lateinit var resumeHelper: ResumeDBHelper
    private lateinit var studentLoginUsers: StudentLoginUsers
    lateinit var generatePDFBtn: Button
    var emailToSearch = ""
    var save = false;

    var pageHeight = 1000
    var pageWidth = 595

    var PERMISSION_CODE = 101

    //This will initialize the functionality of resume builder activity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resume_builder)

        //Test data in the resume_table is inserted and user email to display in resume is fetched from preferences
        studentLoginUsers = StudentLoginUsers(this)
        resumeHelper = ResumeDBHelper(this)
        resumeHelper.insertTestData()

        generatePDFBtn = findViewById(R.id.buttonGenerate)

        emailToSearch = studentLoginUsers.getEmail().toString()
        val resume = emailToSearch?.let { resumeHelper.getResumeByEmail(it) }
        findViewById<TextView>(R.id.resumeEmail).text = emailToSearch

        //If the resume details are present in the database table then the form fields will be pre-filled
        if (resume != null) {
            // Set the values of EditText fields with the retrieved data
            findViewById<EditText>(R.id.resumeFirstName).setText(resume.firstName)
            findViewById<EditText>(R.id.resumeLastName).setText(resume.lastName)
            findViewById<EditText>(R.id.resumePhoneNumber).setText(resume.phoneNumber)
            findViewById<EditText>(R.id.resumeAddress).setText(resume.address)
            findViewById<EditText>(R.id.resumeJobTitle1).setText(resume.jobTitle1)
            findViewById<EditText>(R.id.resumeJobDescription1).setText(resume.jobDescription1)
            findViewById<EditText>(R.id.resumeJobTitle2).setText(resume.jobTitle2)
            findViewById<EditText>(R.id.resumeJobDescription2).setText(resume.jobDescription2)
            findViewById<EditText>(R.id.resumeJobTitle3).setText(resume.jobTitle3)
            findViewById<EditText>(R.id.resumeJobDescription3).setText(resume.jobDescription3)
            findViewById<EditText>(R.id.resumeProgramName).setText(resume.programName)
            findViewById<EditText>(R.id.resumeProgramLevel).setText(resume.programLevel)
            findViewById<EditText>(R.id.resumePortfolio).setText(resume.portfolioName)
            findViewById<EditText>(R.id.resumeLink).setText(resume.portfolioLink)
        } else {
            save = true;
        }

        //Permissions check if not granted then permission is requested
        if (checkPermissions()) {
            Toast.makeText(this, "Permissions Granted..", Toast.LENGTH_SHORT).show()
        } else {
            requestPermission()
        }

        //Upon clicking generate the pdf for resume will be generated
        generatePDFBtn.setOnClickListener {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
                generatePDF()
            }
        }
    }

    //This function is responsible for the generation of resume according to the template chosen by user
    @RequiresApi(Build.VERSION_CODES.KITKAT)
    fun generatePDF() {

        //Template name fetched from template preferences
        val sharedPreferences = getSharedPreferences("TemplatePreferences", Context.MODE_PRIVATE)
        val template: String = sharedPreferences.getString("selectedTemplate", "") ?: ""

        //Pdf document initialized
        val pdfDocument = PdfDocument()
        val paint = Paint()

        val pageInfo = PdfDocument.PageInfo.Builder(pageWidth, pageHeight, 1).create()
        val page = pdfDocument.startPage(pageInfo)
        val canvas = page.canvas

        //Get all form fields information to display in the pdf
        val firstName = findViewById<EditText>(R.id.resumeFirstName).text.toString()
        val lastName = findViewById<EditText>(R.id.resumeLastName).text.toString()
        val phoneNumber = findViewById<EditText>(R.id.resumePhoneNumber).text.toString()
        val email = emailToSearch
        val address = findViewById<EditText>(R.id.resumeAddress).text.toString()
        val jobTitle1 = findViewById<EditText>(R.id.resumeJobTitle1).text.toString()
        val jobDescription1 = findViewById<EditText>(R.id.resumeJobDescription1).text.toString()
        val jobTitle2 = findViewById<EditText>(R.id.resumeJobTitle2).text.toString()
        val jobDescription2 = findViewById<EditText>(R.id.resumeJobDescription2).text.toString()
        val jobTitle3 = findViewById<EditText>(R.id.resumeJobTitle3).text.toString()
        val jobDescription3 = findViewById<EditText>(R.id.resumeJobDescription3).text.toString()
        val programName = findViewById<EditText>(R.id.resumeProgramName).text.toString()
        val programLevel = findViewById<EditText>(R.id.resumeProgramLevel).text.toString()
        val portfolioName = findViewById<EditText>(R.id.resumePortfolio).text.toString()
        val portfolioLink = findViewById<EditText>(R.id.resumeLink).text.toString()

        //If this is first time for user to fill the form then the form fields will be saved in resume_table to pre-fill form fields next time
        if(save) {
            val resumeModel = ResumeModel(
                firstName,
                lastName,
                phoneNumber,
                email,
                address,
                "",
                jobTitle1,
                jobDescription1,
                jobTitle2,
                jobDescription2,
                jobTitle3,
                jobDescription3,
                programName,
                programLevel,
                portfolioName,
                portfolioLink
            )
            resumeHelper.insertResume(resumeModel)
        }

        //Build each template using canvas api and paint for different templates
        if(template == "Minimalist") {
            val greyPaint = Paint().apply {
                color = Color.GRAY
                strokeWidth = 2F
            }

            val titleTextSize = 30F
            val subTitleTextSize = 20F
            val normalTextSize = 16F

            val boldTypeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
            paint.typeface = boldTypeface

            paint.textSize = titleTextSize
            paint.color = Color.BLACK
            canvas.drawText("$firstName $lastName", 220f, 100f, paint)

            paint.textSize = subTitleTextSize
            canvas.drawText("Personal Information", 100f, 150f, paint)
            canvas.drawLine(100f, 160f, 500f, 160f, greyPaint)

            paint.textSize = normalTextSize
            paint.typeface = Typeface.DEFAULT
            canvas.drawText("Phone: $phoneNumber", 100f, 190f, paint)
            canvas.drawText("Email: $email", 100f, 220f, paint)
            canvas.drawText("Address: $address", 100f, 250f, paint)

            paint.textSize = subTitleTextSize
            paint.typeface = boldTypeface
            canvas.drawText("Work Experience", 100f, 300f, paint)
            canvas.drawLine(100f, 310f, 500f, 310f, greyPaint)

            paint.textSize = normalTextSize
            paint.typeface = Typeface.DEFAULT
            canvas.drawText("Job Title: $jobTitle1", 100f, 340f, paint)
            canvas.drawText("Job Description: $jobDescription1", 100f, 370f, paint)
            canvas.drawText("Job Title: $jobTitle2", 100f, 420f, paint)
            canvas.drawText("Job Description: $jobDescription2", 100f, 450f, paint)
            canvas.drawText("Job Title: $jobTitle3", 100f, 500f, paint)
            canvas.drawText("Job Description: $jobDescription3", 100f, 530f, paint)

            paint.textSize = subTitleTextSize
            paint.typeface = boldTypeface
            canvas.drawText("Highest Education Level", 100f, 580f, paint)
            canvas.drawLine(100f, 590f, 500f, 590f, greyPaint)

            paint.textSize = normalTextSize
            paint.typeface = Typeface.DEFAULT
            canvas.drawText("Program Name: $programName", 100f, 620f, paint)
            canvas.drawText("Job Level: $programLevel", 100f, 650f, paint)

            paint.textSize = subTitleTextSize
            paint.typeface = boldTypeface
            canvas.drawText("Portfolio", 100f, 700f, paint)
            canvas.drawLine(100f, 710f, 500f, 710f, greyPaint)

            paint.textSize = normalTextSize
            paint.typeface = Typeface.DEFAULT
            canvas.drawText("Name: $portfolioName", 100f, 740f, paint)
            canvas.drawText("Link: $portfolioLink", 100f, 770f, paint)

        } else if(template == "Clean") {
            val greenPaint = Paint().apply {
                color = Color.parseColor("#48A4A6")
                strokeWidth = 2F
            }

            val titleColor = Color.parseColor("#48A4A6")
            val textColor = Color.BLACK

            val titleTextSize = 30F
            val subTitleTextSize = 20F
            val normalTextSize = 16F

            val boldTypeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
            paint.typeface = boldTypeface
            paint.color = titleColor

            paint.textSize = titleTextSize
            canvas.drawText("$firstName $lastName", 220f, 100f, paint)

            paint.textSize = subTitleTextSize
            canvas.drawLine(100f, 150f, 500f, 150f, greenPaint)
            canvas.drawText("Personal Information", 200f, 175f, paint)
            canvas.drawLine(100f, 190f, 500f, 190f, greenPaint)

            paint.textSize = normalTextSize
            paint.typeface = Typeface.DEFAULT
            paint.color = textColor
            canvas.drawText("Phone: $phoneNumber", 100f, 220f, paint)
            canvas.drawText("Email: $email", 100f, 250f, paint)
            canvas.drawText("Address: $address", 100f, 280f, paint)

            paint.textSize = subTitleTextSize
            paint.typeface = boldTypeface
            paint.color = titleColor
            canvas.drawLine(100f, 310f, 500f, 310f, greenPaint)
            canvas.drawText("Work Experience", 220f, 335f, paint)
            canvas.drawLine(100f, 350f, 500f, 350f, greenPaint)

            paint.textSize = normalTextSize
            paint.typeface = Typeface.DEFAULT
            paint.color = textColor
            canvas.drawText("Job Title: $jobTitle1", 100f, 380f, paint)
            canvas.drawText("Job Description: $jobDescription1", 100f, 410f, paint)
            canvas.drawText("Job Title: $jobTitle2", 100f, 440f, paint)
            canvas.drawText("Job Description: $jobDescription2", 100f, 470f, paint)
            canvas.drawText("Job Title: $jobTitle3", 100f, 500f, paint)
            canvas.drawText("Job Description: $jobDescription3", 100f, 530f, paint)

            paint.textSize = subTitleTextSize
            paint.typeface = boldTypeface
            paint.color = titleColor
            canvas.drawLine(100f, 560f, 500f, 560f, greenPaint)
            canvas.drawText("Education", 250f, 585f, paint)
            canvas.drawLine(100f, 600f, 500f, 600f, greenPaint)

            paint.textSize = normalTextSize
            paint.typeface = Typeface.DEFAULT
            paint.color = textColor
            canvas.drawText("Program Name: $programName", 100f, 630f, paint)
            canvas.drawText("Job Level: $programLevel", 100f, 660f, paint)

            paint.textSize = subTitleTextSize
            paint.typeface = boldTypeface
            paint.color = titleColor
            canvas.drawLine(100f, 690f, 500f, 690f, greenPaint)
            canvas.drawText("Portfolio", 260f, 715f, paint)
            canvas.drawLine(100f, 730f, 500f, 730f, greenPaint)

            paint.textSize = normalTextSize
            paint.typeface = Typeface.DEFAULT
            paint.color = textColor
            canvas.drawText("Name: $portfolioName", 100f, 760f, paint)
            canvas.drawText("Link: $portfolioLink", 100f, 790f, paint)
        } else if(template=="Executive"){
            val redPaint = Paint().apply {
                color = Color.parseColor("#903B23")
                strokeWidth = 2F
            }

            val titleColor = Color.parseColor("#903B23")
            val textColor = Color.BLACK

            val titleTextSize = 30F
            val subTitleTextSize = 20F
            val normalTextSize = 16F

            val boldTypeface = Typeface.create(Typeface.SERIF, Typeface.BOLD)
            paint.typeface = boldTypeface
            paint.color = titleColor

            paint.textSize = titleTextSize
            canvas.drawText("$firstName $lastName", 220f, 100f, paint)

            paint.textSize = subTitleTextSize
            canvas.drawText("Personal Information", 100f, 175f, paint)
            canvas.drawLine(100f, 190f, 500f, 190f, redPaint)

            paint.textSize = normalTextSize
            paint.typeface = Typeface.SERIF
            paint.color = textColor
            canvas.drawText("Phone: $phoneNumber", 100f, 220f, paint)
            canvas.drawText("Email: $email", 100f, 250f, paint)
            canvas.drawText("Address: $address", 100f, 280f, paint)

            paint.textSize = subTitleTextSize
            paint.typeface = boldTypeface
            paint.color = titleColor
            canvas.drawText("Work Experience", 100f, 335f, paint)
            canvas.drawLine(100f, 350f, 500f, 350f, redPaint)

            paint.textSize = normalTextSize
            paint.typeface = Typeface.SERIF
            paint.color = textColor
            canvas.drawText("Job Title: $jobTitle1", 100f, 380f, paint)
            canvas.drawText("Job Description: $jobDescription1", 100f, 410f, paint)
            canvas.drawText("Job Title: $jobTitle2", 100f, 440f, paint)
            canvas.drawText("Job Description: $jobDescription2", 100f, 470f, paint)
            canvas.drawText("Job Title: $jobTitle3", 100f, 500f, paint)
            canvas.drawText("Job Description: $jobDescription3", 100f, 530f, paint)

            paint.textSize = subTitleTextSize
            paint.typeface = boldTypeface
            paint.color = titleColor
            canvas.drawText("Education", 100f, 585f, paint)
            canvas.drawLine(100f, 600f, 500f, 600f, redPaint)

            paint.textSize = normalTextSize
            paint.typeface = Typeface.SERIF
            paint.color = textColor
            canvas.drawText("Program Name: $programName", 100f, 630f, paint)
            canvas.drawText("Job Level: $programLevel", 100f, 660f, paint)

            paint.textSize = subTitleTextSize
            paint.typeface = boldTypeface
            paint.color = titleColor
            canvas.drawText("Portfolio", 100f, 715f, paint)
            canvas.drawLine(100f, 730f, 500f, 730f, redPaint)

            paint.textSize = normalTextSize
            paint.typeface = Typeface.SERIF
            paint.color = textColor
            canvas.drawText("Name: $portfolioName", 100f, 760f, paint)
            canvas.drawText("Link: $portfolioLink", 100f, 790f, paint)
        }

        pdfDocument.finishPage(page)

        //Once document designing is complete the document is saved in the downloads folder of the phone
        val downloadsDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)

        //File name created using random number
        val fileName = "Resume"+Random.nextInt(1,100)+".pdf"

        val file = File(downloadsDir, fileName)

        //File saved if no error otherwise a error notification will be generated
        try {
            pdfDocument.writeTo(FileOutputStream(file))
            Toast.makeText(applicationContext, "PDF file generated in Downloads folder", Toast.LENGTH_SHORT).show()
        } catch (e: Exception) {
            e.printStackTrace()
            Toast.makeText(applicationContext, "Fail to generate PDF file..", Toast.LENGTH_SHORT).show()
        } finally {
            pdfDocument.close()
        }
    }

    //This function checks if the device is given appropriate permissions to generate and save pdf in downloads folder
    fun checkPermissions(): Boolean {

        var writeStoragePermission = ContextCompat.checkSelfPermission(
            applicationContext,
            WRITE_EXTERNAL_STORAGE
        )

        var readStoragePermission = ContextCompat.checkSelfPermission(
            applicationContext,
            READ_EXTERNAL_STORAGE
        )

        return writeStoragePermission == PackageManager.PERMISSION_GRANTED
                && readStoragePermission == PackageManager.PERMISSION_GRANTED
    }

    //This function initiates the pop to request permissions from user
    fun requestPermission() {

        ActivityCompat.requestPermissions(
            this,
            arrayOf(READ_EXTERNAL_STORAGE, WRITE_EXTERNAL_STORAGE), PERMISSION_CODE
        )
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)


        if (requestCode == PERMISSION_CODE) {

            if (grantResults.size > 0) {

                if (grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1]
                    == PackageManager.PERMISSION_GRANTED) {

                    Toast.makeText(this, "Permission Granted..", Toast.LENGTH_SHORT).show()

                } else {
                    Toast.makeText(this, "Permission Denied..", Toast.LENGTH_SHORT).show()
                    finish()
                }
            }
        }
    }

    //This is to create the navigation menu
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