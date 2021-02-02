/**
 * @author Viljami Pietarila
 * @author Jussi Pohjolainen
 */
open class Person(var name: String) {
    open fun drink() {
        println("$name drinks water")
    }

    fun sleep() {
        println("$name sleeps")
    }

    override fun toString() : String {
        return("name = $name")
    }
}

class Programmer(name: String, salary: Int) : Person(name) {
    var salary: Int = 0
        get() = field
        set(value) {
            if (value < 0) throw IllegalArgumentException("salary must be > 0.")
            else field = value
        }

    init {
        this.salary = salary
    }

    override fun drink() {
        println("$name drinks energy drink")
    }

    fun codeApps() {
        println("$name codes apps")
    }

    // Pohjolainen: added toString
    override fun toString() : String {
        return super.toString() + " salary = $salary"
    }
}

fun main() {
    val tina = Programmer("tina", 4000)
    // outputs "tina drinks energy drink"
    tina.drink()
    // "tina sleeps"
    tina.sleep()
    // "tina code apps"
    tina.codeApps()
    // "name = tina, salary = 4000"
    println(tina.toString())

    tina.salary = -2

    val jack = Person("jack")
    // "jack drinks water"
    jack.drink()
    // "jack sleeps"
    jack.sleep()
    // "name = jack"
    println(jack.toString())
}
