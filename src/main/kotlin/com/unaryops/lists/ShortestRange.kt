package com.unaryops.lists

import org.junit.jupiter.api.Assertions.assertTrue


fun find(l1: List<Int>, l2: List<Int>, l3: List<Int>) : Pair<Int, Int> {
    var index1 = 0
    var index2 = 0
    var index3 = 0

    var minRangeMax = l1[index1]
    if (minRangeMaxInList(l2, index2, l1, index1, l3, index3)) {
        minRangeMax = l2[index2]
        index2++
    } else if (minRangeMaxInList(l3, index3, l1, index1, l2, index2)) {
        minRangeMax = l3[index3]
    } else {

    }

    return Pair(0, 0)
}

private fun minRangeMaxInList(l2: List<Int>, index2: Int, l1: List<Int>, index1: Int, l3: List<Int>, index3: Int) =
        l2[index2] > l1[index1] && l2[index2] > l3[index3]

fun maxOf(x: Int, y: Int, z: Int) : Int {
    var max = x
    if (y > x && y > z) {
        max = y
    } else if (z > x && z > y) {
        max = z
    }

    return max

}

fun main(args: Array<String>) {
    val l1 = listOf<Int>(4, 10, 15, 24)
    val l2 = listOf<Int>(0, 9, 12, 20)
    val l3 = listOf<Int>(5, 18, 22, 30)

    assertTrue(find(l1, l2, l3) == Pair(20,24))
}
