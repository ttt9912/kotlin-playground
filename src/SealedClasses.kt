/**
 * Sealed classes
 * - all subclasses are known at compile time
 */
sealed class Result

class Success(val data: String) : Result()
class Error(val message: String) : Result()

/**
 * No `else` required - compiler knows all cases.
 */
fun handleResult(result: Result) {
    when (result) {
        is Success -> println(result.data)
        is Error -> println(result.message)
    }
}

fun main() {
    handleResult(Success("Great"))
}