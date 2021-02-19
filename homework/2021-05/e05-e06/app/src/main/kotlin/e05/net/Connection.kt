package net

import io.readFile
import com.fasterxml.jackson.databind.ObjectMapper
import model.Person
import java.net.URL
import java.io.*;

fun fetchAndParse(id : Int, callback: (Person) -> Unit) {
    val objectMapper = ObjectMapper();
    val url : URL = URL("https://swapi.dev/api/people/$id/");
    Thread {
        val connection = url.openConnection()
        connection.setRequestProperty("Accept", "application/json");
        
        val input = BufferedReader(InputStreamReader(
                                    connection.getInputStream()));
        val person = objectMapper.readValue(connection.getInputStream(), Person::class.java)
        callback(person)
    }.start()
}