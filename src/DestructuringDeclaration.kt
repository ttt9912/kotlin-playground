fun main() {
    // Pair
    val (number, name) = 1 to "one"
    println("$number $name")

    println("----")

    // Key-value
    val collection = listOf("A", "B", "C")
    for ((index, element) in collection.withIndex()) {
        println("$index: $element")
    }
}