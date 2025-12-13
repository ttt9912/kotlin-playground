# Order of files

* [Person.kt](/src/Person.kt)
* [NullSafety.kt](/src/NullSafety.kt)
* [CastSafety.kt](/src/CastSafety.kt)
* [StringTemplates.kt](/src/StringTemplates.kt)
* [CustomAccessors.kt](/src/CustomAccessors.kt)
* [Enum.kt](/src/Enum.kt)
* [When.kt](/src/When.kt)
* [SmartCasts.kt](/src/SmartCasts.kt)
* [Iterations.kt](/src/Iterations.kt)
* [CollectionMembership.kt](/src/CollectionMembership.kt)
* [Exceptions.kt](/src/Exceptions.kt)
* [TryCatchFinally.kt](/src/TryCatchFinally.kt)
* [Functions.kt](/src/Functions.kt)
* [ExtensionFunctions.kt](/src/ExtensionFunctions.kt)
* [ExtensionProperties.kt](/src/ExtensionProperties.kt)
* [Collections.kt](/src/Collections.kt)
* [DestructuringDeclaration.kt](/src/DestructuringDeclaration.kt)
* [StringExtensionFunctions.kt](/src/StringExtensionFunctions.kt)
* [Regex.kt](/src/Regex.kt)
* [MultilineStrings.kt](/src/MultilineStrings.kt)
* [Interfaces.kt](/src/Interfaces.kt)
* [InterfacesDefaultImpl.kt](/src/InterfacesDefaultImpl.kt)
* [OpenClasses.kt](/src/OpenClasses.kt)
* [AbstractClasses.kt](/src/AbstractClasses.kt)
* [NestedClasses.kt](/src/NestedClasses.kt)
* [InnerClasses.kt](/src/InnerClasses.kt)

# Keywords

- Statically typed
- Type inference
- First-class functions
- Multi platform
- Interoperability

# Multi platform

Kotlin can be compiled to:

- JVM bytecode
- Javascript to run in the browser in runtimes such as NodeJS
- Native binaries allowing to run on iOS etc.
    - Write code once and run on Android and iOS

## Compiling Kotlin to Java and running

```
kotlinc <source file or directory> -include-runtime -d <jar name>
java -jar <jar name>
```

`-include-runtime` is to include Kotlin built-in classes and their APIs

# Interoperability

Mix Java and Kotlin code

# Variables

- `val` read only variable
- `var` mutable variable

# Classes

- `public class` - public keyword can be omitted, public is the default visibility

## Properties

- Java: field + accessor methods = property
- Kotlin properties: no need for accessor methods
- Properties are declared with the `val` and `var` keywords
- `val` generates a field and a getter
- `var` field, getter and setter

## Stored properties

- Backed by a field
- Auto-generates getter and setter

## Computed Properties

- Computed from fields

## Custom accessors

- Computed properties
- Creating a `get()` method
- For `var` properties, can override the setter using `set()`

# Packages

### Java:

- File: `/geometry/shapes/Rectangle.java`
    - 1 file = 1 class
- Package: `geometry.shapes`

### Kotlin:

- File: `/geometry/shapes.kt`
    - 1 file can contain multiple classes
- Package: `geometry.shapes`

# Enums

- Declared using `enum class`
- `enum` is a **soft keyword**. It can also be used as variable name etc.

# When

Replacement of the `switch` construct

# Smart casts

If you check the variable for a certain type (using `is`),
you don’t need to cast it afterward.

# Iterations

### While loop

- Do-while loop
- While with labels

### For loop

- Iterate over **range**
- Iterate over list
- Iterate over list with index
- Iterate over map

# Collection Membership

Use `in` to check whether a value is in a
range or collection

# Exceptions

## Throw

- Similar to Java using `throw`, `try`, `catch`, `finally`
- `throw` is an expression

## Try-catch-finally

- Can be used similar to Java
- But is optional, as Kotlin doesn't have **checked exceptions**
- `try` can be used as expression

## No checked exceptions

- Kotlin doesn't have `throws` in method signatures
- Kotlin doesn't differentiate between checked and unchecked exceptions

Experience has shown that the Java rules often require a lot of
meaningless code to rethrow or ignore exceptions, and the rules
don’t consistently protect you from the errors that can happen.

# Functions

## Named arguments

Especially usefule together with **default parameters**

## Default parameters

- Mostly elimitates need for overloading methods
- @JvmOverloads: generate overloads for Java

# Top-level functions

- Do not belong to a class, getting rid of static utility classes
- Will be compiled into generated Java classes under the hood
    - JVM can only execute code in classes
    - By default, the class name corresponds to the filename.
    - But this can be changed using @file:JvmName("StringFunctions")

# Top-level properties

- Properties defined outside a class
- Expose a constant to Java code as a `public static final` field,
  mark it with the `const` modifier

```
/* Kotlin */
const val UNIX_LINE_SEPARATOR = "\n"
```

```
/* Java */
public static final String UNIX_LINE_SEPARATOR = "\n"
```

# Extension functions

Extension function: a function that can be called as a member of a
class but is defined outside of it.

## Access

- Extension functions have access to methods and properties of
  the class
- Extension functions do not have access to private or
  protected members of the class

## Import extension function:

- must be declared in a package, eg. `package strings`

import it using

```
import strings.lastChar

import strings.*

import strings.lastChar as last
```

