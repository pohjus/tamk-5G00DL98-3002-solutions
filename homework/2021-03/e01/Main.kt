
fun generateRandomBoolean() = (0..1).random() == 0 

class Person {
    val computer : Computer? = if (generateRandomBoolean()) Computer() else null
}

class Computer { 
    val display : Display? = if (generateRandomBoolean()) Display() else null
}

class Display {
    val usbc : UsbC? = if (generateRandomBoolean()) UsbC() else null
}

class UsbC {
    val speed = if (generateRandomBoolean()) 20 else 40
}

fun main() {
    val jack = Person()

    // A
    if(jack.computer != null) {
        if(jack.computer.display != null) {
            if(jack.computer.display.usbc != null) {
                print(jack.computer.display.usbc.speed)
            }
        }
    }
    // B
    println(jack.computer?.display?.usbc?.speed)

    // D
    println(jack.computer?.display?.usbc?.speed ?: "could not fetch the speed")
    
    // C (crashes the app!)
    println(jack.computer!!.display!!.usbc!!.speed)
}