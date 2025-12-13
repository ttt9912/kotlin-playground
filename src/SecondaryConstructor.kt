import java.net.URI

/**
 * Secondary constructors
 * - class has no primary but two secondary constructors
 * - enable class to be initialized in two different ways
 */
open class Downloader {
    constructor(url: String?) {
        // some code
    }

    constructor(uri: URI?) {
        // some code
    }
}

/**
 * Extend using **primary constructor**
 */
class MyDownloader(url: String?) : Downloader(url)

/**
 * Extend using **secondary constructor**
 * can delegate either to superclass using `super` or
 * to another constructor in the same class using `this`
 */
class MyDownloader2 : Downloader {
    constructor(url: String?) : super(url)
    constructor(uri: URI?) : super(uri)
    constructor(url: String?, multipart: Boolean?) : this(url)
}

fun main() {
    val myDownloader = MyDownloader("https://google.com")
}