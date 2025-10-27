fun main() {


    // String templates
    val customers = 4
    println("Number of customers: $customers")
    println("Number of customers: ${customers}")

    // List
    val letters = listOf("A", "B", "C")
    println("Second item: ${letters[1]}")
    println("This list has ${letters.count()} items")
    println("B" in letters) // true

    // Map (type declaration is optional)
    val juiceMenu: MutableMap<String, Int> = mutableMapOf("apple" to 100, "kiwi" to 190, "orange" to 100)
    val juiceMenuReadOnly: Map<String, Int> = juiceMenu
    println(juiceMenuReadOnly)
    println("The value of apple juice is: ${juiceMenu["apple"]}")

    // There is no ternary operator, use if-else instead
    val a = 1
    val b = 2
    println(if (a > b) a else b)

    // when
    val obj = "Hello"
    when (obj) {
        "1" -> println("One")
        "Hello" -> println("Greeting")
        else -> println("Unknown")
    }

    // when - as expression
    val msg = "Hello"
    val result = when (msg) {
        "1" -> "One"
        "Hello" -> "Greeting"
        else -> "Unknown"
    }
    println(result)

    // when - without subject
    val trafficLightState = "Red"
    val trafficAction = when {
        trafficLightState == "Green" -> "Go"
        trafficLightState == "Yellow" -> "Slow down"
        trafficLightState == "Red" -> "Stop"
        else -> "Malfunction"
    }
    println(trafficAction)

    // Ranges:
    // - 1..4 is equivalent to 1, 2, 3, 4.
    // - 1..<4 is equivalent to 1, 2, 3.
    // - 4 downTo 1 is equivalent to 4, 3, 2, 1.
    // - 1..5 step 2 is equivalent to 1, 3, 5.
    // - 'a'..'d' is equivalent to 'a', 'b', 'c', 'd'
    // - 'z' downTo 's' step 2 is equivalent to 'z', 'x', 'v', 't'

    // for-loops
    for (i in 1..3) {
        println("i = $i")
    }

    for (cake in listOf("carrot", "cheese", "chocolate")) {
        println("Yummy, it's a $cake cake!")
    }

    // while and do-while (omitted)

    // Functions
    fun hello() {
        return println("Hello, world!")
    }
    hello()

    // Typing
    fun sum(x: Int, y: Int): Int {
        return x + y
    }

    // Named arguments
    fun printMessage(message: String, prefix: String) {
        println("[$prefix] $message")
    }
    printMessage(prefix = "Log", message = "Hello")

    // Default arguments
    fun printMessageWithDefault(message: String, prefix: String = "Info") {
        println("[$prefix] $message")
    }
    printMessageWithDefault("Hello")

    // Single expression functions
    fun sumValues(x: Int, y: Int) = x + y
    println(sumValues(1, 2))

    // Lambda functions
    val upperCaseString = { text: String -> text.uppercase() }
    println(upperCaseString("hello"))

    // Invoke separately
    println({ text: String -> text.uppercase() }("hello"))

    // Trailing Lambda
    val listSum = listOf(1, 2, 3).fold(0, { x, item -> x + item }) // 6
    // Alternatively, in the form of a trailing lambda
    val listSum2 = listOf(1, 2, 3).fold(0) { x, item -> x + item }  // 6

    // Classes
    class Contact(val id: Int, var email: String)

    val contact: Contact = Contact(1, "demo@demo.ch")
    println(contact)

    class Member(val id: Int, var email: String) {
        fun printId() = println(id);
    }

    val member: Member = Member(1, "user@demo.ch")
    member.printId()

    // Data Classes (toString, equals and ==, copy)
    data class User(val name: String, val id: Int)

    val user = User("Alex", 1)
    println(user)

    // Comparing data casses
    val secondUser = User("Alex", 1)
    println("user == secondUser: ${user == secondUser}")

    // Null safety
    val fruits: MutableMap<String, Int> = mutableMapOf("apple" to 100, "kiwi" to 190, "orange" to 100)
    val apple: Int? = juiceMenu["apple"] // compiler requires '?' if null is possible

    // Safe calls
    // person.company?.address?.country

    // Elvis operator '?:'
    val kiwi: Int = juiceMenu["apple"] ?: 150

    // Extension Functions
    fun String.bold(): String = "<b>$this</b>"
    println("hello".bold())

    fun List<Int>.summarize(): Int = this.fold(0, { x, y -> x + y })
    println(listOf(1, 2, 3).summarize())

    // Scope Functions (let, apply, run, also, and with)

    // 'let' & 'it' (if object not-null, execute xyz with it)
    fun getNextAddress(): String? = "Thomas"; // can return null
    fun sendNotification(address: String): String {
        println("Hello $address")
        return "Notification sent!"
    }

    val address: String? = getNextAddress()
    val confirm = address?.let {
        sendNotification(it)
    }

    // 'apply' (initialize objects, calling member functions)
    class Client() {
        var token: String? = null
        fun connect() = println("connected!")
        fun authenticate() = println("authenticated!")
        fun getData(): String = "Mock data"
    }

    val client = Client().apply {
        token = "asdf"
        connect()
        authenticate()
    }

    client.getData()
    // connected!
    // authenticated!

    // 'run' (similar to apply, but lets you run member functions on every request, not only on initialization)
    val client2: Client = Client().apply {
        token = "asdf"
    }

    val result2: String = client2.run {
        connect()
        // connected!
        authenticate()
        // authenticated!
        getData()
    }

    // 'also' (similar to peek)
    val medals: List<String> = listOf("Gold", "Silver", "Bronze")
    val reversedLongUppercaseMedals: List<String> =
        medals
            .map { it.uppercase() }
            .also { println(it) }
            // [GOLD, SILVER, BRONZE]
            .filter { it.length > 4 }
            .also { println(it) }
            // [SILVER, BRONZE]
            .reversed()
    println(reversedLongUppercaseMedals)

    // 'with' (call multiple functions on an object)
    class Canvas {
        fun rect(x: Int, y: Int, w: Int, h: Int): Unit = println("$x, $y, $w, $h")
        fun text(x: Int, y: Int, str: String): Unit = println("$x, $y, $str")
    }
    val mainMonitorSecondaryBufferBackedCanvas = Canvas()
    with(mainMonitorSecondaryBufferBackedCanvas) {
        text(10, 10, "Foo")
        rect(20, 30, 100, 50)
        text(15, 45, "Hello")
    }

    // Lambda expressions with receiver
    fun StringBuilder.appendText() { append("Hello!") } // extend StringBuilder
    val stringBuilder = StringBuilder()
    stringBuilder.appendText()
    println(stringBuilder.toString())

    // ------------



}
