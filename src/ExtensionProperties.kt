import java.lang.StringBuilder

/**
 * Extension property
 * - immutable
 */
val String.lastChar: Char
    get() = this.get(length - 1)

/**
 * Mutable extension property
 * - cannot store any state
 */
var StringBuilder.lastChar: Char
    get() = this.get(length - 1)
    set(value) {
        this.setCharAt(length - 1, value)
    }

fun main() {
    println("Kotlin".lastChar)

    val sb = StringBuilder("Kotlin?")
    println(sb.lastChar)
    sb.lastChar = '!'
    println(sb)
}