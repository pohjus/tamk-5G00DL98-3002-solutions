/**
 * @author Viljami Pietarila
 * @author Jussi Pohjolainen
 */

interface Drawable {
    fun draw()
}

data class Rectangle(var width: Int, var height: Int) : Drawable {
    override fun draw() {
        for (y in 1..height) {
            println("X".repeat(width))
        }
        println()
    }
}

data class RectTriangle(var height: Int) : Drawable {
    override fun draw() {
        for (y in 1..height) {
            println("X".repeat(y))
        }
        println()
    }
}


fun main() {
    val drawables : MutableList<Drawable> = generateRandomArray(amount = 5)
    drawables.forEach() { it.draw() }
}

fun generateRandomArray(amount: Int) : MutableList<Drawable>{
    var list = mutableListOf<Drawable>()
    for (n in (1..amount)) {
        val shape = (1..2).random()
        when (shape) {
            1 -> list.add(RectTriangle((3..5).random()))
            2 -> list.add(Rectangle((3..5).random(), (3..5).random()))
        }
    }
    return list
}
