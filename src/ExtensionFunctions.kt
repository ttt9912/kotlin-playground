package strings

/**
 * # Extension function
 *
 * # this
 * In the body of an extension function, you use `this? the same way
 * you would use it in a method. And as in a regular method, you can
 * omit `this` and call eg `get()` or `length` directly
 */
fun String.lastChar(): Char =
    this.get(this.length - 1)

fun main() {
    println("Kotlin".lastChar())
}