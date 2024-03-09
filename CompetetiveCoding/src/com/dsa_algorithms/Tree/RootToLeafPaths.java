package com.dsa_algorithms.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class RootToLeafPaths {
    static List<String> ans;
    public static List<String> allRootToLeaf(BinaryTreeNode root) {
        // Write your code here.
        ans = new ArrayList<>();
        allRootToLeaf(new ArrayList<String>(), root);
        return ans;
    }

    public static void allRootToLeaf(List<String> path, BinaryTreeNode root){
        if (root == null)
            return;
        if (root.left == null && root.right == null){
            path.add(root.data+"");
            ans.add(path.stream().collect(Collectors.joining(" ")));
            path.remove(path.size()-1);
            return;
        }
        path.add(root.data+"");
        allRootToLeaf(path, root.left);
        allRootToLeaf(path, root.right);
        path.remove(path.size()-1);
        return;
    }
}
