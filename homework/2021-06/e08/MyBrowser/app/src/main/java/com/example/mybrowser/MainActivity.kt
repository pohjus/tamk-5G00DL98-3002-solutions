package com.example.mybrowser

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.WebView

class MainActivity : AppCompatActivity() {
    private val tag = "MyBrowser.MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val webView = findViewById<WebView>(R.id.myWebView);
        webView.settings.javaScriptEnabled = true
        webView.settings.builtInZoomControls = true

        val url : Uri? = this.intent.data
        if (url != null) {
            Log.d(tag, url.toString())
            webView.loadUrl(url.toString())
        }
    }
}