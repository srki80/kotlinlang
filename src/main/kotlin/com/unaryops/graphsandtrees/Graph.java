package com.unaryops.graphsandtrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph<T> {
    public enum State { Visited, Visiting, Unvisited };
    public List<Node> nodes = new ArrayList<>();

    public static class Node<T> {
        private List<Node<T>> children;
        private T data;
        private State state;

        public Node(List<Node<T>> children, T data) {
            this.children = children;
            this.data = data;
            this.state = State.Unvisited;
        }

        public Node(T data) {
            this.children = new ArrayList<>();
            this.data = data;
            this.state = State.Unvisited;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public List<Node<T>> getChildren() {
            return children;
        }

        public void setChildren(List<Node<T>> children) {
            this.children = children;
        }
    }

    public boolean pathExistDFS(Node start, Node end) {
        if (start.state == State.Visited) return false;

        start.state = State.Visited;

        if (start == end) {
            return true;
        }

        for (Node child : (List<Node<T>>) start.children) {
            if (pathExistDFS(child, end)) {
                return true;
            }
        }

        return false;
    }

    public boolean pathExistBFS(Node start, Node end) {
        if (start == end) return true;

        LinkedList<Node> queue = new LinkedList<Node>();

        start.state = State.Visiting;
        queue.add(start);
        Node current;

        while (!queue.isEmpty()) {
            current = queue.removeFirst();
            if (current != null ) {
                for (Node child : (List<Node<T>>) current.getChildren()) {
                    if (child.state == State.Unvisited) {
                        if (child == end) {
                            return true;
                        } else {
                            child.state = State.Visiting;
                            queue.add(child);
                        }
                    }
                }

                current.state = State.Visited;
            }

        }
        return false;
    }

    public void add(Node node) {
        nodes.add(node);
    }
}
