package com.example.isitpalindrome

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

const val PAL_MSG = "com.example.isitpalindrome.MESSAGE"

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private val SECOND_ACTIVITY_CODE = 10

    private lateinit var editText : EditText
    private lateinit var palindromeButton : Button
    private lateinit var textView : TextView
    private lateinit var phoneView : TextView
    private lateinit var callButton : Button
    private var startTime : String? = ""

    // e02
    fun EditText.addMyKeyListener(callback: (String) -> Unit) {
        this.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(
                s: CharSequence, start: Int,
                before: Int, count: Int
            ) {
                callback(s.toString())
            }
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate()")

        this.editText = findViewById(R.id.isPalindromeEditText)
        this.palindromeButton = findViewById(R.id.palindrome_button)
        this.textView = findViewById(R.id.answer_view)
        this.phoneView = findViewById(R.id.phone_view)

        this.editText.addMyKeyListener {
            textView.text = if(it.isPalindrome()) "YES" else "NO"
        }

        this.callButton = findViewById(R.id.call_button)

        // e07
        if (savedInstanceState == null) {
            val c = Calendar.getInstance()
            val sdf = SimpleDateFormat("HH:mm:ss")
            startTime = sdf.format(c.time)
        }
        supportActionBar?.title = "IsItPalindrome $startTime"
    }
    // e07
    override fun onSaveInstanceState(outState: Bundle) {
        Log.d(TAG, "onSaveInstanceState()")
        outState.putString("appTitle", startTime)
        super.onSaveInstanceState(outState)
    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d(TAG, "onRestoreInstanceState()")
        startTime = savedInstanceState.getString("appTitle")
        if (startTime != null)
            supportActionBar?.title = "IsItPalindrome $startTime"
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart()")
    }
    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume()")
    }
    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause()")
    }
    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop()")
    }
    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart()")
    }
    override fun onDestroy() {
        Log.d(TAG, "onDestroy()")
        super.onDestroy()
    }

    // e05
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == SECOND_ACTIVITY_CODE) {
            val value = data?.extras?.getString("name")

            if (value != null) {
                phoneView.text = value
                Log.d(TAG, value)
            }
            else {
                Log.d(TAG, "Fail")
            }

        }

    }


    // Original function made for e02
    private fun isPalindrome(str: String) : String {
        val strLower = str.toLowerCase()
        return if (strLower == strLower.reversed())
            "YES"
        else
            "NO"
    }

    // e02 edition
    fun String.isPalindrome() : Boolean {
        var str = this.toLowerCase()
        return str == str.reversed()
    }

    // Palindrome button clicked
    fun clicked(button: View) {
        Log.d(TAG, "click")
        // textView.text = isPalindrome(editText.text.toString())
        textView.text = if(editText.text.toString().isPalindrome()) "YES" else "NO"

        // e04
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra(PAL_MSG, textView.text.toString())
        // startActivity(intent)
        // e05
        startActivityForResult(intent, SECOND_ACTIVITY_CODE)
    }

    // Call button clicked
    fun called(button: View) {
        val strNum = "tel:" + phoneView.text.toString()
        val intent = Intent(Intent.ACTION_DIAL, Uri.parse(strNum))
        startActivity(intent)
    }
}