package com.dsa_algorithms.Tree;

import java.util.ArrayList;
import java.util.List;

public class LC1382 {
    public TreeNode balanceBST(TreeNode root) {
        List<TreeNode> nodes = new ArrayList<>();
        inorder(root, nodes);

        return balanceBST(nodes, 0, nodes.size() - 1);
    }

    private void inorder(TreeNode node, List<TreeNode> nodes) {
        if (node == null) return;

        inorder(node.left, nodes);
        nodes.add(node);
        inorder(node.right, nodes);
    }

    private TreeNode balanceBST(List<TreeNode> nodes, int low, int high) {
        if (low == high) {
            TreeNode node = nodes.get(low);
            node.left = node.right = null;
            return node;
        }
        if (low > high) return null;
        int mid = low + (high - low) / 2;
        TreeNode left = balanceBST(nodes, low, mid - 1);
        TreeNode right = balanceBST(nodes, mid + 1, high);
        TreeNode node = nodes.get(mid);
        node.left = left;
        node.right = right;
        return node;
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
