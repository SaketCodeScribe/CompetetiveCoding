package com.dsa_algorithms.Tree;

/*
    https://www.geeksforgeeks.org/remove-nodes-from-binary-tree-such-that-sum-of-all-remaining-root-to-leaf-paths-is-atleast-k/
 */

public class RemoveNodesToMakeSumAtLeastK {
    public static TreeNode removeNodes(TreeNode root, int sum, int k) {
        if (root == null)
            return root;
        if (root.left == null && root.right == null) {
            if (sum + root.val < k)
                return null;
            return root;
        }
        root.left = removeNodes(root.left, sum + root.val, k);
        root.right = removeNodes(root.right, sum + root.val, k);
        if (root.left == null && root.right == null)
            return null;
        return root;
    }

    public static void viewTree(TreeNode node) {
        // If node is not NULL
        if (node != null) {

            // Print the node
            System.out.print(node.val + " ");

            // Left and Right Traversal
            viewTree(node.left);
            viewTree(node.right);
        }
    }

    public static void main(String[] args) {
        int K = 27;

        // Object of class path

        // Given Binary Tree
        TreeNode root = null;
        root = new TreeNode(5);
        root.right = new TreeNode(3);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(9);
        root.right.right = new TreeNode(9);
        root.left.right = new TreeNode(8);
        root.left.right.right = new TreeNode(11);
        root.left.right.left = new TreeNode(5);
        root.left.right.left.left = new TreeNode(6);
        root.left.right.left.right = new TreeNode(2);
        root.right.right.right = new TreeNode(4);

        System.out.println("Before removal:");
        viewTree(root);
        System.out.println();

        root = RemoveNodesToMakeSumAtLeastK.removeNodes(
                root, 0, K);
        System.out.println("After removal");
        viewTree(root);
    }
}
