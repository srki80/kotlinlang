package com.unaryops.arraysandstrings

object StringPermutation {
    infix fun String.isPermutationOf(s: String) : Boolean {
        if (s.length != this.length) return false

        var map = mutableMapOf<Char, Int>()
        for (i in s.indices) {
            if (!map.containsKey(s[i])) {
                map.put(s[i], 0)
            } else {
                var current = map.get(s[i])
                if (current != null) {
                    current++?.let { map.put(s[i], it) }
                }
            }

            if (!map.containsKey(this[i])) {
                map.put(this[i], 0)
            } else {
                var current = map.get(this[i])
                if (current != null) {
                    current++?.let { map.put(this[i], it) }
                }
            }
        }

        return map.values.none { it % 2 != 0 }
    }

}
