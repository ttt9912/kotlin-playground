/**
 * Abstract class
 * - can't be instantiated
 *
 * Abstract property
 * - subclass needs to instantiate it or provide an accessor
 *
 * Non-abstract function in abstract class
 * - not open by default
 */
abstract class Animated {
    abstract val animationSpeed: Double
    val keyframes: Int = 20
    open val frames: Int = 60

    abstract fun animate()

    open fun stopAnimating() {
    }

    fun animateTwice() {
    }
}

class AnimatedItem : Animated() {
    override val animationSpeed: Double = 1.0

    override fun animate() {
        println("Animating")
    }

}
