/**
 * Parse path end destructure into variables
 *
 * Regex is created usin `.toRegex()`
 */

private val PATH = "/Users/yole/kotlin-book/chapter.adoc"

fun main() {
    val regex = """(.+)/(.+)\.(.+)""".toRegex()
    val matchResult = regex.matchEntire(PATH)
    if (matchResult != null) {
        val (directory, filename, extension) = matchResult.destructured

        println("Directory: $directory")
        println("Filename: $filename")
        println("Extension: $extension")
    }
}