package com.dsa_algorithms.BinarySearchTree;

public class LCAinaBST {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode() {
            this.data = 0;
            this.left = null;
            this.right = null;
        }
        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
        TreeNode(int data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    public static TreeNode LCAinaBST(TreeNode root, TreeNode P, TreeNode Q) {
        // Write your code here.
        if (P == null || Q == null || !isExists(root, P) || !isExists(root, Q))
            return null;
        return LCA(root, P.data < Q.data ? P : Q, P.data > Q.data ? P : Q);
    }
    public static boolean isExists(TreeNode root, TreeNode p){
        if (root == null)
            return false;
        if (p == root)
            return true;
        return p.data < root.data ? isExists(root.left, p) : isExists(root.right, p);
    }
    public static TreeNode LCA(TreeNode root, TreeNode p, TreeNode q){
        if (root == null)
            return null;
        if ((root.data > p.data && root.data < q.data) || root.data == p.data || root.data == q.data)
            return root;
        return p.data < root.data ? LCA(root.left, p, q) : LCA(root.right, p, q);
    }
}
