import java.time.*;

fun main() {
    val mydate = LocalDate.now()
    val month = mydate.getMonthValue()
    val numberOfDays = when(month) {
        1,3,5,7,8,10,12 -> 31
        2 -> if(mydate.isLeapYear()) 29 else 28
        4,6,9,11 -> 30
        else -> "unknown"
    } 
    print(numberOfDays)
}