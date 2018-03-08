package com.unaryops.graphsandtrees;

public class BinaryTree {
    public int data;
    public BinaryTree left;
    public BinaryTree right;

    public BinaryTree(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public void insert(int value) {
        if (value <= data) {
            if (left == null) {
                left = new BinaryTree(value);
            } else {
                left.insert(value);
            }
        } else {
            if (right == null) {
                right = new BinaryTree(value);
            } else {
                right.insert(value);
            }
        }
    }

    public void insertOutOfOrder(int value) {
        if (left == null) {
            left  = new BinaryTree(value);
        } else if (right == null) {
            right = new BinaryTree(value);
        } else {
            left.insertOutOfOrder(value);
        }
    }

    public void print() {
        if (left != null) {
            left.print();
        }
        System.out.println(data);
        if (right != null) {
            right.print();
        }
    }

    public boolean isBST() {
        if (left != null) {
            if (left.data > data) {
                return false;
            } else {
                return left.isBST();
            }
        } else if (right != null) {
            if (right.data < data) {
                return false;
            } else {
                return left.isBST();
            }
        }
        return true;
    }
}
