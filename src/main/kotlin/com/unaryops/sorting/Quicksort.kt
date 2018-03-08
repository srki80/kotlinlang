package com.unaryops.sorting

fun sort(arr: Array<Int>) {
    var left = 0
    var right = arr.size - 1

    quicksort(arr, left, right)
}

fun quicksort(arr: Array<Int>, left: Int, right: Int) {
    if (left >= right) {
        return
    }

    var pivot = (left + right) / 2
    var index = partition(arr, left, right, pivot)
    quicksort(arr, left, index - 1)
    quicksort(arr, index, right)


}

fun partition(arr: Array<Int>, left: Int, right: Int, pivot: Int): Int {
    var left = left
    var right = right

    while (arr[left] < arr[pivot]) left++
    while (arr[right] > arr[pivot]) right--
    return swap(arr, left, right)
}

private fun swap(arr: Array<Int>, left: Int, right: Int) : Int {
    var left1 = left
    var right1 = right
    if (arr[left1] <= arr[right1]) {
        var tmp = arr[left1]
        arr[left1] = arr[right1]
        arr[right1] = tmp
        right1--
        left1--
    }
    return left
}

fun main(args: Array<String>) {
    var arr = arrayOf(9, 5, 1, 8, 6, 10, 2)
    sort(arr)
    println(arr)

}
