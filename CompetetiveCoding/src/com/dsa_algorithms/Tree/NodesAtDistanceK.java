package com.dsa_algorithms.Tree;

import java.util.*;
public class NodesAtDistanceK {
    static class BinaryTreeNode<T> {

        T data;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;

        BinaryTreeNode(T data) {
            this.data = data;
            left = null; right = null;
        }
    }
    static List<BinaryTreeNode<Integer>> ans;
    public static List<BinaryTreeNode<Integer>> printNodesAtDistanceK(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> target, int k) {
        List<BinaryTreeNode<Integer>> path = rootToNode(root, target);
        ans = new ArrayList<>();

        int i, n = path.size();
        for(i=0; i<n; i++){
            getKNodes(path.get(i), i > 0 ? path.get(i-1) : null, 0, k-i);
        }
        return ans;
    }
    public static List<BinaryTreeNode<Integer>> rootToNode(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> tar){
        List<BinaryTreeNode<Integer>> temp = new ArrayList<>();
        if (root == null)
            return temp;
        if (root == tar){
            temp.add(root);
            return temp;
        }
        List<BinaryTreeNode<Integer>> left = rootToNode(root.left, tar);
        if (left.size() > 0){
            left.add(root);
            return left;
        }
        List<BinaryTreeNode<Integer>> right = rootToNode(root.right, tar);
        if (right.size() > 0){
            right.add(root);
            return right;
        }
        return temp;
    }
    public static void getKNodes(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> prev, int depth, int k){
        if (root == null)
            return;
        if (depth == k)
            ans.add(root);
        if (root.left != prev)
            getKNodes(root.left, prev, depth+1, k);
        if (root.right != prev)
            getKNodes(root.right, prev, depth+1, k);
    }
}
