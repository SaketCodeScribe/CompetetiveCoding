package com.dsa_algorithms.Tree;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return root;
        TreeNode left = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(left);
        return root;
    }
}
