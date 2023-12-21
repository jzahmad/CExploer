package com.example.jobboost

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ProfileCreationPromptActivity : AppCompatActivity() {
    /**
     * This method initializes the application's ProfileCreationPromptActivity page when it is
     * being loaded by the application.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        /*Call the AppCompatActivity's onCreate() method to ensure that this activity gets
        initialized properly.*/
        super.onCreate(savedInstanceState)

        /*Set this activity's UI layout using the XML layout file associated with it (i.e.,
        activity_profile_creation_prompt.xml).*/
        setContentView(R.layout.activity_profile_creation_prompt)

        /*Get this activity's "Create Your Profile" button.*/
        var startCreatingProfileButton: Button = findViewById(R.id.startCreatingProfileButton)

        /*Create a click listener for this activity's "Create Your Profile" button.*/
        startCreatingProfileButton.setOnClickListener {
            /*Use an Intent to navigate from this activity to the ProfileCreationFormActivity.*/
            startActivity(Intent(this, ProfileCreationFormActivity::class.java))
        }
    }
}