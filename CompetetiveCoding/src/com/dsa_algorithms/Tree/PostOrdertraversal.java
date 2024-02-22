package com.dsa_algorithms.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrdertraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(null);
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                ans.add(root.val);
                stack.add(root);
                root = root.left;
            }
            root = stack.pop();
            if (root != null)
                root = root.right;
        }
        return ans;
    }
}
