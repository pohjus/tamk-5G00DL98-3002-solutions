package com.example.e01_e08

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.databind.ObjectMapper
import java.io.BufferedReader
import java.io.FileWriter
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import kotlin.concurrent.thread
import org.json.*
import kotlin.math.round
import kotlin.math.roundToInt


class MainActivity : AppCompatActivity() {
    lateinit var text : TextView
    lateinit var listView : ListView
    lateinit var adapter : ArrayAdapter<Person>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //text = findViewById(R.id.TextView)
        this.listView = findViewById(R.id.listView)

        adapter = ArrayAdapter<Person>(this, R.layout.item,
            R.id.myTextView, ArrayList<Person>());
        listView.adapter = adapter;
    }
    override fun onResume() {
        super.onResume()

        // e06
        downloadUrlAsync(this, "https://swapi.dev/api/people/") {
            val mp = ObjectMapper()
            val myObject: Person.StarWarsJsonObject = mp.readValue(it, Person.StarWarsJsonObject::class.java)
            val persons: MutableList<Person>? = myObject.results
            persons?.forEach { person ->
                println(person)
                adapter.add(person)
            }
            adapter.sort { person, person2 -> person2.bmi.compareTo(person.bmi) }
        }
//        thread() {
//
//            val jsonStr = getUrl("https://swapi.dev/api/people/")
//            println(jsonStr)
//
//            if (jsonStr != null) {
//                // org.json
//                val jsonObject = JSONObject(jsonStr)
//                val jsonArray = jsonObject.getJSONArray("results")
//                val name = jsonArray.getJSONObject(0).getString("name")
//                runOnUiThread {
//                    //text.text = name
//                }
//
//                // jackson
//                val mp = ObjectMapper()
//                val myObject: StarWarsJsonObject = mp.readValue(jsonStr, StarWarsJsonObject::class.java)
//                val persons: MutableList<Person>? = myObject.results
//                persons?.forEach {
//                    println(it)
//                    runOnUiThread {
//                        adapter.add(it)
//                    }
//                }
//            }
//        }

    }

    fun downloadUrlAsync(context: Activity, url: String, callback: (String) -> Unit) {
        thread {
            val jsonStr = getUrl(url)
            if (jsonStr != null) {
                context.runOnUiThread {   // is this what I was supposed to do with the context?
                    callback(jsonStr)
                }
            }
        }
    }


    fun getUrl(urlStr: String) : String? {
        val url = URL(urlStr)
        val conn = url.openConnection() as HttpURLConnection
        val reader = BufferedReader(InputStreamReader(conn.inputStream))

        val sb = StringBuilder()
        reader.use() {
            var line : String? = reader.readLine()
            while(line != null) {
                sb.append(line)
                line = reader.readLine()
            }
        }
        return sb.toString()


    }
}


@JsonIgnoreProperties(ignoreUnknown = true)
data class Person(var name: String? = null, var mass: Int = 0, var height: Int = 0) {

//    private var bmi : Double = getBMI()
    private var _bmi : Int = 0

    var bmi : Int = _bmi
        get() {return getBMI() }

    private fun getBMI() : Int {
        println(mass)
        println(height)
        val heightMeters : Double = height/100.0
        println(heightMeters)
        if (heightMeters <= 0 || mass <= 0)
            return 0
        val bmiDouble = mass/(heightMeters*heightMeters)
        return bmiDouble.roundToInt()
    }

    override fun toString() : String {
        return "name = $name, bmi = ${getBMI()}"
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    data class StarWarsJsonObject(var results: MutableList<Person>? = null)
}


