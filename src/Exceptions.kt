/**
 * `throw` is an expression
 */
fun calculateSomething(number: Number) {
    val percentage =
        if (number in 0..100)
            number
        else
            throw IllegalArgumentException("A percentage value must be between 0 and 100: $number")

    println("Percentage: $percentage%")
}

fun main() {
    calculateSomething(99)
    calculateSomething(101)

}