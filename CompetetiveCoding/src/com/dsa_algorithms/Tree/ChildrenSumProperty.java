package com.dsa_algorithms.Tree;

public class ChildrenSumProperty {
    static class Node{
        int data;
        Node left, right;
        public Node(int data){
            this.data = data;
        }
    }
    public static boolean isParentSum(Node root) {
        // Write your code here.
        if (root == null)
            return true;
        if (root.left == null && root.right == null)
            return true;
        return isParentSum(root.left) && isParentSum(root.right) && (root.data == (root.left != null ? root.left.data : 0)+(root.right != null ? root.right.data : 0));
    }
}
