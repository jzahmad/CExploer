package com.example.jobboost

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SignupDBHelper (context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object{
        private const val DATABASE_VERSION = 2
        private const val DATABASE_NAME = "signup.db"
        private const val NAME = "name"
        private const val EMAIL = "email"
        private const val Password = "password"
        private const val Signup_Table = "signup_table"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        var signupTable = ("CREATE TABLE $Signup_Table ("
                +"$NAME TEXT, "
                +"$EMAIL TEXT, "
                +"$Password TEXT)")
        db?.execSQL(signupTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS ${Signup_Table}")
        onCreate(db)
    }

    fun insertSignup (signupModel: SignupModel): Long {
        var signupDatabase = this.writableDatabase
        var contentValues = ContentValues()
        contentValues.put(NAME, signupModel.name)
        contentValues.put(EMAIL, signupModel.email)
        contentValues.put(Password, signupModel.password)

        var insertedSignup = signupDatabase.insert(Signup_Table, null, contentValues)
        signupDatabase.close()
        return insertedSignup
    }

    fun isEmailExists(email: String): Boolean {
        val db = readableDatabase
        val columns = arrayOf(EMAIL)
        val selection = "$EMAIL = ?"
        val selectionArgs = arrayOf(email)

        val cursor: Cursor = db.query(Signup_Table, columns, selection, selectionArgs, null, null, null)
        val emailExists = cursor.moveToFirst()

        cursor.close()
        db.close()

        return emailExists
    }
    fun checkLoginCredentials(email: String, password: String): Boolean {
        val db = readableDatabase
        val columns = arrayOf(EMAIL, Password)
        val selection = "$EMAIL = ? AND $Password = ?"
        val selectionArgs = arrayOf(email, password)

        val cursor: Cursor = db.query(Signup_Table, columns, selection, selectionArgs, null, null, null)
        val isLoginSuccessful = cursor.moveToFirst()

        cursor.close()
        db.close()

        return isLoginSuccessful
    }
}