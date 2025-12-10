/**
 * Function to print a list formatted
 *
 * @JvmOverloads: will generate Java overloaded methods
 * when using default parameters in Kotlin. Will be easier
 * to use for Java programs
 *
 * This is a top-level function. It does not belong to a
 * class.
 *
 * It would make sense to define such a function as
 * **extension function**
 * eg. `fun <T> Collection<T>.joinToString(...
 */
@JvmOverloads
fun <T> joinToString(
    collection: Collection<T>,
    separator: String = ", ", // Default parameter
    prefix: String,
    postfix: String
): String {

    val result = StringBuilder(prefix)

    for ((index, element) in collection.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }

    result.append(postfix)
    return result.toString()
}

fun main() {
    val list = listOf(1, 2, 3)
    println(joinToString(list, "; ", "(", ")"))

    // Named arguments
    println(
        joinToString(
            postfix = ".",
            separator = " ",
            collection = list,
            prefix = " "
        )
    )
}