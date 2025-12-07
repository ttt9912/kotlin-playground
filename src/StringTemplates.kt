fun main() {
    val name = "Thomas";

    println("Hello $name")

    println("Hello ${name.length}-letter Person")

    println("Hello ${if (name.isBlank()) "someone" else name}!")
}