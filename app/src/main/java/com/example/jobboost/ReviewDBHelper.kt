package com.example.jobboost

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns

class ReviewDBHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    // sets up database
    companion object {
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "re.db"
        object ReviewEntry : BaseColumns {
            const val REVIEW_TEXT = "reviews"
            const val NAMER = "name"
            const val LOCATION = "location"
            const val REVIEW = "review"
            const val RATING = "rating"
        }
    }

    // creates entries for database
    val CREATE =
        "CREATE TABLE ${ReviewEntry.REVIEW_TEXT} (" +
                "${BaseColumns._ID} INTEGER PRIMARY KEY," +
                "${ReviewEntry.NAMER} TEXT," +
                "${ReviewEntry.LOCATION} TEXT," +
                "${ReviewEntry.REVIEW} TEXT," +
                "${ReviewEntry.RATING} REAL)"

    val DELETE = "DROP TABLE IF EXISTS ${ReviewEntry.REVIEW_TEXT}"

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(CREATE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(DELETE)
        onCreate(db)
    }


}
