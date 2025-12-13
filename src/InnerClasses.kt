/**
 * Inner classes
 * - Has access to members of the outer class
 * - Accessible only via an instance of the
 *   outer class
 * - Declared using `ìnner`
 *
 * Referencing the outer class is via
 * `this@Outer`
 *
 * Nested class is accessible by default via
 * outer.Inner()
 */
class Outer {
    val value = 10

    inner class Inner {
        fun printValue() {
            println(this@Outer.value)
        }
    }
}

fun main() {
    val outer = Outer()
    val inner = outer.Inner()
    inner.printValue()
}