/**
 * Parse a path using Kotlin string extension
 * functions
 *
 * Goal: split a file path into
 * - directory
 * - fullname
 * - filename
 * - extension
 */
private val PATH = "/Users/yole/kotlin-book/chapter.adoc"

fun main(path: String) {
    val directory = PATH.substringBeforeLast("/")
    val fullName = PATH.substringAfterLast("/")
    val fileName = fullName.substringBeforeLast(".")
    val extension = fullName.substringAfterLast(".")

    println("Directory: $directory")
    println("Full filename: $fileName")
    println("Filename: $fileName")
    println("Extension: $extension")
}
