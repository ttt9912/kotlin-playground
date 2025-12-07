class Rectangle(
    // Stored property
    val height: Int,
    // Stored property
    val width: Int
) {

    // Computed property
    val isSquare: Boolean
        get() {
            return height == width
        }

    // Short synthax
    val doubleHeight get() = height * 2
}

fun main() {
    val rectangle = Rectangle(10, 10)

    println(rectangle.isSquare)
    println(rectangle.doubleHeight)
}