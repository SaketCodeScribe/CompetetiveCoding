package com.dsa_algorithms.Tree;
import java.util.*;
public class BottomViewOfTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
    public static List<Integer> bottomView(TreeNode root) {
        // Write your code here.
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        Map<Integer, int[]> map = new TreeMap<>();

        Queue<Object[]> queue = new LinkedList<>();
        queue.add(new Object[]{root, 0, 0});

        while (!queue.isEmpty()) {
            Object[] current = queue.poll();
            TreeNode node = (TreeNode) current[0];
            int x = (int) current[1];
            int level = (int) current[2];

            if (!map.containsKey(x) || level >= map.get(x)[1]) {
                map.put(x, new int[]{node.val, level});
            }

            if (node.left != null) {
                queue.add(new Object[]{node.left, x - 1, level + 1});
            }
            if (node.right != null) {
                queue.add(new Object[]{node.right, x + 1, level + 1});
            }
        }

        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            ans.add(entry.getValue()[0]);
        }

        return ans;
    }
}
