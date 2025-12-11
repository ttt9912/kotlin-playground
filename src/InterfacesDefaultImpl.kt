/**
 * If a class implements two interfaces where both
 * have a same default method, the implementing class
 * is forced to override the method
 */
interface Selectable {
    fun showOff() =
        println("I'm selectable")
}

interface Focusable {
    fun showOff() =
        println("I'm focusable")
}

// `override` is mandatory
class Checkbox : Selectable, Focusable {
    override fun showOff() {
        super<Selectable>.showOff()
        super<Focusable>.showOff()
    }
}

fun main() {
    Checkbox().showOff()
}