/**
 * Safety means:
 * Kotlin tries to avoid NullPointerException at compile time.
 * --> println(s.length) won't compile
 */
var s: String? = null
var s2: String = "Hello"

fun main() {
    println(s?.length) // null
    println(s2.length) // 5
}