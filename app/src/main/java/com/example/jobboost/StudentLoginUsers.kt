package com.example.jobboost

import android.content.Context
import android.content.SharedPreferences

class StudentLoginUsers(context: Context) {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)

    companion object {
        const val USER_EMAIL_KEY = "user_email"
    }

    fun saveEmail(email: String) {
        val editor = sharedPreferences.edit()
        editor.putString(USER_EMAIL_KEY, email)
        editor.apply()
    }

    fun getEmail(): String? {
        return sharedPreferences.getString(USER_EMAIL_KEY, null)
    }

    fun clearEmail() {
        val editor = sharedPreferences.edit()
        editor.remove(USER_EMAIL_KEY)
        editor.apply()
    }
}