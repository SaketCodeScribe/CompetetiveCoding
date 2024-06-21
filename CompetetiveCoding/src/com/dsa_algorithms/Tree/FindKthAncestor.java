package com.dsa_algorithms.Tree;

import java.util.*;
public class FindKthAncestor {
    static class BinaryTreeNode<T> {
        T data;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;

        public BinaryTreeNode(T data) {
            this.data = data;
        }
    }
    static int findKthAncestor(BinaryTreeNode<Integer> root, int targetNodeVal, int k) {
        // Write your code here.
        List<Integer> path = rootToNode(root, targetNodeVal);
        return k >= path.size() ? -1 : path.get(k);
    }
    static List<Integer> rootToNode(BinaryTreeNode<Integer> root, int tar){
        List<Integer> temp = new ArrayList();
        if (root == null)
            return temp;
        if (root.data == tar){
            temp.add(root.data);
            return temp;
        }
        List<Integer> left = rootToNode(root.left, tar);
        List<Integer> right = rootToNode(root.right, tar);
        if (left.size() > 0){
            left.add(root.data);
            return left;
        }
        if (right.size() > 0){
            right.add(root.data);
            return right;
        }
        return temp;
    }
}
