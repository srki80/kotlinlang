package com.unaryops.graphsandtrees;

public class TreeNode1 {
    private int data;
    private TreeNode1 left;
    private TreeNode1 right;

    public TreeNode1(int data) {
        this.data = data;
    }

    public void insert(int value) {
        if (value <= data) {
            if (left == null) {
                left = new TreeNode1(value);
            } else {
                left.insert(value);
            }
        } else {
            if (right == null) {
                right = new TreeNode1(value);
            } else {
                right.insert(value);
            }
        }

    }

    public  boolean exist(int value) {
        if (value == data) {
            return true;
        } else if (value <= data) {
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
        if (left != null) left.print();
        System.out.println(data);
        if (right != null)  right.print();
    }

}
