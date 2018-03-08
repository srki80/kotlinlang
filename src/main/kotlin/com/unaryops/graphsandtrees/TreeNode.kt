package com.unaryops.graphsandtrees

import java.util.*

data class TreeNode(val data: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null

    fun insert(value: Int) {
        if (value <= data) {
            if (left != null) {
                left?.insert(value)
            } else {
                left = TreeNode(value)
            }
        } else {
            if (right != null ) {
                right?.insert(value)
            } else {
                right = TreeNode(value)
            }
        }
    }

    fun exist(value: Int) : Boolean? {
        if (value == data) {
            return true
        } else if (data >= value) {
            if (left == null) {
               return false
            } else {
                return left?.exist(value)
            }
        } else {
            if (right == null) {
                return false
            } else {
                return right?.exist(value)
            }
        }
    }

    fun print() {
        if (left != null) left?.print()
        println(data)
        if (right != null)  right?.print()
    }
}

fun main(args: Array<String>) {
    var tree = BinaryTree(10)
    tree.insert(23)
    tree.insert(3)
    tree.insert(44)
    tree.insert(2)
    tree.insert(223)
    tree.insert(223)
    tree.insert(25)
//    println("Node 1 exist: ${tree.exist(1)}")
//    println("Node 23 exist: ${tree.exist(23)}")
    tree.print()
    println(tree.isBST())

//    var node1 = Node(1)
//    var node2 = Node(2)
//    var node3 = Node(3)
//    var node4 = Node(4)
//    var node5 = Node(5)
//    var node6 = Node(6)
//
//    node1.children = listOf(node2, node4)
//    node2.children = listOf(node3)
//    node3.children = listOf(node1)
//    node4.children = emptyList()
//
//    println(node1.find(node4))
//
//    println(search(node1, node4))

}

enum class State {
    Unvisited, Visited, Visiting
}

fun search(start: Node, end: Node) : Boolean {
    if (start == end) return true
    var queue = LinkedList<Node>()

    start.state = State.Visiting
    queue.add(start)

    var u: Node
    while (!queue.isEmpty()) {
        u = queue.removeFirst()

        if (u != null) {
            for (node in u.children) {
                if (node.state == State.Unvisited) {
                    if (node == end) {
                        return true
                    } else {
                        node.state = State.Visiting
                        queue.add(node)
                    }
                }
            }
            u.state = State.Visited
        }
    }
    return false
}




