package com.example.isitpalindrome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    private val TAG = "SecondActivity"
    private lateinit var txt : TextView
    private lateinit var phoneEdit : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        // val intent = getIntent()     // I don't think this is needed?
        val pal = intent.getStringExtra(PAL_MSG) ?: ""
        Log.d(TAG, pal)
        this.txt = findViewById(R.id.textView2)
        txt.text = pal
        this.phoneEdit = findViewById(R.id.phone_input)
    }
    override fun onBackPressed() {
        Log.d(TAG, "Back pressed!")
        val intent = Intent()
        intent.putExtra("name", phoneEdit.text.toString())
        setResult(RESULT_OK, intent);

        super.onBackPressed()
    }
}