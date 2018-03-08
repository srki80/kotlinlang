package com.unaryops.stacksqueues


fun isBalanced(expression: String) : Boolean {
    var stack = arrayOfNulls<Char>(expression.length)
    var tail = 0;

    for (c in expression) {
        if (c == '{' || c == '[' || c == '(') {
            tail = push(stack, tail, c)
        } else if (c == '}') {
            if (peek(stack, tail) == '{') {
                tail = pop(tail, stack)
            } else {
                return false
            }
        } else if (c == ')') {
            if (peek(stack, tail) == '(') {
                tail = pop(tail, stack)
            } else {
                return false
            }

        } else if (c == ']') {
            if (peek(stack, tail) == '[') {
                tail = pop(tail, stack)
            } else {
                return false;
            }
        }
    }
    return true;
}

fun main(args: Array<String>) {
    println(isBalanced("{}[][[]](())[]"))
}

private fun push(stack: Array<Char?>, tail: Int, c: Char): Int {
    var tail1 = tail
    stack[tail1] = c
    tail1++
    return tail1
}

private fun pop(tail: Int, stack: Array<Char?>): Int {
    var tail1 = tail
    tail1--
    stack[tail1] = null
    return tail1
}

private fun peek(stack: Array<Char?>, tail: Int) = stack[tail - 1]

