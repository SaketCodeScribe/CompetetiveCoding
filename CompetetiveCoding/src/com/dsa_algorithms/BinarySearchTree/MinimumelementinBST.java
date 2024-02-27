package com.dsa_algorithms.BinarySearchTree;

public class MinimumelementinBST {
    public static int minValue(Node root) {
        if (root == null)
            return -1;
        // Write your code here.
        while(root.left != null)
            root = root.left;
        return root.data;
    }
}
