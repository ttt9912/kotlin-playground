/**
 * Nested classes
 * - Like a static nested class in Java
 * - No access to members of the outer class
 *
 * Nested class is accessible by default via
 * Outer.Inner()
 */
interface State

interface View {
    fun getCurrentState(): State
    fun restoreState(state: State) {}
}

class UiButton : View {
    override fun getCurrentState(): State =
        ButtonState()

    // Nested class
    class ButtonState() : State
}

fun main() {
    val btn = UiButton()
    println(btn.getCurrentState())

    /**
     * Nested class can be used without an instance
     * of the outer class
     */
    val btnState = UiButton.ButtonState()
    println(btnState)
}