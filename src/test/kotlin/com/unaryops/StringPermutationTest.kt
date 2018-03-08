package com.unaryops

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class StringPermutationTest {
    @Test
    fun whenStringsDifferentLengthReturnFalse() {
        val s1 = "abc"
        assertFalse(s1 isPermutationOf "abcd")
    }

    @Test
    fun whenIsPermutationReturnTrue() {
        val s1 = "abc"
        assertTrue(s1 isPermutationOf "cba")
        assertTrue(s1 isPermutationOf "bca")

    }

    @Test
    fun whenStringHaveRepeatedCharacters() {
        val s1 = "abc"
        assertFalse(s1 isPermutationOf "aac")

    }

    infix fun String.isPermutationOf(s: String) : Boolean {
        if (s.length != this.length) return false

        var map = mutableMapOf<Char, Int>()
        for (i in s.indices) {
            recordCount(map, s[i])
            recordCount(map, this[i])
        }

        return map.values.none { it != 1 && it % 2 != 0 }
    }

    private fun recordCount(map: MutableMap<Char, Int>, c: Char) {
        if (!map.containsKey(c)) {
            map.put(c, 1)
        } else {
            var current = map[c]
            if (current != null) {
                map.put(c, ++current)
            }
        }
    }
}