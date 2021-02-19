package e05

import io.readFile
import net.fetchAndParse
import com.fasterxml.jackson.databind.ObjectMapper
import model.*

fun main(args: Array<String>) {
    /* 05 */
    val objectMapper = ObjectMapper();

    readFile("file.json", "utf-8") {
        val person = objectMapper.readValue(it, Person::class.java);
        println(person.name)
        println(person.bmi)
    } 

    /* 06 */
    if(args.size > 0) {
        fetchAndParse(args[0].toInt()) {
            println(it.name)
            println(it.bmi)
        }
    }
}
