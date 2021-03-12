package com.example.e08_e09

import android.app.Service
import android.app.Service.START_STICKY
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.media.AudioAttributes
import android.media.MediaPlayer
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import java.lang.Exception
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    lateinit var startbtn : Button
    lateinit var stopbtn : Button
    lateinit var editText: EditText

    private lateinit var receiver : MyReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.startbtn = findViewById(R.id.startbtn)
        this.stopbtn = findViewById(R.id.stopbtn)
        this.stopbtn.isEnabled = false
        this.editText = findViewById(R.id.url)
        this.editText.setText(
                //"https://upload.wikimedia.org/wikipedia/commons/b/b2/Bernard_de_La_Monnoye_-_Patapan.ogg",
                "https://upload.wikimedia.org/wikipedia/commons/e/ea/Voiceless_alveolar_lateral_fricative.ogg",
                TextView.BufferType.EDITABLE)

        this.receiver = MyReceiver()
    }

    override fun onResume() {
        super.onResume()
        registerReceiver(receiver, IntentFilter("e08-e09.play"))
    }
    override fun onPause() {
        super.onPause()
        unregisterReceiver(receiver)
    }

    fun start(button: View) {
        Log.d("exercise", editText.text.toString())
        val intent = Intent(this, MusicService::class.java)
        intent.putExtra("url", editText.text.toString())
        startService(intent)
    }
    fun stop(button: View) {
        stopService(Intent(this, MusicService::class.java))
    }

    inner class MyReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            val state : String? = intent?.getStringExtra("state")
            if (state != null) {
                Log.d("exercise", state)
                if (state == "start") {
                    // disable start, enable stop
                    startbtn.isEnabled = false
                    stopbtn.isEnabled = true
                }
                else if (state == "stop") {
                    // enable start, disable stop
                    startbtn.isEnabled = true
                    stopbtn.isEnabled = false

                }
                else if (state == "error") {
                    Toast.makeText(this@MainActivity, "Not found", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

}

class MusicService : Service() {
    lateinit var mediaPlayer : MediaPlayer

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d("exercise", "onStartCommand")
        val url = intent?.getStringExtra("url")
        Log.d("exercise", intent?.extras.toString())

        if (url != null) {
            thread {
                try {
                    if (this::mediaPlayer.isInitialized)
                        mediaPlayer.stop()
                    mediaPlayer = MediaPlayer().apply {
                        setAudioAttributes(
                                AudioAttributes.Builder()
                                        .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                                        .setUsage(AudioAttributes.USAGE_MEDIA)
                                        .build()
                        )
                        setDataSource(url)

                        var intent = Intent("e08-e09.play")
                        intent.putExtra("state", "start")
                        sendBroadcast(intent)

                        prepare()
                        start()
                    }
                    mediaPlayer.setOnCompletionListener {
                        var intent = Intent("e08-e09.play")
                        intent.putExtra("state", "stop")
                        sendBroadcast(intent)
                    }
                }
                catch (e: Exception) {
                    Log.d("exercise", "failed to play")
                    var intent = Intent("e08-e09.play")
                    intent.putExtra("state", "error")
                    sendBroadcast(intent)
                }
            }
        }
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("exercise", "stopping...")
        if (this::mediaPlayer.isInitialized)
            mediaPlayer.stop()
        var intent = Intent("e08-e09.play")
        intent.putExtra("state", "stop")
        sendBroadcast(intent)
    }
}