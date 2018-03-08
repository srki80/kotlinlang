package com.unaryops.arraysandstrings

import org.junit.jupiter.api.Test

// ranges
fun withRange() {
    (1..10).forEach { println(it) }
    for (number in 1..100) println(fizzBuzz(number))
    // more ranges
//    for (i in 1..100) { ... }  // closed range: includes 100
//    for (i in 1 until 100) { ... } // half-open range: does not include 100
//    for (x in 2..10 step 2) { ... }
//    for (x in 10 downTo 1) { ... }
//    if (x in 1..10) { ... }
}

// lambda expression
val fizzBuzz = {
    number: Int ->
    when {
        number isDivisibleBy 3  && number isDivisibleBy 5 -> "FizzBuzz"
        number isDivisibleBy 3 -> "Fizz"
        number isDivisibleBy 5 -> "Buzz"
        else -> number.toString()
    }
}

// this can also be just a function
//fun fizzBuzz(number: Int) : String {
//    return when {
//        number isDivisibleBy 3  && number isDivisibleBy 5 -> "FizzBuzz"
//        number isDivisibleBy 3 -> "Fizz"
//        number isDivisibleBy 5 -> "Buzz"
//        else -> number.toString()
//    }
//}
//
//// function with expression body (Implicit return)
//fun fizzBuzz(number: Int) : String = when {
//    number isDivisibleBy 3  && number isDivisibleBy 5 -> "FizzBuzz"
//    number isDivisibleBy 3 -> "Fizz"
//    number isDivisibleBy 5 -> "Buzz"
//    else -> number.toString()
//}

// Extension functions. Used to extend functionality of existing classes. You can add
// infix prefix to omit . and () when calling a function.
infix fun Int.isDivisibleBy(number: Int) : Boolean  {
    return this % number == 0
}

// kotlin switch
fun describe(obj: Any): String =
        when (obj) {
            1 -> "One"
            1..10, "One-Ten" -> "Range 1-10"
            "Hello" -> "Greeting"
            is Long -> "Long"
            !is String -> "Not a string"
            else -> "Unknown"
        }

// Method taking a lambda, or function with Int parameter returning String, and Int
fun get(fizzBuzz: (Int) -> String, number: Int) : String {
    return fizzBuzz(number)
}

// Cool tests
@Test
fun `when user is valid then login should be allowed`() {
    println("cool feature for naming tests")
}

// getters and setters, equals, hashCode, copy, toString ...
data class SomeEntity(var name: String, var email: String)

// named parameters and default values
fun process(param1: String = "", param2: Int = 0) {
    println("${param1}, ${param2}")
}

fun main(args: Array<String>) {
    var entity = SomeEntity("Joe", "joe@email.com")
    entity.name = "srki"
    entity.email = "srki@lendup.com"
    process(param2 = 0) // named parameters


    // List and maps
    val list= listOf("a", "b", "c")
    val map = mapOf("a" to 1, "b" to 2, "c" to 3)
}

// try/catch as an expression
fun test() {
    val result = try {
        count()
    } catch (e: ArithmeticException) {
        throw IllegalStateException(e)
    }
    // Working with result
}

// if as an expression
fun foo(param: Int) {
    val result = if (param == 1) {
        "one"
    } else if (param == 2) {
        "two"
    } else {
        "three"
    }
}



//fun main(args: Array<String>) {
//    withRange()
//}


fun middle(word: String): String {
    return when {
        word.lengthIsEven() -> word.firstCharToTheLeftOfTheMiddle() + word.firstCharToTheRightOfTheMiddle()
        else -> word.charInTheMiddle()
    }
}

fun String.lengthIsEven() : Boolean {
    return this.length % 2 == 0
}

fun String.firstCharToTheLeftOfTheMiddle() : String {
    return this[(this.length/2) - 1].toString()
}

fun String.firstCharToTheRightOfTheMiddle() : String {
    return this[(this.length/2)].toString()
}

fun String.charInTheMiddle() : String {
    return this.firstCharToTheRightOfTheMiddle()
}

fun josephusSurvivor(nPeople: Int, increment: Int): Int {
    var people = (1..nPeople).toMutableList()
    people = josephus(0, increment, people)
    return people[0]
}


fun josephus(start: Int, increment: Int, people: MutableList<Int>): MutableList<Int> {
    val currentIndex = nextIndex(start, increment, people.size)
    people.removeAt(currentIndex - 1)
    return josephus(currentIndex - 1, increment, people)
}

fun nextIndex(start: Int, increment: Int, size: Int): Int {
    if (increment > size) {
        return increment - size;
    }

    var newIndex = start + increment;
    if (newIndex > size) {
        newIndex = size - increment;
    }

    return newIndex
}



