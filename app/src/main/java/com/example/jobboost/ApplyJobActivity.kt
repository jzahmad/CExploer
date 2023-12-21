package com.example.jobboost

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.example.jobboost.notificationSettings.NotificationSettings

/*
    This file is responsible for handling the logic of redirecting the user to web page to apply for job
 */
class ApplyJobActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apply_job)

        //Web view initialized
        val webView: WebView = findViewById(R.id.webView)
        webView.webViewClient = MyWebViewClient()
        webView.webChromeClient = WebChromeClient()

        //User directed to following url to apply for job
        val url = "https://ca.indeed.com/viewjob?jk=a7b728790a756451&tk=1hg5vk7gujqt4800&from=serp&vjs=3"
        webView.loadUrl(url)
    }

    //This function will initialize the web client
    private inner class MyWebViewClient : WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView, request: WebResourceRequest): Boolean {
            view.loadUrl(request.url.toString())
            return true
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