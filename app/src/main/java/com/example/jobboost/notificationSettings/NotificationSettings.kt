package com.example.jobboost.notificationSettings

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.jobboost.R
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import android.os.Message
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.RemoteViews
import android.widget.Switch
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.PackageManagerCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jobboost.ChatbotActivity
import com.example.jobboost.MainActivity
import com.example.jobboost.ReviewMain
import com.example.jobboost.SearchFilterActivity
import com.example.jobboost.StudentJobsActivity
import com.example.jobboost.StudentProfileActivity
import com.example.jobboost.Template_Main
import com.google.android.material.textfield.TextInputEditText

class NotificationSettings : AppCompatActivity() {
    var inputString = mutableListOf<String?>()
    //for notification
    lateinit var notificationManager: NotificationManager
    lateinit var notificationChannel: NotificationChannel
    private val channelId = "i.apps.notifications"
    private val description = "Test notification"
    lateinit var sharePref:SharedPreferences
    lateinit var editor:SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification_settings)
        sharePref = getSharedPreferences("JobFeilds", Context.MODE_PRIVATE)
        inputString = mutableListOf()
        editor = sharePref.edit()
        var storedFields = sharePref.getString("Feilds", null).toString()
        if(storedFields != null){
            storedFields = storedFields.substring(1, storedFields.length - 1)
            Log.i("Message", "stored Feilds formatted: $storedFields")
            var feildsArray = storedFields?.split(',') as MutableList
            for(str in feildsArray){
                inputString.add(str)
            }
        }


        //ask for notification permission
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
            if(ContextCompat.checkSelfPermission(this, android.Manifest.permission
                    .POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED){
                var permissionArray:Array<String> = arrayOf(android.Manifest.permission.POST_NOTIFICATIONS)
                ActivityCompat.requestPermissions(this, permissionArray, 101 )
            }
        }

        // This is how you tell the user that something has happened in the background.
        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        // pendingIntent is an intent for future use i.e after
        // the notification is clicked, this intent will come into action
        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_MUTABLE)

        var builder = Notification.Builder(applicationContext , channelId)
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentTitle("JobBoost")
            .setContentText("You will be recieving job notifications from now")
            .setAutoCancel(true)

        // start creating channels if android version is > oreo (API 26)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationChannel = NotificationChannel(channelId, description, NotificationManager.IMPORTANCE_HIGH)
            notificationChannel.enableLights(true)
            notificationChannel.lightColor = Color.GREEN
            notificationChannel.enableVibration(false)
            notificationManager.createNotificationChannel(notificationChannel)
        }

        var adapter = MyAdapter(inputString, this)
        updateUserJobFieldsAfterClickingButton(adapter)
        var recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        var switch = findViewById<Switch>(R.id.notificationToogler)
        var view = findViewById<View>(R.id.toogleOnArea)

        if(!switch.isChecked){
            view.visibility = View.GONE
        }
        switch.setOnClickListener{

            if(!switch.isChecked){

                view.visibility = View.GONE
            }
            else{
                view.visibility = View.VISIBLE
                notificationManager.notify(1234, builder.build())


            }
        }

    }

    private fun updateUserJobFieldsAfterClickingButton(adapter: MyAdapter) {
        var button = findViewById<Button>(R.id.submit)
        button.setOnClickListener {
            var inputFeild = findViewById<TextInputEditText>(R.id.input)
            if(inputFeild.text != null){
                var inputSplit = inputFeild.text.toString().split(',')
                //add the word for feilds to notify if it is not already present
                for(string in inputSplit){
                    if(!this.inputString.contains(string)){
                        this.inputString.add(string)
                        adapter.notifyItemInserted(this.inputString.lastIndex)
                    }
                }

                editor.apply {
                    putString("Feilds", inputSplit.toString())
                    Log.i("Message", "The list values to str:${inputSplit.toString()} ")
                    apply()
                }

            }


        }
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