package com.unaryops

fun main(args: Array<String>) {
    printSum(4, 3)
    stringTemplate()
    println("max is ${maxOf(4, 3)}")
    printProduct("2", "4")
    loops()
}

fun printSum(a: Int, b: Int) {
    println("sum of $a and $b is ${a + b}")
}

fun stringTemplate() {
    var a = 1
    val s1 = "a is $a"
    a = 2
    val s2 = "${s1.replace("is", "was")}, but now is $a"
    println(s2)
}

fun maxOf(a: Int, b: Int) = if (a > b) a else b


fun printProduct(arg1: String, arg2: String) {
    val x = parseInt(arg1)
    val y = parseInt(arg2)

    println( x?.let { y?.let { x * y } ?: "y is null" } ?: "x is null")
}

fun parseInt(str: String) : Int? {
    return null
}

fun loops() {
    val items = listOf("apple", "banana", "kiwi")
    for (item in items) {
        println(item)
    }

    for (index in items.indices) {
        println("item at $index is ${items[index]}")
    }

    IntArray(10).apply {
        fill(-1) }
            .forEach {
                println(it)
            }
}

fun describe(obj: Any): String =
    when (obj) {
        1 -> "One"
        1..10, "One-Ten" -> "Range 1-10"
        "Hello" -> "Greeting"
        is Long -> "Long"
        !is String -> "Not a string"
        else -> "Unknown"
}




