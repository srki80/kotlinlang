package com.unaryops.graphsandtrees;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest {
    Graph<String> graph;
    Graph.Node<String> node1 = new Graph.Node<>("node 1");
    Graph.Node<String> node2 = new Graph.Node<>("node 2");
    Graph.Node<String> node3 = new Graph.Node<>("node 3");
    Graph.Node<String> node4 = new Graph.Node<>("node 4");
    Graph.Node<String> node5 = new Graph.Node<>("node 5");
    Graph.Node<String> node6 = new Graph.Node<String>("node 6");

    @BeforeEach
    public void setup() {
        graph = new Graph<>();
        node1.setChildren(Arrays.asList(node2, node4));
        node2.setChildren(Arrays.asList(node3));
        node3.setChildren(Arrays.asList(node1, node5));
        node4.setChildren(Arrays.asList());
        graph.add(node1);
        graph.add(node2);
        graph.add(node3);
        graph.add(node4);
        graph.add(node5);
    }

    @Test
    void pathExistDFS() {
        System.out.println(graph.pathExistDFS(node1, node5));
        System.out.println(graph.pathExistBFS(node1, node5));
    }

    @Test
    void add() {
    }

}