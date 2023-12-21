package com.example.jobboost

import android.content.Intent
import android.net.http.SslError
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.webkit.*
import com.example.jobboost.notificationSettings.NotificationSettings

class ChatbotActivity : AppCompatActivity() {

    /**
     * This method initializes the application's ChatbotActivity page when it is
     * being loaded by the application.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        /*Call the AppCompatActivity's onCreate() method to ensure that this activity gets
        initialized properly.*/
        super.onCreate(savedInstanceState)

        /*Set this activity's UI layout using the XML layout file associated with it (i.e.,
        activity_chatbot.xml).*/
        setContentView(R.layout.activity_chatbot)

        /*Get this activity's WebView.*/
        var chatbotWebView: WebView = findViewById(R.id.chatbotWebView)

        /*Configure this activity's WebView settings to enable JavaScript and DOM Storage in case
        the ChatGPT website requires that to function properly considering that many websites do
        require that.*/
        chatbotWebView.settings.javaScriptEnabled = true
        chatbotWebView.settings.domStorageEnabled = true

        /*Override this activity's WebView client to handle any errors that occur while loading
        ChatGPT.*/
        chatbotWebView.webViewClient = object : WebViewClient() {
            override fun onReceivedSslError(view: WebView, handler: SslErrorHandler, error: SslError) {
                handler.proceed()
            }

            override fun onReceivedError(view: WebView, request: WebResourceRequest, error: WebResourceError) {
            }

            override fun onReceivedHttpError(view: WebView, request: WebResourceRequest, errorResponse: WebResourceResponse) {
            }
        }

        /*Load the ChatGPT website's login/signup page.*/
        chatbotWebView.loadUrl("https://chat.openai.com/")
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