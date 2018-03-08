package com.unaryops.maps

class HashMap<K: Any, V: Any>(size: Int = 16) {
    private val array = arrayOfNulls<MutableList<Entry<K, V>>>(size)

    fun put(key: K, value: V) {
        validate(key)
        addEntry(indexOf(key), Entry<K, V>(key, value))
    }


    fun get(key: K) : V? {
        validate(key)

        val index = indexOf(key)

        if (!keyExists(index)) {
            throw KeyDoesNotExist("key $key does not exist in the map")
        }

        return array[index]?.filter { it.key == key }?.get(0)?.value

    }

    private fun addEntry(index: Int, entry: Entry<K, V>) {
        if (keyExists(index)) {
            addAt(index, entry)
        } else {
            addNewAt(index, entry)
        }
    }

    private fun addNewAt(index: Int, entry: Entry<K, V>) {
        array[index] = mutableListOf(entry)
    }

    private fun addAt(index: Int, entry: Entry<K, V>) {
        array[index]?.add(entry)
    }

    private fun keyExists(index: Int) = array[index] != null

    private fun validate(key: K) {
        if (key == null) {
            throw IllegalArgumentException("key must not be null")
        }
    }

    private fun indexOf(key: K): Int {
        return key.hashCode() % array.size
    }

    data class Entry<out K, out V>(val key: K, val value: V)
}


class KeyDoesNotExist(message: String) : RuntimeException()

fun main(args: Array<String>) {
    var map = HashMap<String, Int>()
    map.put("1", 1)
    map.put("2", 2)
    map.put("3", 3)
    map.put("4", 4)
    map.put("5", 5)
    map.put("1223", 66)

    var value = map.get("1223")
    println("Value for key 1223: $value")

    value = map.get("1")
    println("Value for key 1: $value")

    var bitwise = 1 shl 4
    println("Value: $bitwise ")

    bitwise = 1 shl 30
    println("Value: $bitwise ")

    var newMap = mutableMapOf<String, String>()
    newMap.put("key", "value")
    newMap.forEach { println("foreach ${it.key}") }

    var javaMap = HashMapJava<String, Int>();
    javaMap.put("1", 1)
    javaMap.put("2", 2)
    javaMap.put("3", 3)
    javaMap.put("4", 4)
    javaMap.put("5", 5)
    javaMap.put("1223", 66)

}



