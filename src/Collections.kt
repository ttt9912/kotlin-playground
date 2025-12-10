/**
 * Initialization
 */
val set = setOf(1, 7, 53)
val list = listOf(1, 7, 53)
val map = mapOf(
    1 to "one",
    7 to "seven",
    53 to "fifty-three"
)

fun main() {
    /**
     * Collection classes
     */
    println(set.javaClass) // class java.util.LinkedHashSet
    println(list.javaClass) // class java.util.Arrays$ArrayList
    println(map.javaClass) // class java.util.LinkedHashMap

    println("----")

    /**
     * Collection operations
     */
    val strings = listOf("first", "second", "fourteenth")
    println(strings.last())
    println(strings.shuffled())
    val numbers = setOf(1, 14, 2)
    println(numbers.sum())
}

