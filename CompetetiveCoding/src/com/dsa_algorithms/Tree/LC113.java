package com.dsa_algorithms.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();

        preOrderTraversal(root, targetSum, ans, new Stack<>());
        return ans;
    }

    private void preOrderTraversal(TreeNode node, int target, List<List<Integer>> ans, Stack<Integer> temp) {
        if (node == null) return;
        temp.add(node.val);
        if (isLeafNode(node) && target - node.val == 0) {
            ans.add(new ArrayList<>(temp));
        } else {
            preOrderTraversal(node.left, target - node.val, ans, temp);
            preOrderTraversal(node.right, target - node.val, ans, temp);
        }
        temp.pop();
    }

    private boolean isLeafNode(TreeNode node) {
        return node != null && node.left == null && node.right == null;
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
