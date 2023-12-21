package com.example.jobboost

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jobboost.notificationSettings.NotificationSettings
import com.google.android.material.navigation.NavigationView

class SearchFilterActivity : AppCompatActivity() {

    private lateinit var adapter: SearchFilterAdapter
    private lateinit var jobPostingHelper: JobPostingHelper

    //Set up the layout for search and filter page, then initialize components.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_filter)

        jobPostingHelper = JobPostingHelper(this)
        setupRecyclerView()
        setupSearchButton()
    }

    //Inflate the option menu
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

    //Set up the recyclerview
    private fun setupRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = SearchFilterAdapter(arrayListOf())
        recyclerView.adapter = adapter
    }

    //Set up the function of Search, Intern, and co-op button.
    private fun setupSearchButton() {
        val searchButton = findViewById<Button>(R.id.searchButton)
        searchButton.setOnClickListener {
            val searchText = findViewById<SearchView>(R.id.searchView).query.toString()
            val jobList = getJobsByTitle(searchText)
            adapter.updateData(jobList)
        }

        val internButton = findViewById<Button>(R.id.internButton)
        internButton.setOnClickListener {
            val jobList = getJobsByDuration("Intern")
            adapter.updateData(jobList)
        }

        val coOpButton = findViewById<Button>(R.id.coopButton)
        coOpButton.setOnClickListener {
            val jobList = getJobsByDuration("CO-OP")
            adapter.updateData(jobList)
        }
    }

    // Retrieve Company name, Job Title, Job Responsibilities, and Company Contact Information based on the Job Title.
    @SuppressLint("Range")
    private fun getJobsByTitle(title: String): ArrayList<SearchFilterModel> {
        val jobList = ArrayList<SearchFilterModel>()
        val selectQuery = "SELECT * FROM ${JobPostingHelper.TABLE_NAME} WHERE ${JobPostingHelper.COLUMN_JOB_TITLE} LIKE '%$title%'"
        val db = jobPostingHelper.readableDatabase
        val cursor = db.rawQuery(selectQuery, null)

        if (cursor.moveToFirst()) {
            do {
                val job = SearchFilterModel(
                    cursor.getString(cursor.getColumnIndex(JobPostingHelper.COLUMN_COMPANY_NAME)),
                    cursor.getString(cursor.getColumnIndex(JobPostingHelper.COLUMN_JOB_TITLE)),
                    cursor.getString(cursor.getColumnIndex(JobPostingHelper.COLUMN_ROLES_RESPONSIBILITIES)),
                    cursor.getString(cursor.getColumnIndex(JobPostingHelper.COLUMN_EMPLOYER_CONTACT_INFO))
                )
                jobList.add(job)
            } while (cursor.moveToNext())
        } else {
            Toast.makeText(this, "$title has not been posted", Toast.LENGTH_SHORT).show()
        }
        cursor.close()
        return jobList
    }

    //Retrieve Company name, Job Title, Job Responsibilities, and Company Contact Information based on the Job Duration.
    @SuppressLint("Range")
    private fun getJobsByDuration(duration: String): ArrayList<SearchFilterModel> {
        val jobList = ArrayList<SearchFilterModel>()
        val selectQuery = "SELECT * FROM ${JobPostingHelper.TABLE_NAME} WHERE ${JobPostingHelper.COLUMN_JOB_DURATION} = '$duration'"
        val db = jobPostingHelper.readableDatabase
        val cursor = db.rawQuery(selectQuery, null)

        if (cursor.moveToFirst()) {
            do {
                val job = SearchFilterModel(
                    cursor.getString(cursor.getColumnIndex(JobPostingHelper.COLUMN_COMPANY_NAME)),
                    cursor.getString(cursor.getColumnIndex(JobPostingHelper.COLUMN_JOB_TITLE)),
                    cursor.getString(cursor.getColumnIndex(JobPostingHelper.COLUMN_ROLES_RESPONSIBILITIES)),
                    cursor.getString(cursor.getColumnIndex(JobPostingHelper.COLUMN_EMPLOYER_CONTACT_INFO))
                )
                jobList.add(job)
            } while (cursor.moveToNext())
        } else {
            Toast.makeText(this, "No jobs found for $duration", Toast.LENGTH_SHORT).show()
        }
        cursor.close()
        return jobList
    }

    //Close the connection with database, and release the resources.
    override fun onDestroy() {
        jobPostingHelper.close()
        super.onDestroy()
    }
}
