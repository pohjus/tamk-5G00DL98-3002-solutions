fun Array<String>.checkIfValidLottoNumbers() : Set<Int>? {
    // Check that exactly 7 numbers are given
    val amount = this.size == 7
    
    // Check that unique values are given
    val unique = this.distinct().size == this.size
    var numbers : Boolean

    var lottoList : List<Int>? = null
    try {
        lottoList = this.map() { it.toInt() }
        numbers = lottoList.all() { it >= 1 && it <= 40 } 
    } catch(e: NumberFormatException) {
        numbers = false;
    }
    return if(amount && unique && numbers && lottoList != null) lottoList.toSortedSet() else null
}

fun Set<Int>.howMany(randomLotto : Set<Int>) : Int = this.intersect(randomLotto).size

fun Set<Int>.addPadding(padding: Int) : String {
    return this.map() {
        it.toString().padStart(padding, '0')
    }.toString()
}

fun generateRandomLotto() : Set<Int> {
    var lotto = sortedSetOf<Int>()
    while(lotto.size < 7) {
        lotto.add((1..40).random())
    }
    return lotto
}

fun main(args: Array<String>) {
    // Checks user given arguments. Must be 7 unique numbers between 1 - 40.
    // Returns either sorted Set<Int> or null
    val userLotto : Set<Int>? = args.checkIfValidLottoNumbers()
    var bestOf = 0
    var weeks = 0
    // If user given arguments were valid
    if(userLotto != null) {
        var continueCalculation = true
        
        // Calculate lotto until jackpot
        while(continueCalculation) {
            // Generates random lotto, contains 7 unique numbers between 1 - 40 and 
            // values are sorted
            val randomLotto : Set<Int> = generateRandomLotto()
            
            // Counts how many user got right, returns 0 - 7. (7 => jackpot)
            val many : Int = userLotto.howMany(randomLotto)
            
            // Outputs numbers with leading 0: [06, 07, 11, 14, 27, 29, 36] 
            // padding 2 => 01
            // padding 3 => 001
            println( userLotto.addPadding(2) )
            println( randomLotto.addPadding(2) + " - correct = ${many}")

            if(many > bestOf) {
                bestOf = many
                println("You got $bestOf correct, it took ${weeks/52.0} years!")
            }
            weeks++
            continueCalculation = many < 7
        }
    } else {
        println("Please give valid input. Give seven unique numbers between 1 - 40.")
    }
}