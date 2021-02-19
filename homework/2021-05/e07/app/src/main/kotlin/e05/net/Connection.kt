package net

import io.readFile
import com.fasterxml.jackson.databind.ObjectMapper
import model.*
import java.net.URL
import java.io.*;
import javax.swing.SwingUtilities

fun fetchAndParse(id : Int, callback: (Person) -> Unit) {
    val objectMapper = ObjectMapper();
    val url : URL = URL("https://swapi.dev/api/people/$id/");
    Thread {
        val connection = url.openConnection()
        connection.setRequestProperty("Accept", "application/json");
        
        val person = objectMapper.readValue(connection.getInputStream(), Person::class.java)
        callback(person)
    }.start()
}

fun fetchAndParseAll(callback: (MutableList<Person>?) -> Unit) {
    val objectMapper = ObjectMapper();
    val url : URL = URL("https://swapi.dev/api/people/");
    Thread {
        val connection = url.openConnection()
        connection.setRequestProperty("Accept", "application/json");
        val people = objectMapper.readValue(connection.getInputStream(), People::class.java)
        SwingUtilities.invokeLater() {
            callback(people.results)
        }
    }.start()
}
