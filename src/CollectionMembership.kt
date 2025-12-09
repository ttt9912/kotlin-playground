/**
 * Check range membership using `in`
 */
fun isInRange(c: Char) =
    c in 'a'..'z' || c in 'A'..'Z'

fun isNotInRange(c: Char) =
    c !in '0'..'9'

/**
 * Check collection membership using `in`
 */
fun isInSet(s: String) =
    s in setOf("Java", "Scala", "Kotlin")

/**
 * Using `in` in `when` branches
 * See: `./When.kt`
 */


fun main() {
    println(isInRange('q'))
    println(isNotInRange('x'))
    println(isInSet("Kotlin"))
}