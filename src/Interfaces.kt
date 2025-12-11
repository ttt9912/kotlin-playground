/**
 * Interface
 * - can define abstract methods
 * - can define implementations
 * - cannot have state
 */
interface Clickable {
    fun click()
}

// `override` is mandatory
class Button : Clickable {
    override fun click() =
        println("I was clicked!")
}

fun main() {
    Button().click()
}