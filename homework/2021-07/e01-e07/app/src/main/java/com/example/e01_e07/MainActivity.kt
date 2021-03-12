package com.example.e01_e07

import android.app.Service
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.Intent.ACTION_TIME_TICK
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    lateinit var  btn : Button
    private lateinit var receiver : MyBroadCastReceiver
    private lateinit var receiver2 : MyBroadCastReceiver2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.btn = findViewById(R.id.button)
        this.receiver = MyBroadCastReceiver()
        this.receiver2 = MyBroadCastReceiver2()
    }

    // e01
    fun click(button: View) {
        Log.d("exercise", "button clicked")
        Log.d("exercise", Thread.currentThread().name)

        // e03
        startService(Intent(this, MyBackgroundService::class.java))

        /*
        thread {
            Log.d("exercise", Thread.currentThread().name)

            for (i in 1..10) {
                Log.d("exercise", i.toString())
                // e02
                runOnUiThread() {
                    btn.text = i.toString()
                }
                Thread.sleep(1000)
            }
        }
         */
    }

    // e03
    fun stop(button: View) {
        stopService(Intent(this, MyBackgroundService::class.java))
    }

    // e06
    override fun onResume() {
        super.onResume()
        registerReceiver(receiver, IntentFilter(ACTION_TIME_TICK))
        // e07
        registerReceiver(receiver2, IntentFilter("fi.tuni.tamk.test"))
    }
    override fun onPause() {
        super.onPause()
        unregisterReceiver(receiver)
        unregisterReceiver(receiver2)
    }

    // e07
    inner class MyBroadCastReceiver2 : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            Log.d("exercise-receiver2", Thread.currentThread().name)
            val i : Int? = intent?.getIntExtra("i", -1)
            if (i != null && i > -1) {
                val btnTxt : String = "i = $i"
                Log.d("exercise-receiver2", btnTxt)
                btn.text = btnTxt
            }
        }
    }
}

// e03
class MyBackgroundService : Service() {
    private var running : Boolean = false

    // We are not using binded service, service can only be started and stopped
    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d("exercise", "service started")

        // e04
        running = true
        thread {
            var i : Int = 0
            while (running) {
                Log.d("TAG", Thread.currentThread().name)
                i++
                Log.d("exercise", i.toString())
                Thread.sleep(1000)
                // e07
                var intent = Intent("fi.tuni.tamk.test")
                intent.putExtra("i", i)
                sendBroadcast(intent)
            }
        }

        // If service is killed by android, it will try to start it again when
        // possible
        return START_STICKY
    }

    override fun onDestroy() {
        running = false
        Log.d("exercise", "service stopped")
    }

}


// e05
class MyBroadCastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(context, "Time Changed", Toast.LENGTH_SHORT).show()
        Log.d("MyBroadCastReceiver", "Time Changed")
    }
}