package com.unaryops.graphsandtrees;

public class TreeNodeJava {
    private int data;
    private TreeNodeJava left;
    private TreeNodeJava right;

    public TreeNodeJava(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public void insert(int value) {
        if (value < data) {
            if (left != null) {
                left.insert(value);
            } else {
                left = new TreeNodeJava(value);
            }
        } else {
            if (right != null) {
                right.insert(value);
            } else {
                right = new TreeNodeJava(value);
            }
        }
    }

    public boolean exist(int value) {
        if (data == value) {
            return true;
        } else if (data <= value) {
            if (left != null) {
                return left.exist(value);
            } else {
                return false;
            }
        } else {
            if (right != null) {
                return right.exist(value);
            } else {
                return false;
            }
        }
    }

    public void print() {
        if (left != null)  left.print();
        System.out.println(data);
        if (right != null)  right.print();
    }

}

