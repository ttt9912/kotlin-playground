open class Human{
    fun die() = println("the end")
    open fun speak() = println("Hi")
}

class Man : Human(){
    override fun speak() = println("Hello")
}