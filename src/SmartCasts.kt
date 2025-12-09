/**
 *
 * If you check the variable for a certain type (using `is`),
 * you don’t need to cast it afterward.
 *
 * Example:
 * 1. If an expression is a Num, you return the corresponding value.
 * 2. If it’s a Sum, you must evaluate the left and right expressions
 * recursively and return their sum.
 *
 */
interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

/**
 * Java: variable needs to be cast after type check
 */
fun evalJavaLike(e: Expr): Int {
    if (e is Num) {
        val n = e as Num
        return n.value
    }
    if (e is Sum) {
        return evalJavaLike(e.right) + evalJavaLike(e.left)
    }
    throw IllegalArgumentException("Unknown expression")
}

/**
 * Kotlin: cast is not needed after `is`
 * Also, if can be returned directly
 */
fun eval(e: Expr): Int =
    if (e is Num) e.value
    else if (e is Sum) { // Block expression: last statement is returned
        println("sum: $e.left + $e.right")
        eval(e.right) + eval(e.left)
    } else throw IllegalArgumentException("Unknown expression")

/**
 * Using `when` instead of `is`
 */
fun evalWithWhen(e: Expr): Int =
    when (e) {
        is Num -> e.value
        is Sum -> { // Block expression: last statement is returned
            println("sum: $e.left + $e.right")
            eval(e.right) + eval(e.left)
        }

        else -> throw IllegalArgumentException("Unknown expr")
    }

fun main() {
    println(
        evalJavaLike(
            Sum(Sum(Num(1), Num(2)), Num(4))
        )
    )

    println(
        eval(
            Sum(Sum(Num(1), Num(2)), Num(4))
        )
    )

    println(
        evalWithWhen(
            Sum(Sum(Num(1), Num(2)), Num(4))
        )
    )
}

