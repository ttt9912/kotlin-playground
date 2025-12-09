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