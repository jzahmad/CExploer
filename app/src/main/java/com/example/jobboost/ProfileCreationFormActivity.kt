package com.example.jobboost

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import de.hdodenhof.circleimageview.CircleImageView

class ProfileCreationFormActivity : AppCompatActivity() {
    /*Create a variable for storing the intent responsible for taking the user from this activity
    to the StudentProfileActivity.*/
    private lateinit var goToStudentProfileActivityIntent:Intent

    /**
     * This method initializes the application's ProfileCreationFormActivity page when it is
     * being loaded by the application.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        /*Call the AppCompatActivity's onCreate() method to ensure that this activity gets
        initialized properly.*/
        super.onCreate(savedInstanceState)

        /*Set this activity's UI layout using the XML layout file associated with it (i.e.,
        activity_profile_creation_form.xml).*/
        setContentView(R.layout.activity_profile_creation_form)

        /*Initialize the intent responsible for taking the user from this activity to the
        StudentProfileActivity.*/
        goToStudentProfileActivityIntent = Intent(this, StudentProfileActivity::class.java)

        /*Get this activity's "Upload Profile Picture" button.*/
        var uploadProfilePictureButton: Button = findViewById(R.id.uploadProfilePictureButton)

        /*Create a click listener for this activity's "Upload Profile Picture" button.*/
        uploadProfilePictureButton.setOnClickListener {
            /*Create an intent for picking an item from the data available on the device running
            the app.*/
            var uploadProfilePictureIntent = Intent(Intent.ACTION_PICK)

            /*Set the intent's type to be an image of any format, to only the user to pick images
            when the "Upload Profile Picture" button is clicked.*/
            uploadProfilePictureIntent.type = "image/*"

            /*Start the activity with the specified intent. This will load the device's photo
            library since that is the only activity that would allow the user to only pick images*/
            startActivityForResult(uploadProfilePictureIntent, 1)
        }

        /*Get this activity's "Create Profile" button.*/
        var createProfileButton: Button = findViewById(R.id.createProfileButton)

