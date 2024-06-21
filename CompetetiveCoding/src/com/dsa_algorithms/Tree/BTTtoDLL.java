package com.dsa_algorithms.Tree;

public class BTTtoDLL {
    static  class BinaryTreeNode<T> {
        T data;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;

        public BinaryTreeNode(T data) {
            this.data = data;
        }
    }
    public static BinaryTreeNode<Integer> BTtoDLL(BinaryTreeNode<Integer> root) {
        // Write your code here
        if (root == null)
            return root;
        BinaryTreeNode<Integer> prev = null, curr, ans = null;

        while(root != null){
            if (root.left == null){
                if (prev != null){
                    prev.right = root;
                    root.left = prev;
                }
                if (ans == null)
                    ans = root;
                prev = root;
                root = root.right;
            }
            else{
                curr = root.left;
                while(curr.right != null && curr.right != root)
                    curr = curr.right;
                if (curr.right == null){
                    curr.right = root; root = root.left;
                }
                else{
                    prev.right = root;
                    root.left = null;
                    prev = root;
                    root = root.right;
                }
            }
        }
        return ans;
    }
    static BinaryTreeNode<Integer> ans = null, prev = null;
    public static BinaryTreeNode<Integer> BTtoDLL1(BinaryTreeNode<Integer> root) {
        // Write your code here
        ans = prev = null;
        convertDll(root);
        return ans;
    }
    public static void convertDll1(BinaryTreeNode<Integer> root){
        if (root == null)
            return;
        convertDll(root.left);
        if (prev == null)
            ans = root;
        else{
            prev.right = root;
            root.left = prev;
        }
        prev = root;
        convertDll(root.right);
    }
}
