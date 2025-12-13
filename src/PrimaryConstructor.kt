/**
 * Short vs. long version of constructor
 */
class UserA(val name: String)

// Same thing as above
class UserB constructor(_name: String) {
    val name: String

    init {
        name = _name
    }
}

// Same thing as above
class UserC constructor(_name: String) {
    val name = _name
}

/**
 * Class without constructor
 * - generates empty constructor
 */
class UserD

fun main() {
    val userA = UserA("A")
    val userB = UserB("B")
    val userC = UserC("C")
    println("----")
    val userD = UserD()
}

