package io
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
