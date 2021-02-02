/**
 * @author Viljami Pietarila
 */
fun main() {
    println(MyMath.abs(-4))

    Test.fly() {
        println("kotlin flies")
    }

    for (i in 1..2) {
        Thread(Runnable({
            for (n in 1..5) {
                println(java.lang.Thread.currentThread().name + " $n")
                Thread.sleep(500)
            }
        })).start()
    }
}
