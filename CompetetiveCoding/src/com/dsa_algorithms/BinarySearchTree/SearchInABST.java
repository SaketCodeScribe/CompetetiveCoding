package com.dsa_algorithms.BinarySearchTree;

import java.util.Stack;

public class SearchInABST {
    /*
        recursion procedure
     */
    public TreeNode searchBSTRecursion(TreeNode root, int val) {
        if (root == null || root.val == val)
            return root;
        if (root.val > val)
            return searchBST(root.left, val);
        return searchBST(root.right, val);
    }
    /*
        iteration procedure using stack.
     */

    public TreeNode searchBSTUsingIteration(TreeNode root, int val){
        Stack<TreeNode> stack = new Stack<>();
        stack.add(null);

        while (!stack.isEmpty() || root != null){
            while (root != null){
                if (root.val == val)
                    return root;
                stack.add(root);
                root = root.left;
            }
            root = stack.pop();
            if (root != null)
                root = root.right;
        }
        return null;
    }
}
