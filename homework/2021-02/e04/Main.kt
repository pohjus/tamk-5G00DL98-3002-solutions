
fun main() {
    val myString : String? = readLine()
    val myValue : Int? = readLine()?.toIntOrNull()

    if(myValue != null) {
        val amount : Int = myValue
        for(i in 1..amount) {
            print(myString)
        }
    }
}