package com.unaryops.arraysandstrings

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue

fun String.isUnique() : Boolean {
    (0..this.length).forEach { i ->
        ((i+1)..this.length)
                .filter { it < this.length && this[i] == this[it] }
                .forEach { return false }
    }
    return true;
}

fun String.isUniqueFast() : Boolean {
    var map = mutableMapOf<Char, Int>()
    this.forEach { c ->
        when {
            map.containsKey(c) -> return false
            else -> map[c] = 1
        }
    }
    return true;
}

fun String.isPermutationOfPalindrome() : Boolean {
    return isMaxOneOdd(charFrequencyMap())

}

private fun isMaxOneOdd(map: MutableMap<Char, Int>) =
        map.filter { it.value % 2 != 0 }.size <= 1

fun String.charFrequencyMap(): MutableMap<Char, Int> {
    var map = mutableMapOf<Char, Int>()
    for (c in this) {
        if (map.containsKey(c)) {
            map[c]?.plus(1)?.let { map.put(c, it) }
        } else {
            map[c] = 1
        }
    }
    return map
}

fun String.isPermutation(s: String) : Boolean {
    if (s.length != this.length) return false
    return this.toList().sorted() == s.toList().sorted()
}

fun String.isPermutationFast(s: String) : Boolean {
    this.forEach {  }
    return false
}

fun main(args: Array<String>) {
    println("Is unique: ${"abcdfg".isUnique()}")
    println("Is unique: ${"abcdfgh".isUniqueFast()}")

    assertTrue("mm".isPermutationOfPalindrome());
    assertTrue("mmc".isPermutationOfPalindrome());
    assertFalse("mmcg".isPermutationOfPalindrome());
    assertTrue("maam".isPermutationOfPalindrome());
    assertTrue("macam".isPermutationOfPalindrome());

    assertTrue("abcd".isPermutation("dcab"))
    assertFalse("abcd".isPermutation("ddcab"))
    assertTrue("aabcd".isPermutation("dcaba"))
}


