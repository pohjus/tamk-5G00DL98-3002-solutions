import java.nio.charset.Charset
import java.nio.file.Paths
import java.nio.file.Files
import java.nio.file.StandardOpenOption
import java.io.IOException

fun readFile(path : String, encoding : String, callback: (String) -> Unit) {
    Thread() {
        val content = Files.readString(Paths.get(path), Charset.forName(encoding))
        callback(content)
    }.start()
}

fun saveFile(path : String, content: String, encoding : String, callback: (success: Boolean) -> Unit) {
    Thread() {
        // Create a new file, failing if the file already exists.
        try {
            Files.writeString(Paths.get(path), content, Charset.forName(encoding), StandardOpenOption.CREATE_NEW)
            callback(true)
        } catch(e: IOException) {
            e.printStackTrace()
            callback(false)
        }
    }.start()
}

fun main(args: Array<String>) {
    println("A")
    if(args.size > 1) {
        readFile(args[0], "utf-8") {
            saveFile(args[1], it, "utf-8") {
                println(if(it) "success" else "problem")
            }
        }
    }
    println("B")
}