        /*Create a click listener for this activity's "Create Profile" button.*/
        createProfileButton.setOnClickListener {
            /*Get all the information inputted by the user in this activity (i.e.,
            ProfileCreationFormActivity).*/
            var nameField: EditText = findViewById(R.id.nameField)
            var pronounsField: EditText = findViewById(R.id.pronounsField)
            var bioField: EditText = findViewById(R.id.bioField)
            var emailField: EditText = findViewById(R.id.emailField)
            var phoneNumberField: EditText = findViewById(R.id.phoneNumberField)
            var yearOfStudySpinner: Spinner = findViewById(R.id.yearOfStudySpinner)
            var programSpinner: Spinner = findViewById(R.id.programSpinner)
            var projectNameField1: EditText = findViewById(R.id.projectNameField1)
            var projectNameField2: EditText = findViewById(R.id.projectNameField2)
            var projectNameField3: EditText = findViewById(R.id.projectNameField3)
            var projectNameField4: EditText = findViewById(R.id.projectNameField4)
            var projectCourseField1: EditText = findViewById(R.id.projectCourseField1)
            var projectCourseField2: EditText = findViewById(R.id.projectCourseField2)
            var projectCourseField3: EditText = findViewById(R.id.projectCourseField3)
            var projectCourseField4: EditText = findViewById(R.id.projectCourseField4)
            var projectDescriptionField1: EditText = findViewById(R.id.projectDescriptionField1)
            var projectDescriptionField2: EditText = findViewById(R.id.projectDescriptionField2)
            var projectDescriptionField3: EditText = findViewById(R.id.projectDescriptionField3)
            var projectDescriptionField4: EditText = findViewById(R.id.projectDescriptionField4)
            var workExperienceEmployerNameField1: EditText = findViewById(R.id.workExperienceEmployerNameField1)
            var workExperienceEmployerNameField2: EditText = findViewById(R.id.workExperienceEmployerNameField2)
            var workExperienceEmployerNameField3: EditText = findViewById(R.id.workExperienceEmployerNameField3)
            var workExperienceEmployerNameField4: EditText = findViewById(R.id.workExperienceEmployerNameField4)
            var workExperiencePositionTitleField1: EditText = findViewById(R.id.workExperiencePositionTitleField1)
            var workExperiencePositionTitleField2: EditText = findViewById(R.id.workExperiencePositionTitleField2)
            var workExperiencePositionTitleField3: EditText = findViewById(R.id.workExperiencePositionTitleField3)
            var workExperiencePositionTitleField4: EditText = findViewById(R.id.workExperiencePositionTitleField4)
            var workExperienceJobDescriptionField1: EditText = findViewById(R.id.workExperienceJobDescriptionField1)
            var workExperienceJobDescriptionField2: EditText = findViewById(R.id.workExperienceJobDescriptionField2)
            var workExperienceJobDescriptionField3: EditText = findViewById(R.id.workExperienceJobDescriptionField3)
            var workExperienceJobDescriptionField4: EditText = findViewById(R.id.workExperienceJobDescriptionField4)
            var workExperienceStartMonthSpinner1: Spinner = findViewById(R.id.workExperienceStartMonthSpinner1)
            var workExperienceStartMonthSpinner2: Spinner = findViewById(R.id.workExperienceStartMonthSpinner2)
            var workExperienceStartMonthSpinner3: Spinner = findViewById(R.id.workExperienceStartMonthSpinner3)
            var workExperienceStartMonthSpinner4: Spinner = findViewById(R.id.workExperienceStartMonthSpinner4)
            var workExperienceStartYearSpinner1: Spinner = findViewById(R.id.workExperienceStartYearSpinner1)
            var workExperienceStartYearSpinner2: Spinner = findViewById(R.id.workExperienceStartYearSpinner2)
            var workExperienceStartYearSpinner3: Spinner = findViewById(R.id.workExperienceStartYearSpinner3)
            var workExperienceStartYearSpinner4: Spinner = findViewById(R.id.workExperienceStartYearSpinner4)
            var workExperienceEndMonthSpinner1: Spinner = findViewById(R.id.workExperienceEndMonthSpinner1)
            var workExperienceEndMonthSpinner2: Spinner = findViewById(R.id.workExperienceEndMonthSpinner2)
            var workExperienceEndMonthSpinner3: Spinner = findViewById(R.id.workExperienceEndMonthSpinner3)
            var workExperienceEndMonthSpinner4: Spinner = findViewById(R.id.workExperienceEndMonthSpinner4)
            var workExperienceEndYearSpinner1: Spinner = findViewById(R.id.workExperienceEndYearSpinner1)
            var workExperienceEndYearSpinner2: Spinner = findViewById(R.id.workExperienceEndYearSpinner2)
            var workExperienceEndYearSpinner3: Spinner = findViewById(R.id.workExperienceEndYearSpinner3)
            var workExperienceEndYearSpinner4: Spinner = findViewById(R.id.workExperienceEndYearSpinner4)

            /*If the user tries to submit this activity's form but has left the "Full Name", "Email"
            fields in the form empty, alert them that the name field cannot be left empty.*/
            var allRequiredFieldsFilled:Boolean = true
            var emptyFieldErrorMessage:String = "This field connot be empty!"

            if(nameField.text.toString().isNullOrBlank()) {
                nameField.setError(emptyFieldErrorMessage)
                allRequiredFieldsFilled = false
            }

            if(emailField.text.toString().isNullOrBlank()) {
                emailField.setError(emptyFieldErrorMessage)
                allRequiredFieldsFilled = false
            }

            if(phoneNumberField.text.toString().isNullOrBlank()) {
                phoneNumberField.setError(emptyFieldErrorMessage)
                allRequiredFieldsFilled = false
            }

            if(allRequiredFieldsFilled) {
                /*Use SharedPreferences to save all the information inputted by the user in this
                activity (i.e., ProfileCreationFormActivity).*/
                var studentSharedPreferences =
                    getSharedPreferences("Student's Preferences", MODE_PRIVATE)
                var sharedPreferencesEditor = studentSharedPreferences.edit()
                sharedPreferencesEditor.putString("nameField", nameField.text.toString())
                sharedPreferencesEditor.putString("pronounsField", pronounsField.text.toString())
                sharedPreferencesEditor.putString("bioField", bioField.text.toString())
                sharedPreferencesEditor.putString("emailField", emailField.text.toString())
                sharedPreferencesEditor.putString(
                    "phoneNumberField",
                    phoneNumberField.text.toString()
                )
                sharedPreferencesEditor.putString(
                    "yearOfStudySpinner",
                    yearOfStudySpinner.selectedItem.toString()
                )
                sharedPreferencesEditor.putString(
                    "programSpinner",
                    programSpinner.selectedItem.toString()
                )
                sharedPreferencesEditor.putString(
                    "projectNameField1",
                    projectNameField1.text.toString()
                )
                sharedPreferencesEditor.putString(
                    "projectNameField2",
                    projectNameField2.text.toString()
                )
                sharedPreferencesEditor.putString(
                    "projectNameField3",
                    projectNameField3.text.toString()
                )
                sharedPreferencesEditor.putString(
                    "projectNameField4",
                    projectNameField4.text.toString()
                )
                sharedPreferencesEditor.putString(
                    "projectCourseField1",
                    projectCourseField1.text.toString()
                )
                sharedPreferencesEditor.putString(
                    "projectCourseField2",
                    projectCourseField2.text.toString()
                )
                sharedPreferencesEditor.putString(
                    "projectCourseField3",
                    projectCourseField3.text.toString()
                )
                sharedPreferencesEditor.putString(
                    "projectCourseField4",
                    projectCourseField4.text.toString()
                )
                sharedPreferencesEditor.putString(
                    "projectDescriptionField1",
                    projectDescriptionField1.text.toString()
                )
                sharedPreferencesEditor.putString(
                    "projectDescriptionField2",
                    projectDescriptionField2.text.toString()
                )
                sharedPreferencesEditor.putString(
                    "projectDescriptionField3",
                    projectDescriptionField3.text.toString()
                )
                sharedPreferencesEditor.putString(
                    "projectDescriptionField4",
                    projectDescriptionField4.text.toString()
                )
                sharedPreferencesEditor.putString(
                    "workExperienceEmployerNameField1",
                    workExperienceEmployerNameField1.text.toString()
                )
                sharedPreferencesEditor.putString(
                    "workExperienceEmployerNameField2",
                    workExperienceEmployerNameField2.text.toString()
                )
                sharedPreferencesEditor.putString(
                    "workExperienceEmployerNameField3",
                    workExperienceEmployerNameField3.text.toString()
                )
                sharedPreferencesEditor.putString(
                    "workExperienceEmployerNameField4",
                    workExperienceEmployerNameField4.text.toString()
                )
                sharedPreferencesEditor.putString(
                    "workExperiencePositionTitleField1",
                    workExperiencePositionTitleField1.text.toString()
                )
                sharedPreferencesEditor.putString(
                    "workExperiencePositionTitleField2",
                    workExperiencePositionTitleField2.text.toString()
                )
                sharedPreferencesEditor.putString(
                    "workExperiencePositionTitleField3",
                    workExperiencePositionTitleField3.text.toString()
                )
                sharedPreferencesEditor.putString(
                    "workExperiencePositionTitleField4",
                    workExperiencePositionTitleField4.text.toString()
                )
                sharedPreferencesEditor.putString(
                    "workExperienceJobDescriptionField1",
                    workExperienceJobDescriptionField1.text.toString()
                )
                sharedPreferencesEditor.putString(
                    "workExperienceJobDescriptionField2",
                    workExperienceJobDescriptionField2.text.toString()
                )
                sharedPreferencesEditor.putString(
                    "workExperienceJobDescriptionField3",
                    workExperienceJobDescriptionField3.text.toString()
                )
                sharedPreferencesEditor.putString(
                    "workExperienceJobDescriptionField4",
                    workExperienceJobDescriptionField4.text.toString()
                )
                sharedPreferencesEditor.putString(
                    "workExperienceStartMonthSpinner1",
                    workExperienceStartMonthSpinner1.selectedItem.toString()
                )
                sharedPreferencesEditor.putString(
                    "workExperienceStartMonthSpinner2",
                    workExperienceStartMonthSpinner2.selectedItem.toString()
                )
                sharedPreferencesEditor.putString(
                    "workExperienceStartMonthSpinner3",
                    workExperienceStartMonthSpinner3.selectedItem.toString()
                )
                sharedPreferencesEditor.putString(
                    "workExperienceStartMonthSpinner4",
                    workExperienceStartMonthSpinner4.selectedItem.toString()
                )
                sharedPreferencesEditor.putString(
                    "workExperienceStartYearSpinner1",
                    workExperienceStartYearSpinner1.selectedItem.toString()
                )
                sharedPreferencesEditor.putString(
                    "workExperienceStartYearSpinner2",
                    workExperienceStartYearSpinner2.selectedItem.toString()
                )
                sharedPreferencesEditor.putString(
                    "workExperienceStartYearSpinner3",
                    workExperienceStartYearSpinner3.selectedItem.toString()
                )
                sharedPreferencesEditor.putString(
                    "workExperienceStartYearSpinner4",
                    workExperienceStartYearSpinner4.selectedItem.toString()
                )
                sharedPreferencesEditor.putString(
                    "workExperienceEndMonthSpinner1",
                    workExperienceEndMonthSpinner1.selectedItem.toString()
                )
                sharedPreferencesEditor.putString(
                    "workExperienceEndMonthSpinner2",
                    workExperienceEndMonthSpinner2.selectedItem.toString()
                )
                sharedPreferencesEditor.putString(
                    "workExperienceEndMonthSpinner3",
                    workExperienceEndMonthSpinner3.selectedItem.toString()
                )
                sharedPreferencesEditor.putString(
                    "workExperienceEndMonthSpinner4",
                    workExperienceEndMonthSpinner4.selectedItem.toString()
                )
                sharedPreferencesEditor.putString(
                    "workExperienceEndYearSpinner1",
                    workExperienceEndYearSpinner1.selectedItem.toString()
                )
                sharedPreferencesEditor.putString(
                    "workExperienceEndYearSpinner2",
                    workExperienceEndYearSpinner2.selectedItem.toString()
                )
                sharedPreferencesEditor.putString(
                    "workExperienceEndYearSpinner3",
                    workExperienceEndYearSpinner3.selectedItem.toString()
                )
                sharedPreferencesEditor.putString(
                    "workExperienceEndYearSpinner4",
                    workExperienceEndYearSpinner4.selectedItem.toString()
                )
                sharedPreferencesEditor.apply()

                /*Start the intent responsible for taking the user from this activity to the
                StudentProfileActivity.*/
                startActivity(goToStudentProfileActivityIntent)
            }
        }
    }

    /**
     * This method handles the results returned by any activity that was started for the purpose
     * of returning a result.
     */
    @SuppressLint("ResourceAsColor")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        /*Get this activity's "Upload Profile Picture" button.*/
        var uploadProfilePictureButton: Button = findViewById(R.id.uploadProfilePictureButton)

        /*Check that the request code received matches the request code of the activity specifically
        started for the intent responsible for directing the user to selecting a profile picture
        from their device's photo library, and that that activity was successful.*/
        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            /*Change this activity's "Upload Profile Picture" button background colour to white and
            change the text inside the button to "Profile Picture Uploaded".*/
            uploadProfilePictureButton.setBackgroundColor(R.color.white)
            uploadProfilePictureButton.setText("Profile Picture Uploaded")

            /*Get the URI of the image selected by the user from their device's photo library, and
            add it to the intent responsible for taking the user from this activity to the
            StudentProfileActivity.*/
            goToStudentProfileActivityIntent.putExtra("uriOfSelectedImage", data?.data.toString())
        }
    }

    /**
     * This method controls what happens in the activity's page in the application when the
     * user resumes using the application after closing or pausing it.
     */
    override fun onResume() {
        super.onResume()

        /*Use SharedPreferences to save all the information inputted by the user in this
        activity (i.e., ProfileCreationFormActivity).*/
        var studentSharedPreferences = getSharedPreferences("Student's Preferences", MODE_PRIVATE)

        /*Populate the fields of the form in this activity with all the data that the user
        previously inputted into the fields.*/
        var nameField: EditText = findViewById(R.id.nameField)
        nameField.setText(studentSharedPreferences.getString("nameField", nameField.text.toString()))

        var pronounsField: EditText = findViewById(R.id.pronounsField)
        pronounsField.setText(studentSharedPreferences.getString("pronounsField", pronounsField.text.toString()))

        var bioField: EditText = findViewById(R.id.bioField)
        bioField.setText(studentSharedPreferences.getString("bioField", bioField.text.toString()))

        var emailField: EditText = findViewById(R.id.emailField)
        emailField.setText(studentSharedPreferences.getString("emailField", emailField.text.toString()))

        var phoneNumberField: EditText = findViewById(R.id.phoneNumberField)
        phoneNumberField.setText(studentSharedPreferences.getString("phoneNumberField",
            phoneNumberField.text.toString()))

        var yearOfStudySpinner: Spinner = findViewById(R.id.yearOfStudySpinner)
        yearOfStudySpinner.setSelection(((yearOfStudySpinner.adapter as ArrayAdapter<String>)
            .getPosition(studentSharedPreferences.getString("yearOfStudySpinner", yearOfStudySpinner.selectedItem.toString()))))

        var programSpinner: Spinner = findViewById(R.id.programSpinner)
        programSpinner.setSelection(((programSpinner.adapter as ArrayAdapter<String>)
            .getPosition(studentSharedPreferences.getString("programSpinner", programSpinner.selectedItem.toString()))))

        var projectNameField1: EditText = findViewById(R.id.projectNameField1)
        projectNameField1.setText(studentSharedPreferences.getString("projectNameField1",
            projectNameField1.text.toString()))

        var projectNameField2: EditText = findViewById(R.id.projectNameField2)
        projectNameField2.setText(studentSharedPreferences.getString("projectNameField2",
            projectNameField2.text.toString()))

        var projectNameField3: EditText = findViewById(R.id.projectNameField3)
        projectNameField3.setText(studentSharedPreferences.getString("projectNameField3",
            projectNameField3.text.toString()))

        var projectNameField4: EditText = findViewById(R.id.projectNameField4)
        projectNameField4.setText(studentSharedPreferences.getString("projectNameField4",
            projectNameField4.text.toString()))

        var projectCourseField1: EditText = findViewById(R.id.projectCourseField1)
        projectCourseField1.setText(studentSharedPreferences.getString("projectCourseField1",
            projectCourseField1.text.toString()))

        var projectCourseField2: EditText = findViewById(R.id.projectCourseField2)
        projectCourseField2.setText(studentSharedPreferences.getString("projectCourseField2",
            projectCourseField2.text.toString()))

        var projectCourseField3: EditText = findViewById(R.id.projectCourseField3)
        projectCourseField3.setText(studentSharedPreferences.getString("projectCourseField3",
            projectCourseField3.text.toString()))

        var projectCourseField4: EditText = findViewById(R.id.projectCourseField4)
        projectCourseField4.setText(studentSharedPreferences.getString("projectCourseField4",
            projectCourseField4.text.toString()))

        var projectDescriptionField1: EditText = findViewById(R.id.projectDescriptionField1)
        projectDescriptionField1.setText(studentSharedPreferences.getString("projectDescriptionField1",
            projectDescriptionField1.text.toString()))

        var projectDescriptionField2: EditText = findViewById(R.id.projectDescriptionField2)
        projectDescriptionField2.setText(studentSharedPreferences.getString("projectDescriptionField2",
            projectDescriptionField2.text.toString()))

        var projectDescriptionField3: EditText = findViewById(R.id.projectDescriptionField3)
        projectDescriptionField3.setText(studentSharedPreferences.getString("projectDescriptionField3",
            projectDescriptionField3.text.toString()))

        var projectDescriptionField4: EditText = findViewById(R.id.projectDescriptionField4)
        projectDescriptionField4.setText(studentSharedPreferences.getString("projectDescriptionField4",
            projectDescriptionField4.text.toString()))

        var workExperienceEmployerNameField1: EditText = findViewById(R.id.workExperienceEmployerNameField1)
        workExperienceEmployerNameField1.setText(studentSharedPreferences.getString("workExperienceEmployerNameField1",
            workExperienceEmployerNameField1.text.toString()))

        var workExperienceEmployerNameField2: EditText = findViewById(R.id.workExperienceEmployerNameField2)
        workExperienceEmployerNameField2.setText(studentSharedPreferences.getString("workExperienceEmployerNameField2",
            workExperienceEmployerNameField2.text.toString()))

        var workExperienceEmployerNameField3: EditText = findViewById(R.id.workExperienceEmployerNameField3)
        workExperienceEmployerNameField3.setText(studentSharedPreferences.getString("workExperienceEmployerNameField3",
            workExperienceEmployerNameField3.text.toString()))

        var workExperienceEmployerNameField4: EditText = findViewById(R.id.workExperienceEmployerNameField4)
        workExperienceEmployerNameField4.setText(studentSharedPreferences.getString("workExperienceEmployerNameField4",
            workExperienceEmployerNameField4.text.toString()))

        var workExperiencePositionTitleField1: EditText = findViewById(R.id.workExperiencePositionTitleField1)
        workExperiencePositionTitleField1.setText(studentSharedPreferences.getString("workExperiencePositionTitleField1",
            workExperiencePositionTitleField1.text.toString()))

        var workExperiencePositionTitleField2: EditText = findViewById(R.id.workExperiencePositionTitleField2)
        workExperiencePositionTitleField2.setText(studentSharedPreferences.getString("workExperiencePositionTitleField2",
            workExperiencePositionTitleField2.text.toString()))

        var workExperiencePositionTitleField3: EditText = findViewById(R.id.workExperiencePositionTitleField3)
        workExperiencePositionTitleField3.setText(studentSharedPreferences.getString("workExperiencePositionTitleField3",
            workExperiencePositionTitleField3.text.toString()))

        var workExperiencePositionTitleField4: EditText = findViewById(R.id.workExperiencePositionTitleField4)
        workExperiencePositionTitleField4.setText(studentSharedPreferences.getString("workExperiencePositionTitleField4",
            workExperiencePositionTitleField4.text.toString()))

        var workExperienceJobDescriptionField1: EditText = findViewById(R.id.workExperienceJobDescriptionField1)
        workExperienceJobDescriptionField1.setText(studentSharedPreferences.getString("workExperienceJobDescriptionField1",
            workExperienceJobDescriptionField1.text.toString()))

        var workExperienceJobDescriptionField2: EditText = findViewById(R.id.workExperienceJobDescriptionField2)
        workExperienceJobDescriptionField2.setText(studentSharedPreferences.getString("workExperienceJobDescriptionField2",
            workExperienceJobDescriptionField2.text.toString()))

        var workExperienceJobDescriptionField3: EditText = findViewById(R.id.workExperienceJobDescriptionField3)
        workExperienceJobDescriptionField3.setText(studentSharedPreferences.getString("workExperienceJobDescriptionField3",
            workExperienceJobDescriptionField3.text.toString()))

        var workExperienceJobDescriptionField4: EditText = findViewById(R.id.workExperienceJobDescriptionField4)
        workExperienceJobDescriptionField4.setText(studentSharedPreferences.getString("workExperienceJobDescriptionField4",
            workExperienceJobDescriptionField4.text.toString()))

        var workExperienceStartMonthSpinner1: Spinner = findViewById(R.id.workExperienceStartMonthSpinner1)
        workExperienceStartMonthSpinner1.setSelection(((workExperienceStartMonthSpinner1.adapter as ArrayAdapter<String>)
            .getPosition(studentSharedPreferences.getString("workExperienceStartMonthSpinner1", workExperienceStartMonthSpinner1.selectedItem.toString()))))

        var workExperienceStartMonthSpinner2: Spinner = findViewById(R.id.workExperienceStartMonthSpinner2)
        workExperienceStartMonthSpinner2.setSelection(((workExperienceStartMonthSpinner2.adapter as ArrayAdapter<String>)
            .getPosition(studentSharedPreferences.getString("workExperienceStartMonthSpinner2", workExperienceStartMonthSpinner2.selectedItem.toString()))))

        var workExperienceStartMonthSpinner3: Spinner = findViewById(R.id.workExperienceStartMonthSpinner3)
        workExperienceStartMonthSpinner3.setSelection(((workExperienceStartMonthSpinner3.adapter as ArrayAdapter<String>)
            .getPosition(studentSharedPreferences.getString("workExperienceStartMonthSpinner3", workExperienceStartMonthSpinner3.selectedItem.toString()))))

        var workExperienceStartMonthSpinner4: Spinner = findViewById(R.id.workExperienceStartMonthSpinner4)
        workExperienceStartMonthSpinner4.setSelection(((workExperienceStartMonthSpinner4.adapter as ArrayAdapter<String>)
            .getPosition(studentSharedPreferences.getString("workExperienceStartMonthSpinner4", workExperienceStartMonthSpinner4.selectedItem.toString()))))

        var workExperienceStartYearSpinner1: Spinner = findViewById(R.id.workExperienceStartYearSpinner1)
        workExperienceStartYearSpinner1.setSelection(((workExperienceStartYearSpinner1.adapter as ArrayAdapter<String>)
            .getPosition(studentSharedPreferences.getString("workExperienceStartYearSpinner1", workExperienceStartYearSpinner1.selectedItem.toString()))))

        var workExperienceStartYearSpinner2: Spinner = findViewById(R.id.workExperienceStartYearSpinner2)
        workExperienceStartYearSpinner2.setSelection(((workExperienceStartYearSpinner2.adapter as ArrayAdapter<String>)
            .getPosition(studentSharedPreferences.getString("workExperienceStartYearSpinner2", workExperienceStartYearSpinner2.selectedItem.toString()))))

        var workExperienceStartYearSpinner3: Spinner = findViewById(R.id.workExperienceStartYearSpinner3)
        workExperienceStartYearSpinner3.setSelection(((workExperienceStartYearSpinner3.adapter as ArrayAdapter<String>)
            .getPosition(studentSharedPreferences.getString("workExperienceStartYearSpinner3", workExperienceStartYearSpinner3.selectedItem.toString()))))

        var workExperienceStartYearSpinner4: Spinner = findViewById(R.id.workExperienceStartYearSpinner4)
        workExperienceStartYearSpinner4.setSelection(((workExperienceStartYearSpinner4.adapter as ArrayAdapter<String>)
            .getPosition(studentSharedPreferences.getString("workExperienceStartYearSpinner4", workExperienceStartYearSpinner4.selectedItem.toString()))))

        var workExperienceEndMonthSpinner1: Spinner = findViewById(R.id.workExperienceEndMonthSpinner1)
        workExperienceEndMonthSpinner1.setSelection(((workExperienceEndMonthSpinner1.adapter as ArrayAdapter<String>)
            .getPosition(studentSharedPreferences.getString("workExperienceEndMonthSpinner1", workExperienceEndMonthSpinner1.selectedItem.toString()))))

        var workExperienceEndMonthSpinner2: Spinner = findViewById(R.id.workExperienceEndMonthSpinner2)
        workExperienceEndMonthSpinner2.setSelection(((workExperienceEndMonthSpinner2.adapter as ArrayAdapter<String>)
            .getPosition(studentSharedPreferences.getString("workExperienceEndMonthSpinner2", workExperienceEndMonthSpinner2.selectedItem.toString()))))

        var workExperienceEndMonthSpinner3: Spinner = findViewById(R.id.workExperienceEndMonthSpinner3)
        workExperienceEndMonthSpinner3.setSelection(((workExperienceEndMonthSpinner3.adapter as ArrayAdapter<String>)
            .getPosition(studentSharedPreferences.getString("workExperienceEndMonthSpinner3", workExperienceEndMonthSpinner3.selectedItem.toString()))))

        var workExperienceEndMonthSpinner4: Spinner = findViewById(R.id.workExperienceEndMonthSpinner4)
        workExperienceEndMonthSpinner4.setSelection(((workExperienceEndMonthSpinner4.adapter as ArrayAdapter<String>)
            .getPosition(studentSharedPreferences.getString("workExperienceEndMonthSpinner4", workExperienceEndMonthSpinner4.selectedItem.toString()))))

        var workExperienceEndYearSpinner1: Spinner = findViewById(R.id.workExperienceEndYearSpinner1)
        workExperienceEndYearSpinner1.setSelection(((workExperienceEndYearSpinner1.adapter as ArrayAdapter<String>)
            .getPosition(studentSharedPreferences.getString("workExperienceEndYearSpinner1", workExperienceEndYearSpinner1.selectedItem.toString()))))

        var workExperienceEndYearSpinner2: Spinner = findViewById(R.id.workExperienceEndYearSpinner2)
        workExperienceEndYearSpinner2.setSelection(((workExperienceEndYearSpinner2.adapter as ArrayAdapter<String>)
            .getPosition(studentSharedPreferences.getString("workExperienceEndYearSpinner2", workExperienceEndYearSpinner2.selectedItem.toString()))))

        var workExperienceEndYearSpinner3: Spinner = findViewById(R.id.workExperienceEndYearSpinner3)
        workExperienceEndYearSpinner3.setSelection(((workExperienceEndYearSpinner3.adapter as ArrayAdapter<String>)
            .getPosition(studentSharedPreferences.getString("workExperienceEndYearSpinner3", workExperienceEndYearSpinner3.selectedItem.toString()))))

        var workExperienceEndYearSpinner4: Spinner = findViewById(R.id.workExperienceEndYearSpinner4)
        workExperienceEndYearSpinner4.setSelection(((workExperienceEndYearSpinner4.adapter as ArrayAdapter<String>)
            .getPosition(studentSharedPreferences.getString("workExperienceEndYearSpinner4", workExperienceEndYearSpinner4.selectedItem.toString()))))
    }
}