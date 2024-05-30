package com.dsa_algorithms.Tree;

import java.util.*;

public class LeftViewOfBinaryTree {
    static class TreeNode<T>{
        T data;
        TreeNode<T> left;
        TreeNode<T> right;
        TreeNode(T data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
    public static void printLeftView(TreeNode<Integer> root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            System.out.print(queue.peek().data+" ");
            while(size-- > 0){
                TreeNode node = queue.poll();
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
        }
    }
}
