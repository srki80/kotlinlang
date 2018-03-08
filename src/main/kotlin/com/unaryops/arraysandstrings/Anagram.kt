package com.unaryops.arraysandstrings

fun main(args: Array<String>) {
    listAnagrams(listOf("dog", "god", "dogg", "ggod"))
}

fun listAnagrams(words: List<String>) {
    words.groupBy { it.toSortedLowerCase() }.forEach { println(it.value) }
}

fun String.toSortedLowerCase(): String = this.toLowerCase().toList().sorted().toString()
