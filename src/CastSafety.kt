/**
 * Kotlin combines check and cast into a single operation.
 * Using `is`
 */
fun modify(value: Any) {
    if (value is String) {
        println(value.uppercase())
    }
}