
fun main() {
    println("Give String")
    val original : String? = readLine()
    if(original != null) {
        val originalString : String = original
        var reversedString : String = ""
        val amount = originalString.length - 1

        for(i in amount downTo 0) {
            reversedString += originalString[i]
        }
        val result = if(originalString == reversedString) "palindrome" else "Not palindrome"
        println(result)
    }
}