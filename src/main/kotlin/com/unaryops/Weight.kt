package com.unaryops

import org.junit.jupiter.api.Assertions.assertEquals

fun order(input: String) : String {
    return input.split(" ").map {
        it.map{ it.asInt() }
                .sum().toString()
    }.sorted().joinToString(" ")
}


fun Char.asInt() : Int {
    return this.toString().toInt();
}

fun main(args: Array<String>) {
//    println(order("1111 222"))
    println("****** Basic Tests ******")
    assertEquals("2000 103 123 4444 99", order("103 123 4444 99 2000"))
    assertEquals("11 11 2000 10003 22 123 1234000 44444444 9999", order("2000 10003 1234000 44444444 9999 11 11 22 123"))
}