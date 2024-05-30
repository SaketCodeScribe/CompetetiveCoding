package com.dsa_algorithms.Tree;

public class LCA {
    static class TreeNode<T>
    {
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
    public static int lowestCommonAncestor(TreeNode<Integer> root, int x, int y) {
        if (root == null)
            return -1;
        int left = lowestCommonAncestor(root.left, x, y);
        int right = lowestCommonAncestor(root.right, x, y);
        if (left != -1 && right != -1)
            return root.data;
        if ((left != -1 || right != -1) && (root.data == x || root.data == y))
            return root.data;
        return root.data == x || root.data == y ? root.data : (left != -1 ? left : right);
    }
}
