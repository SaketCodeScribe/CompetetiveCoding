package com.dsa_algorithms.Tree;

public class LC2096 {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder startPath = new StringBuilder(), destPath = new StringBuilder();
        traverse(root, startValue, destValue, startPath, destPath, new StringBuilder());
        int i = 0;

        while (i < Math.min(startPath.length(), destPath.length()) && startPath.charAt(i) == destPath.charAt(i)) {
            i++;
        }

        return "U".repeat(startPath.length() - i) + destPath.toString().substring(i, destPath.length());
    }

    private void traverse(TreeNode root, int start, int dest, StringBuilder startPath, StringBuilder destPath, StringBuilder path) {
        if (root == null) return;
        if (root.val == start) {
            startPath.append(path);
        }
        if (root.val == dest) {
            destPath.append(path);
        }
        path.append("L");
        traverse(root.left, start, dest, startPath, destPath, path);
        path.deleteCharAt(path.length() - 1);
        path.append("R");
        traverse(root.right, start, dest, startPath, destPath, path);
        path.deleteCharAt(path.length() - 1);
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
