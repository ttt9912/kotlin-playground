# Order of files

1. [Person.kt](/src/Person.kt)
2. [NullSafety.kt](/src/NullSafety.kt)
3. [CastSafety.kt](/src/CastSafety.kt)
4. [StringTemplates.kt](/src/StringTemplates.kt)
5. [CustomAccessors.kt](/src/CustomAccessors.kt)
6. [Enum.kt](/src/Enum.kt)
7. [When.kt](/src/When.kt)
8. [SmartCasts.kt](/src/SmartCasts.kt)
9. [Iterations.kt](/src/Iterations.kt)
10. [CollectionMembership.kt](/src/CollectionMembership.kt)
11. [Exceptions.kt](/src/Exceptions.kt)
12. [TryCatchFinally.kt](/src/TryCatchFinally.kt)
13. [Collections.kt](/src/Collections.kt)
14. [Functions.kt](/src/Functions.kt)
15. [ExtensionFunctions.kt](/src/ExtensionFunctions.kt)
16. [ExtensionProperties.kt](/src/ExtensionProperties.kt)

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

