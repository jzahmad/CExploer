package com.example.jobboost

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.cardview.widget.CardView
import androidx.drawerlayout.widget.DrawerLayout
import com.example.jobboost.notificationSettings.NotificationSettings
import com.google.android.material.navigation.NavigationView
import de.hdodenhof.circleimageview.CircleImageView

class StudentProfileActivity : AppCompatActivity() {

    /**
     * This method initializes the application's StudentProfileActivity page when it is
     * being loaded by the application.
     */
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_profile)

        /*Get this activity's profile picture CircleImageView.*/
        var profilePictureImageView: CircleImageView = findViewById(R.id.profilePictureImageView)

        /*Get the URI of the image selected by the user from their device's photo library to be
        their profile picture while completing the Profile Creation Form, and if it is not null,
        display that selected image in this activity's profile picture CircleImageView.*/
        var uriOfSelectedImage = intent.getStringExtra("uriOfSelectedImage")

        if (uriOfSelectedImage != null) {
            profilePictureImageView.setImageURI(Uri.parse(uriOfSelectedImage))
        }

        /*Use SharedPreferences to populate this activity's UI with all the information inputted by
        the user while they were filling the profile creation form (i.e.,
        ProfileCreationFormActivity).*/
        var studentSharedPreferences = getSharedPreferences("Student's Preferences", MODE_PRIVATE)

        /*Get all the updatable TextViews in this activity's UI and populate them with the
        corresponding information inputted by the user while they were filling the profile creation
        form (i.e., ProfileCreationFormActivity)*/
        var profileName: TextView = findViewById(R.id.profileName)
        profileName.text = studentSharedPreferences.getString("nameField", "")

        var profilePronouns: TextView = findViewById(R.id.profilePronouns)
        profilePronouns.text = studentSharedPreferences.getString("pronounsField", "")

        var profileBio: TextView = findViewById(R.id.profileBio)
        profileBio.text = studentSharedPreferences.getString("bioField", "")

        var yearOfStudy: TextView = findViewById(R.id.yearOfStudy)
        yearOfStudy.text = studentSharedPreferences.getString("yearOfStudySpinner", "")

        var programOfStudy: TextView = findViewById(R.id.programOfStudy)
        programOfStudy.text = studentSharedPreferences.getString("programSpinner", "")

        var phoneNumber: TextView = findViewById(R.id.phoneNumber)
        phoneNumber.text = studentSharedPreferences.getString("phoneNumberField", "")

        var email: TextView = findViewById(R.id.email)
        email.text = studentSharedPreferences.getString("emailField", "")

        var academicProjectName1: TextView = findViewById(R.id.academicProjectName1)
        academicProjectName1.text = studentSharedPreferences.getString("projectNameField1", "")

        var academicProjectCourse1: TextView = findViewById(R.id.academicProjectCourse1)
        academicProjectCourse1.text = studentSharedPreferences.getString("projectCourseField1", "")

        var academicProjectDescription1: TextView = findViewById(R.id.academicProjectDescription1)
        academicProjectDescription1.text =
            studentSharedPreferences.getString("projectDescriptionField1", "")

        var academicProject1DataNotInputted: Boolean = academicProjectName1.text.isNullOrBlank()
                || academicProjectCourse1.text.isNullOrBlank()
                || academicProjectDescription1.text.isNullOrBlank()

        var academicProjectName2: TextView = findViewById(R.id.academicProjectName2)
        academicProjectName2.text = studentSharedPreferences.getString("projectNameField2", "")

        var academicProjectCourse2: TextView = findViewById(R.id.academicProjectCourse2)
        academicProjectCourse2.text = studentSharedPreferences.getString("projectCourseField2", "")

        var academicProjectDescription2: TextView = findViewById(R.id.academicProjectDescription2)
        academicProjectDescription2.text =
            studentSharedPreferences.getString("projectDescriptionField2", "")

        var academicProject2DataNotInputted: Boolean = academicProjectName2.text.isNullOrBlank()
                || academicProjectCourse2.text.isNullOrBlank()
                || academicProjectDescription2.text.isNullOrBlank()

        var academicProjectName3: TextView = findViewById(R.id.academicProjectName3)
        academicProjectName3.text = studentSharedPreferences.getString("projectNameField3", "")

        var academicProjectCourse3: TextView = findViewById(R.id.academicProjectCourse3)
        academicProjectCourse3.text = studentSharedPreferences.getString("projectCourseField3", "")

        var academicProjectDescription3: TextView = findViewById(R.id.academicProjectDescription3)
        academicProjectDescription3.text =
            studentSharedPreferences.getString("projectDescriptionField3", "")

        var academicProject3DataNotInputted: Boolean = academicProjectName3.text.isNullOrBlank()
                || academicProjectCourse3.text.isNullOrBlank()
                || academicProjectDescription3.text.isNullOrBlank()

        var academicProjectName4: TextView = findViewById(R.id.academicProjectName4)
        academicProjectName4.text = studentSharedPreferences.getString("projectNameField4", "")

        var academicProjectCourse4: TextView = findViewById(R.id.academicProjectCourse4)
        academicProjectCourse4.text = studentSharedPreferences.getString("projectCourseField4", "")

        var academicProjectDescription4: TextView = findViewById(R.id.academicProjectDescription4)
        academicProjectDescription4.text =
            studentSharedPreferences.getString("projectDescriptionField4", "")

        var academicProject4DataNotInputted: Boolean = academicProjectName4.text.isNullOrBlank()
                || academicProjectCourse4.text.isNullOrBlank()
                || academicProjectDescription4.text.isNullOrBlank()

        var positionTitle1: TextView = findViewById(R.id.positionTitle1)
        positionTitle1.text =
            studentSharedPreferences.getString("workExperiencePositionTitleField1", "")

        var employerNameAndJobDuration1: TextView = findViewById(R.id.employerNameAndJobDuration1)
        var employerName1: String? =
            studentSharedPreferences.getString("workExperienceEmployerNameField1", "")
        var startMonth1: String? =
            studentSharedPreferences.getString("workExperienceStartMonthSpinner1", "")
        var startYear1: String? =
            studentSharedPreferences.getString("workExperienceStartYearSpinner1", "")
        var endMonth1: String? =
            studentSharedPreferences.getString("workExperienceEndMonthSpinner1", "")
        var endYear1: String? =
            studentSharedPreferences.getString("workExperienceEndYearSpinner1", "")
        employerNameAndJobDuration1.text =
            String.format("$employerName1  \u2022  $startMonth1 $startYear1 - $endMonth1 $endYear1")

        var jobDescription1: TextView = findViewById(R.id.jobDescription1)
        jobDescription1.text =
            studentSharedPreferences.getString("workExperienceJobDescriptionField1", "")

        var workExperience1DataNotInputted: Boolean = positionTitle1.text.isNullOrBlank()
                || employerName1.isNullOrBlank() || startMonth1.isNullOrBlank()
                || startYear1.isNullOrBlank() || endMonth1.isNullOrBlank()
                || endYear1.isNullOrBlank() || jobDescription1.text.isNullOrBlank()

        var positionTitle2: TextView = findViewById(R.id.positionTitle2)
        positionTitle2.text =
            studentSharedPreferences.getString("workExperiencePositionTitleField2", "")

        var employerNameAndJobDuration2: TextView = findViewById(R.id.employerNameAndJobDuration2)
        var employerName2: String? =
            studentSharedPreferences.getString("workExperienceEmployerNameField2", "")
        var startMonth2: String? =
            studentSharedPreferences.getString("workExperienceStartMonthSpinner2", "")
        var startYear2: String? =
            studentSharedPreferences.getString("workExperienceStartYearSpinner2", "")
        var endMonth2: String? =
            studentSharedPreferences.getString("workExperienceEndMonthSpinner2", "")
        var endYear2: String? =
            studentSharedPreferences.getString("workExperienceEndYearSpinner2", "")
        employerNameAndJobDuration2.text =
            String.format("$employerName2  \u2022  $startMonth2 $startYear2 - $endMonth2 $endYear2")

        var jobDescription2: TextView = findViewById(R.id.jobDescription2)
        jobDescription2.text =
            studentSharedPreferences.getString("workExperienceJobDescriptionField2", "")

        var workExperience2DataNotInputted: Boolean = positionTitle2.text.isNullOrBlank()
                || employerName2.isNullOrBlank() || startMonth2.isNullOrBlank()
                || startYear2.isNullOrBlank() || endMonth2.isNullOrBlank()
                || endYear2.isNullOrBlank() || jobDescription2.text.isNullOrBlank()

        var positionTitle3: TextView = findViewById(R.id.positionTitle3)
        positionTitle3.text =
            studentSharedPreferences.getString("workExperiencePositionTitleField3", "")

        var employerNameAndJobDuration3: TextView = findViewById(R.id.employerNameAndJobDuration3)
        var employerName3: String? =
            studentSharedPreferences.getString("workExperienceEmployerNameField3", "")
        var startMonth3: String? =
            studentSharedPreferences.getString("workExperienceStartMonthSpinner3", "")
        var startYear3: String? =
            studentSharedPreferences.getString("workExperienceStartYearSpinner3", "")
        var endMonth3: String? =
            studentSharedPreferences.getString("workExperienceEndMonthSpinner3", "")
        var endYear3: String? =
            studentSharedPreferences.getString("workExperienceEndYearSpinner3", "")
        employerNameAndJobDuration3.text =
            String.format("$employerName3  \u2022  $startMonth3 $startYear3 - $endMonth3 $endYear3")

        var jobDescription3: TextView = findViewById(R.id.jobDescription3)
        jobDescription3.text =
            studentSharedPreferences.getString("workExperienceJobDescriptionField3", "")

        var workExperience3DataNotInputted: Boolean = positionTitle3.text.isNullOrBlank()
                || employerName3.isNullOrBlank() || startMonth3.isNullOrBlank()
                || startYear3.isNullOrBlank() || endMonth3.isNullOrBlank()
                || endYear3.isNullOrBlank() || jobDescription3.text.isNullOrBlank()

        var positionTitle4: TextView = findViewById(R.id.positionTitle4)
        positionTitle4.text =
            studentSharedPreferences.getString("workExperiencePositionTitleField4", "")

        var employerNameAndJobDuration4: TextView = findViewById(R.id.employerNameAndJobDuration4)
        var employerName4: String? =
            studentSharedPreferences.getString("workExperienceEmployerNameField4", "")
        var startMonth4: String? =
            studentSharedPreferences.getString("workExperienceStartMonthSpinner4", "")
        var startYear4: String? =
            studentSharedPreferences.getString("workExperienceStartYearSpinner4", "")
        var endMonth4: String? =
            studentSharedPreferences.getString("workExperienceEndMonthSpinner4", "")
        var endYear4: String? =
            studentSharedPreferences.getString("workExperienceEndYearSpinner4", "")
        employerNameAndJobDuration4.text =
            String.format("$employerName4  \u2022  $startMonth4 $startYear4 - $endMonth4 $endYear4")

        var jobDescription4: TextView = findViewById(R.id.jobDescription4)
        jobDescription4.text =
            studentSharedPreferences.getString("workExperienceJobDescriptionField4", "")

        var workExperience4DataNotInputted: Boolean = positionTitle4.text.isNullOrBlank()
                || employerName4.isNullOrBlank() || startMonth4.isNullOrBlank()
                || startYear4.isNullOrBlank() || endMonth4.isNullOrBlank()
                || endYear4.isNullOrBlank() || jobDescription4.text.isNullOrBlank()

        /*If the user has not inputted a fourth Work Experience, hide the fourth work experience
        section from the student's profile.*/
        if (workExperience4DataNotInputted) {
            findViewById<TextView>(R.id.positionTitle4).visibility = View.INVISIBLE
            findViewById<TextView>(R.id.employerNameAndJobDuration4).visibility = View.INVISIBLE
            findViewById<TextView>(R.id.jobDescription4).visibility = View.INVISIBLE
        }

        /*If the user has not inputted a third Work Experience, hide the third work experience
        section from the student's profile.*/
        if (workExperience3DataNotInputted) {
            findViewById<TextView>(R.id.positionTitle3).visibility = View.INVISIBLE
            findViewById<TextView>(R.id.employerNameAndJobDuration3).visibility = View.INVISIBLE
            findViewById<TextView>(R.id.jobDescription3).visibility = View.INVISIBLE
        }

        /*If the user has not inputted a second Work Experience, hide the second work experience
        section from the student's profile.*/
        if (workExperience2DataNotInputted) {
            findViewById<TextView>(R.id.positionTitle2).visibility = View.INVISIBLE
            findViewById<TextView>(R.id.employerNameAndJobDuration2).visibility = View.INVISIBLE
            findViewById<TextView>(R.id.jobDescription2).visibility = View.INVISIBLE
        }

        /*If the user has not inputted any Work Experience, hide the "Work Experience" section
        of the student's profile.*/
        if (workExperience1DataNotInputted) {
            findViewById<CardView>(R.id.profileWorkExperienceCard).visibility = View.INVISIBLE
        }

        /*If the user has not inputted a fourth academic project, hide the fourth academic project
        section from the student's profile.*/
        if (academicProject4DataNotInputted) {
            findViewById<TextView>(R.id.academicProjectName4).visibility = View.INVISIBLE
            findViewById<TextView>(R.id.academicProjectCourse4).visibility = View.INVISIBLE
            findViewById<TextView>(R.id.academicProjectDescription4).visibility = View.INVISIBLE
        }

        /*If the user has not inputted a third academic project, hide the third academic project
        section from the student's profile.*/
        if (academicProject3DataNotInputted) {
            findViewById<TextView>(R.id.academicProjectName3).visibility = View.INVISIBLE
            findViewById<TextView>(R.id.academicProjectCourse3).visibility = View.INVISIBLE
            findViewById<TextView>(R.id.academicProjectDescription3).visibility = View.INVISIBLE
        }

        /*If the user has not inputted a second academic project, hide the second academic project
        section from the student's profile.*/
        if (academicProject2DataNotInputted) {
            findViewById<TextView>(R.id.academicProjectName2).visibility = View.INVISIBLE
            findViewById<TextView>(R.id.academicProjectCourse2).visibility = View.INVISIBLE
            findViewById<TextView>(R.id.academicProjectDescription2).visibility = View.INVISIBLE
        }

        /*If the user has not inputted any academic projects, hide the "Academic Projects" section
        of the student's profile.*/
        if (academicProject1DataNotInputted) {
            findViewById<CardView>(R.id.profileAcademicProjectsCard).visibility = View.INVISIBLE
        }

        /*Get the login page's "Edit Profile" button.*/
        var editProfileButton: Button = findViewById(R.id.editProfileButton)

        /*Create a click listener for this activity's "Edit Profile" button.*/
        editProfileButton.setOnClickListener {
            /*Take the user from this activity back to the ProfileCreationFormActivity.*/
            startActivity(Intent(this, ProfileCreationFormActivity::class.java))
        }
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