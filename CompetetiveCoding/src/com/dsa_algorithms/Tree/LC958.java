package com.dsa_algorithms.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class LC958 {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null && !queue.isEmpty() && queue.peek() != null) return false;
            if (node == null) continue;
            queue.offer(node.left);
            queue.offer(node.right);
        }
        return true;
    }

    static class TreeNode {
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
}
