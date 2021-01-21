
import java.nio.file.Files
import java.nio.charset.StandardCharsets
import java.nio.file.Paths

fun main(arguments: Array<String>) {
    arguments.forEach() {
        println(it)
        println("------")
        var list : kotlin.collections.List<String> = Files.readAllLines(Paths.get(it))
        list.filter() { it.contains("\t") }
            .map() { it.replace("\t", "____") }
            .forEach() { println(it) }
    }
}