// A
fun sum(a: Int, b: Int, result: (String) -> Unit) {
    result("result was = " + (a+b))
}

// B
fun isPositive(a: Int, success: () -> Unit, error: () -> Unit) {
    if(a > 0) {
        success()
    } else {
        error()
    }
}

fun main(args: Array<String>) {
    // A
    sum(4,5, { msg -> println(msg) })
    sum(4,5) { msg -> println(msg) }
    sum(4,5) { println(it) }

    // B
    isPositive(-5, { println("positive")}, { println("not positive") })
    isPositive(-5, { println("positive")}) { println("not positive") }

    // C
    args.filter() { 
        it.length <= 5 
    }.map() { 
        it.toUpperCase() 
    }.forEach() { 
        println(it) 
    }
}