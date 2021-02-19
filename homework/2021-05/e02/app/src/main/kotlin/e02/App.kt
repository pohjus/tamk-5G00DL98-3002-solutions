/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package e02

fun String.isPalindrome(ignoreCase: Boolean = false, ignoreWhiteSpaces: Boolean = false)
 : Boolean {
   var original = this

   if (ignoreCase) {
      original = original.toLowerCase()
   }

   if(ignoreWhiteSpaces) {
       original = original.replace(Regex("\\s"), "")
   }
   
   return original == original.reversed()
}

fun main(args: Array<String>) {
    println("saippuakauppias".isPalindrome())
    println("saippuakauppiaS".isPalindrome(ignoreCase = true))
    println("sai\nppua\tkau  ppias".isPalindrome(ignoreWhiteSpaces = true))
    println("sai\nppua\tkau  ppiaS".isPalindrome(ignoreCase = true, ignoreWhiteSpaces = true))

}
