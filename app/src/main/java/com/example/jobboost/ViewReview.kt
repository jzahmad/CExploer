package com.example.jobboost
import android.annotation.SuppressLint
import android.content.Intent
import android.database.Cursor
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.jobboost.notificationSettings.NotificationSettings

class ViewReview : AppCompatActivity() {
    private lateinit var dbHelper: ReviewDBHelper


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reviews)

        dbHelper = ReviewDBHelper(this)

        showAllReviews()

        val btnMain: Button = findViewById(R.id.btntoMain)
        btnMain.setOnClickListener { toReviewMain()
        }
    }

    // calls the database to view all the data
    @SuppressLint("SetTextI18n")
    private fun showAllReviews() {
        val reviewsLayout: LinearLayout = findViewById(R.id.layout)
        reviewsLayout.removeAllViews()

        val db = dbHelper.readableDatabase
        val projection = arrayOf(
            ReviewDBHelper.Companion.ReviewEntry.NAMER,
            ReviewDBHelper.Companion.ReviewEntry.LOCATION,
            ReviewDBHelper.Companion.ReviewEntry.REVIEW,
            ReviewDBHelper.Companion.ReviewEntry.RATING
        )

        val cursor: Cursor = db.query(
            ReviewDBHelper.Companion.ReviewEntry.REVIEW_TEXT,
            projection,
            null,
            null,
            null,
            null,
            null
        )

        with(cursor) {
            while (moveToNext()) {
                val name =
                    getString(getColumnIndexOrThrow(ReviewDBHelper.Companion.ReviewEntry.NAMER))
                val location =
                    getString(getColumnIndexOrThrow(ReviewDBHelper.Companion.ReviewEntry.LOCATION))
                val review =
                    getString(getColumnIndexOrThrow(ReviewDBHelper.Companion.ReviewEntry.REVIEW))
                val rating =
                    getDouble(getColumnIndexOrThrow(ReviewDBHelper.Companion.ReviewEntry.RATING))

                val reviewTextView = TextView(this@ViewReview)
                reviewTextView.text =
                    "Name: $name\nLocation: $location\nReview: $review\nRating: $rating\n"
                reviewsLayout.addView(reviewTextView)
            }
        }
        cursor.close()
        db.close()
    }
    // back butoon to go to reviewmain
        private fun toReviewMain() {
            val main = Intent(this, ReviewMain::class.java)
            startActivity(main)
            finish()
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
