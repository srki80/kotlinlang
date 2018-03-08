package com.unaryops.graphsandtrees;

import java.util.LinkedList;
import java.util.List;

public class Node {
    public int value;
    public List<Node> children;
    public State state;
    public Node(int value) {
        this.value = value;
        this.state = State.Unvisited;
    }

    public Node(int value, List<Node> children) {
        this.value = value;
        this.children = children;
        this.state = State.Unvisited;
    }

    public boolean find(Node node) {
        if (state == State.Visited) {
            return false;
        }
        state = State.Visited;

        if (this == node) {
            return true;
        }

        for (Node child : children) {
            if (child.find(node)) {
                return true;
            }
        }

        return false;
    }

    public Node search(Node node) {
        if (this == node) return node;

        state = State.Visiting;
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(this);

        Node current;
        while (!queue.isEmpty()) {
            current= queue.removeFirst();

            if (current != null) {
                for (Node child : current.children) {
                    if (child.state == State.Unvisited) {
                        if (child == node) {
                            return node;
                        } else {
                            child.state = State.Visiting;
                            queue.add(child);
                        }
                    }
                }
                current.state = State.Visited;
            }
        }
        return null;
    }
}
