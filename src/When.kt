/**
 * `when` replaces `switch`.
 * No `break;` is required, only the matching branch is executed
 *
 * `when` is an expression, so it can be returned
 * directly by a function
 */
fun getWarmthFromSensor(color: Color) =
    when (color) {
        Color.RED, Color.ORANGE, Color.YELLOW -> "warm (${color.name})" // combining options
        Color.BLUE, Color.INDIGO, Color.VIOLET -> "cold (${color.name})"
        Color.GREEN -> "neutral (${color.name})"
    }

/**
 * Capturing the subject [1] of a `when`
 */
fun getRandomColor(): Color = Color.ORANGE
fun getWarmthFromSensor2() =
    when (val color = getRandomColor()) { // [1]
        Color.RED, Color.ORANGE, Color.YELLOW -> "warm (${color.name})"
        Color.BLUE, Color.INDIGO, Color.VIOLET -> "cold (${color.name})"
        Color.GREEN -> "neutral (${color.name})"
    }

/**
 * Using `when` with arbitrary objects
 */
fun mix(c1: Color, c2: Color) =
    when (setOf(c1, c2)) {
        setOf(Color.RED, Color.YELLOW) -> Color.ORANGE
        setOf(Color.YELLOW, Color.BLUE) -> Color.GREEN
        setOf(Color.BLUE, Color.VIOLET) -> Color.INDIGO
        else -> throw Exception("Dirty color")
    }

/**
 * Using `when` without arguments
 *
 * Note: above, a Set instance is created for each call. Normally,
 * this isn’t an issue, but if the function is called often, it’s
 * worth avoid creating many short-lived objects, which need to
 * be cleaned up by the garbage collector.
 */
fun mixOptimized(c1: Color, c2: Color)=
    when {
        (c1 == Color.RED && c2 == Color.YELLOW) ||
                (c1 == Color.YELLOW && c2 == Color.RED) -> Color.ORANGE
        // ...
        else -> throw Exception("Dirty color")
    }

fun main() {
    println(getWarmthFromSensor(Color.BLUE))
    println(getWarmthFromSensor2())
    println(mix(Color.BLUE, Color.YELLOW))
}
