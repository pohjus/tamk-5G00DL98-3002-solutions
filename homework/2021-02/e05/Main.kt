fun giveStock(company: String) = when(company) {
    "Microsoft" -> "MSFT"
    "Apple" -> "APPL"
    "Nokia" -> "NOK"
    else -> null
}

fun main() {
    println("Give company")
    val company = readLine()
    if(company != null) {
        val result = giveStock(company)?.toLowerCase() ?: "no result"
        println(result)
    }
}