## Working with generics

`fun Collection<T>.join()` can be called on all
collections

`fun Collection<String>.join()` can be called only
on collections of strings

## Call extension function from Java

Under the hood, an extension function is a static method.
The class name is derived from the kotlin filename, eg:
`StringUtilKt.lastChar("Java")`

## No overriding for extension functions

```
fun View.showOff() = println("I'm a view!")
fun Button.showOff() = println("I'm a button!")
 
fun main() {
    val view: View = Button()
    view.showOff() // I'm a view!
}
```

Even though `View view` is of type `Button`, the
`View.showOff()` extension function is called

## Extension and member functions with same name

If the class has a member function with the same signature
as an extension function, the **member function** always
takes precedence.

# Extension Properties

Even though they’re called properties, they can’t have any
state because there’s no proper place to store it.
It’s not possible to add extra fields to existing instances
of Java objects.

Extension properties can be immutable or mutable

# Collections

## Collection Classes

Kotlin uses the standard Java collection classes.

- `setOf()` -> java.util.LinkedHashSet
- `listOf()` -> java.util.Arrays$ArrayList
- `mapOf()` -> java.util.LinkedHashMap

### Notes

- Kotlin’s collection interfaces are **immutable** by default.
- Kotlin collections are fully Java compatible
    - No need to convert collections between Java and Kotlin
    - But Kotlin has much more operations (get last, shuffle...)

# The `vararg` keyword

Varargs: functions that accept an arbitrary number of arguments.
Essentially the same thing as `args...` in Java

## Spread operator

Expands an array:

```
fun printAll(vararg items: String) {
    items.forEach { println(it) }
}

val arr = arrayOf("A", "B", "C")

printAll(*arr) // "A", "B", "C"
```

```
val more = arrayOf("X", "Y")
val combined = arrayOf("A", "B", *more, "Z")
```

# Infix notation

```
val map = 
    mapOf(1 to "one", 7 to "seven", 53 to "fifty-three") 
```

The word `to` in this line of code isn’t a built-in construct but,
rather, a method invocation of a special kind, an infix call.

Infix call: method name is placed between target and parameter.

Those two calls are equivalent:

```
1.to("one")
1 to "one"
```

# Destructuring declaration

## Pair

You can initialize two variables with the contents of a Pair directly:

```
val (number, name) = 1 to "one"
```

This feature is called a destructuring declaration.

## Key-value

```
for ((index, element) in collection.withIndex()) {/*...*/}
```

# Kotlin Strings

- Exactly the same as Java strings. No conversion needed
- Kotlin provides useful extension functions (like with collections)

## String extension functions

- `toRegex()` converts a string to a regex
- `"12.345-6.A".split("\\.|-".toRegex())` split with regex
- `"12.345-6.A".split(".", "-")` split with multiple chars

## Multiline strings

- Triple-quoted
- Avoids escaping characters

### Synthax highlighting in Intellij

- Eg. highlight Multiline JSON

-> Place cursor inside string -> Alt+Enter
-> Inject language or reference -> Json

# Local functions

- Nest functions
- Inner function has access to all parameters and variables
  of the encolsing function
- Extension functions can also be declared as local functions,

# Classes overview

- Kotlin’s declarations are `public final`, by default.
- Nested classes aren’t inner by default - they don’t contain an
  implicit reference to their outer class
- `data class` instructs the compiler to generate several standard
  methods for this class
- Delegation pattern is supported natively in Kotlin
- Class can implement many interfaces and extend max one class

# Interfaces

Can define abstract methods and default implementations.
Cannot have state.

# Class modifiers

```
open
final
abstract
```

Default: `final`

# Final by default

But in Kotlin, classes and methods are final by default, unlike Java.

## Open class

To extend a class, the class needs to be declared `open`

Why? **Fragile base class problem**: any change in the base class may
lead to unexpected changes of behaviour in the subclasses.

`abstract` classes and interfaces are always open

## Open methods

- To override a method, the method needs to be declared `open`
- Methods marked with `override` that override a method from a base
  class or interface are also open by default. To avoid overriding in
  subclasses, mark the method with `final`

## Spring

Spring beans need to be declared `open`

# Abstract classes

Defining abstract **properties** and **methods**
Abstract class can't be instantiated

# Visibility modifiers

```
public
internal
protected
private
```

Default: `public`

-`internal`: visible in module

- `protected`: visible in subclasses
- `private`: visible inside a class or, in the case of top-level
  declarations, visible inside a file

### Extension functions

Extension functions have no access to `private` and `protected`
members

# `internal` visibility

- Internal: visible within your module (= set of Kotlin files
  compiled together)
- No package-private visibility

The advantage of internal visibility is that it provides real
encapsulation for the implementation details of your module.
In Java, the encapsulation can be easily broken because external
code can define classes in the same packages used by your code and,
thus, gain access to your package-private declarations.

# Nested class

Like a **static** nested class in Java

- Does NOT hold a reference to the outer class
- Cannot access outer class members directly
- More memory-efficient

**Default behavior in Kotlin**

# Inner class

An **inner** class keeps a reference to an instance of the outer
class.

- HAS a reference to the outer class instance
- Can access outer class members
- Requires an outer class instance to be created

Declared using the `inner` keyword

## Java

In Java, when you declare a class in another class, it becomes
an inner class by default.

Use **static** to make it a nested class






