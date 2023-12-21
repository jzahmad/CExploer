package com.example.jobboost
import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.jobboost.notificationSettings.NotificationSettings

class ReviewMain : AppCompatActivity() {
    private lateinit var dbHelper: ReviewDBHelper

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reviewmain)

        dbHelper = ReviewDBHelper(this)

        val addReviewButton: Button = findViewById(R.id.Addbtn)
        addReviewButton.setOnClickListener {
            addReview()
        }

        val showReviewsButton: Button = findViewById(R.id.Showbtn)
        showReviewsButton.setOnClickListener {
            showAllReviews()
        }
    }

    //sets up add. button which adds data to database
    private fun addReview() {
        val nameEditText: EditText = findViewById(R.id.EmpName)
        val locationEditText: EditText = findViewById(R.id.LocName)
        val reviewEditText: EditText = findViewById(R.id.ReviewText)
        val ratingBar: RatingBar = findViewById(R.id.Rating)

        val name = nameEditText.text.toString()
        val location = locationEditText.text.toString()
        val review = reviewEditText.text.toString()
        val rating = ratingBar.rating

        if (name.isNotEmpty() && location.isNotEmpty() && review.isNotEmpty()) {
            val db = dbHelper.writableDatabase
            val values = ContentValues().apply {
                put(ReviewDBHelper.Companion.ReviewEntry.NAMER, name)
                put(ReviewDBHelper.Companion.ReviewEntry.LOCATION, location)
                put(ReviewDBHelper.Companion.ReviewEntry.REVIEW, review)
                put(ReviewDBHelper.Companion.ReviewEntry.RATING, rating.toDouble())
            }

            val newRowId = db.insert(ReviewDBHelper.Companion.ReviewEntry.REVIEW_TEXT, null, values)

            if (newRowId != -1L) {
                Toast.makeText(this, "Review added", Toast.LENGTH_SHORT).show()
                showAllReviews()
            } else {
                Toast.makeText(this, "Error adding review", Toast.LENGTH_SHORT).show()
            }
            db.close()
        } else {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
        }
    }

    // takes to viewreview.kt
    private fun showAllReviews() {
        val viewreview = Intent(this, ViewReview::class.java)
        startActivity(viewreview)
    }

    //This will create the navigation menu
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
