package com.unaryops

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class WeightKtTest


@Test
fun BasicTests() {
    println("****** Basic Tests ******")
    assertEquals("2000 103 123 4444 99", order("103 123 4444 99 2000"))
    assertEquals("11 11 2000 10003 22 123 1234000 44444444 9999", order("2000 10003 1234000 44444444 9999 11 11 22 123"))
}