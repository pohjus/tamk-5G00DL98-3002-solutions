/**
 * @author Viljami Pietarila
 */
class Circle (var radius: Int, var color: String?) {
    constructor(radius: Int) : this(radius, null)
    
    fun printSurfaceArea() {
        println (radius * radius * Math.PI)
    }

    fun attributesToString() : String {
        var attributes = "radius = $radius"
        if (color != null) attributes += ", color = $color"
        return attributes
    }
}

fun main() {
    val c = Circle(radius = 5, color = "red")
    println(c.radius)
    c.printSurfaceArea()
    println(c.attributesToString())

    val d = Circle(radius = 6)
    println(d.radius)
    d.printSurfaceArea()
    println(d.attributesToString())
}
