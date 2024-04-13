package com.dsa_algorithms.DynamicProgramming;

import java.util.*;
public class UniqueBinarySearchTrees2 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
             this.left = left;
             this.right = right;
        }
    }
    Map<int[], List<TreeNode>> map;
    public List<TreeNode> generateTrees(int n) {
        map = new HashMap<>();
        return generateTrees(1, n);
    }
    public List<TreeNode> generateTrees(int l, int r) {
        List<TreeNode> temp = new ArrayList<>();
        TreeNode node = null;
        if (l == r){
            temp.add(new TreeNode(l));
            return temp;
        }
        if (l > r){
            temp.add(node);
            return temp;
        }
        if (map.get(new int[]{l,r}) != null)
            return map.get(new int[]{l,r});

        for(int i=l; i<=r; i++){
            List<TreeNode> lefts = generateTrees(l, i-1);
            List<TreeNode> rights = generateTrees(i+1,r);
            for(TreeNode left_:lefts){
                for(TreeNode right_:rights){
                    node = new TreeNode(i);
                    node.left = left_;
                    node.right = right_;
                    temp.add(node);
                }
            }
        }
        map.put(new int[]{l,r}, temp);
        return temp;
    }
}
