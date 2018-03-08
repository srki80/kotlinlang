package com.unaryops

import com.unaryops.arraysandstrings.josephusSurvivor
import com.unaryops.arraysandstrings.middle
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class GetMiddleTest {
    @Test
    fun evenTests() {
        assertEquals("es", middle("test"))
        assertEquals("dd", middle("middle"))
    }

    @Test
    fun oddTests() {
        assertEquals("t", middle("testing"))
        assertEquals("A", middle("A"))
    }


    @Test
    fun test1() {
        josephusTest(7, 3, 4)
    }

    @Test
    fun test2() {
        josephusTest(11, 19, 10)
    }

    @Test
    fun test3() {
        josephusTest(40, 3, 28)
    }

    @Test
    fun test4() {
        josephusTest(14, 2, 13)
    }

    @Test
    fun test5() {
        josephusTest(100, 1, 100)
    }

    fun josephusTest(n: Int, k: Int, result: Int) {
        val testDescription = String.format("Testing where n = %d and k = %d", n, k)
        assertEquals(result, josephusSurvivor(n, k), testDescription)
    }
}
