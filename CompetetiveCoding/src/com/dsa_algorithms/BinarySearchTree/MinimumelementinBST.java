package com.dsa_algorithms.BinarySearchTree;

public class MinimumelementinBST {
    static class Node
    {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
    public static int minValue(Node root) {
        if (root == null)
            return -1;
        // Write your code here.
        while(root.left != null)
            root = root.left;
        return root.data;
    }
}
