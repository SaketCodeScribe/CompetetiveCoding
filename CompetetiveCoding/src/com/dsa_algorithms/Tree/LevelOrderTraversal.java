package com.dsa_algorithms.Tree;

import java.util.*;
public class LevelOrderTraversal {
    static class TreeNode{
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
    List<List<Integer>> ans;
    public List<List<Integer>> levelOrder(TreeNode root) {
        ans = new ArrayList<>();
        dfsTraversal(0, root);
        return ans;
    }
    public void dfsTraversal(int level, TreeNode root){
        if (root == null)
            return;
        if (level == ans.size())
            ans.add(new ArrayList<>());
        ans.get(level).add(root.val);
        dfsTraversal(level+1, root.left);
        dfsTraversal(level+1, root.right);
    }
}
