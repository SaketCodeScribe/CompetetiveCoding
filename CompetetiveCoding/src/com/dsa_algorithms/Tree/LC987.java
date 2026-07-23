package com.dsa_algorithms.Tree;


import java.util.*;

public class LC987 {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, List<int[]>> treeMap = new TreeMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr;

        inorderTraversal(root, treeMap, 0, 0);

        for (Map.Entry<Integer, List<int[]>> entry : treeMap.entrySet()) {
            Collections.sort(entry.getValue(), (a, b) -> {
                int compare = Integer.compare(a[0], b[0]);
                return compare == 0 ? Integer.compare(a[1], b[1]) : compare;
            });
            curr = new ArrayList<>();
            for (int[] val : entry.getValue()) curr.add(val[1]);
            ans.add(curr);
        }
        return ans;
    }

    public void inorderTraversal(TreeNode root, TreeMap<Integer, List<int[]>> treeMap, int row, int col) {
        if (root == null) return;
        treeMap.compute(col, (k, v) -> {
            if (v == null) v = new ArrayList<>();
            v.add(new int[]{row, root.val});
            return v;
        });
        inorderTraversal(root.left, treeMap, row + 1, col - 1);
        inorderTraversal(root.right, treeMap, row + 1, col + 1);
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
