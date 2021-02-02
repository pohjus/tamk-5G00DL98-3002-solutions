/**
 * @author Jussi Pohjolainen
 */

class Person(var name : String, var age : Int)


data class DataPerson(var name : String, var age : Int)


fun validate(args: Array<String>) : Int? {
    if(args.size > 0) {
        val number = args[0].toIntOrNull()
        return if(number != null && number > 0) number else null
    }
    return null
}

fun main(args : Array<String>) {
    val jack1 = Person("jack", 30)
    val jack2 = Person("jack", 30)

    // outputs ClassName@Hashcode
    println(jack1.toString()) 
    
    // outputs false because it is comparing memory addresses
    println(jack1.equals(jack2))

    val tina1 = DataPerson("tina", 30)
    val tina2 = DataPerson("tina", 30)

    // outputs 
    println(tina1.toString()) 

    // outputs true, compares members of the objects
    println(tina1.equals(tina2))

    // copies the object
    val tina3 = tina2.copy()
    println(tina3.toString())

    val amount = validate(args)
    if(amount != null) {
        val list1 = mutableListOf<Person>()
        val list2 = mutableListOf<DataPerson>()

        for(i in 0..amount) {
            val name = listOf("tina", "hannah", "jack").random()
            val age = (1..100).random()

            list1.add(Person(name, age))
            list2.add(DataPerson(name, age))
        }

        list1.distinct().forEach() {
            println(it.name)
        }
        println("-------")
        list2.distinct().forEach() {
            println(it.name)
        }

    }

}