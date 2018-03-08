package com.unaryops

import com.unaryops.arraysandstrings.fizzBuzz
import com.unaryops.arraysandstrings.get
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class FizzBuzzKtTest {

    @Test
    fun when1Return1() {
        assertEquals("1", get(fizzBuzz, 1))
    }

    @Test
    fun when2Return2() {
        assertEquals("2", get(fizzBuzz, 2))
    }

    @Test
    fun when3ReturnFizz() {
        assertEquals("Fizz", get(fizzBuzz, 3))
    }

    @Test
    fun when4Return4() {
        assertEquals("4", get(fizzBuzz, 4))
    }

    @Test
    fun when5ReturnBuzz() {
        assertEquals("Buzz", get(fizzBuzz, 5))
    }

    @Test
    fun when6ReturnFizz() {
        assertEquals("Fizz", get(fizzBuzz, 6))
    }

    @Test
    fun when7Return7() {
        assertEquals("7", get(fizzBuzz, 7))
    }

    @Test
    fun when8Return8() {
        assertEquals("8", get(fizzBuzz, 8))
    }

    @Test
    fun when9ReturnFizz() {
        assertEquals("Fizz", get(fizzBuzz, 9))
    }

    @Test
    fun when15ReturnFizzBuzz() {
        assertEquals("FizzBuzz", get(fizzBuzz, 15))
    }


}