package com.unaryops

class KotlinMemCache(val capacity: Int) : MemCache {
    private lateinit var hashMap: HashMap<Int, Node>
    private var size = 0

    private class Node(key: Int,
                       value: Any,
                       previous: Node?,
                       next: Node?)

    override fun get(o: Any) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        if (size == 0) hashMap = HashMap<Int, Node>(capacity)

        val hash = o.hashCode()
        if (hashMap.contains(hash)) {
            hashMap.remove(hash)
            // update linked list
        }  else {
            hashMap.put(hash, Node(hash, o, null, null))
            // update linked list
        }


    }

    override fun put(o: Any) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}

interface MemCache {
    fun get(o: Any)
    fun put(o: Any)
}

fun main(args: Array<String>) {
    var mc = KotlinMemCache(1000)
    mc.put("1")
}