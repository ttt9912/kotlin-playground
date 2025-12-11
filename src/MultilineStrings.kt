/**
 * Multiline triple indented strings avoids escaping characters
 *
 */
fun main() {
    val kotlinLogo =
        """
        | //
        |//
        |/ \
        """.trimIndent()
    println(kotlinLogo)

    // no escaping needed
    val path = """C:\Users\yole\kotlin-book"""
    println(path)

    // Json/Html
    val json =
        """
        {
            "name": "Sebastian",
            "age": 27,
            "homeTown": "Munich"
        }
        """.trimIndent()
    println(json)
}