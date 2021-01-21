
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
fun validate(args: Array<String>) : Int? {
    val number : Int? = if(args.size > 0) args[0].toIntOrNull() else null
    return if (number != null && number > 0) number else null
}
fun createList(amount: Int) : MutableList<Person> {
    val list = mutableListOf<Person>()
    for(i in 0..amount) {
        list.add(Person())
    }
    return list
}
fun output(list: MutableList<Person>) {
    list.forEach {
        println(it.computer?.display?.usbc?.speed ?: "could not fetch the speed")
    }
}
fun main(args: Array<String>) {
    val numberOfPersons : Int? = validate(args)
    
    if(numberOfPersons != null) {
        val listOfPersons : MutableList<Person> = createList(numberOfPersons)
        output(listOfPersons)
    } else {
        println("please give integer > 0")
    }
}