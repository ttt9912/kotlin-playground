/**
 * # While loop
 *
 * ```
 * while(condition){
 *     /*...*/
 *     if (shouldExit) break
 * }
 * ```
 *
 *
 * # Do-While loop
 *
 * ```
 * do {
 *     if (shouldSkip) continue
 *     /*...*/
 * } while (condition)
 * ```
 *
 *
 * # Labes
 *
 * ```
 * outer@ while (outerContition) {
 *     while (innerCondition) {
 *         if (shouldExitInner) break
 *         if (shouldSkipInner) continue
 *         if (shouldExit) break@outer
 *         if (shouldSkip) continue@outer
 *     }
 * }
 * ```
 */

/**
 * For loop
 */
fun iterateOverRanges() {
    for (i in 1..5)
        println("Number: $i")

    println("----")

    for (i in 10 downTo 1 step 2)
        println("Number: $i")
}

fun iterateOverList() {
    val colors = listOf("red", "blue", "green")

    for (color in colors)
        println(color)
}

fun iterateOverListWithIndex() {
    val colors = listOf("red", "blue", "green")

    for ((index, element) in colors.withIndex())
        println("$index: $element")
}

fun iterateOverMap() {
    val binaryReps = mutableMapOf<Char, String>()

    for (char in 'A'..'F') {
        val binary = char.code.toString(radix = 2)
        binaryReps[char] = binary
    }

    // for ((key, value) in map) ...
    for ((letter, binary) in binaryReps){
        println("$letter = $binary")
    }
}

fun main() {
    iterateOverRanges()
    println("----")
    iterateOverList()
    println("----")
    iterateOverListWithIndex()
    println("----")
    iterateOverMap()
}
