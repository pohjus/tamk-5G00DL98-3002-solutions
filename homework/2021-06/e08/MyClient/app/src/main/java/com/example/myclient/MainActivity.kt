package com.example.myclient

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val tag = "MyClient.MainActivity"

    private lateinit var editText : EditText
    private lateinit var button : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.editText = findViewById(R.id.editText)
        this.button = findViewById(R.id.button)

    }

    fun search(button: View) {
        var uriString = editText.text.toString()
        if (uriString.isNotEmpty()) {
            try {
                // Add http if needed
                if (!uriString.startsWith("http")) {
                    uriString = "https://$uriString"
                }
                // Parse and attempt to open
                val uri: Uri = Uri.parse(uriString)
                Log.d(tag, uri.toString())

                startActivity(Intent(Intent.ACTION_VIEW, uri))

            }
            catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}