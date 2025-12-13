/**
 * Inner classes
 * - Has access to members of the outer class
 * - Accessible only via an instance of the
 *   outer class
 * - Declared using `ìnner`
 *
 * Nested class is accessible by default via
 * outer.Inner()
 */
class Outer {
    val outerValue = 10

    inner class Inner {
        fun printValue() {
            println(outerValue)
        }
    }
}

fun main() {
    val outer = Outer()
    val inner = outer.Inner()
    inner.printValue()
}