package com.dsa_algorithms.Tree;
import java.util.*;

public class TimeToBurnTree {
    static class BinaryTreeNode<T> {
        T data;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;

        public BinaryTreeNode(T data) {
            this.data = data;
        }
    }
    static class Tree<T>{
        T data;
        Tree<T> left;
        Tree<T> right;
        Tree<T> par;

        public Tree(T data){
            this.data = data;
        }
    }
    static Tree<Integer> begin = null;
    public static int timeToBurnTree(BinaryTreeNode<Integer> head, int start){
        int ans = 0;
        Tree<Integer> root = createTree(head, start);
        linkParent(root, null);
        Queue<Tree<Integer>> queue = new LinkedList<>();
        Map<Tree<Integer>, Boolean> map = new HashMap<>();
        queue.add(begin);
        map.put(begin, true);

        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                Tree<Integer> node = queue.poll();
                if (node.left != null && !map.getOrDefault(node.left, false)){
                    queue.add(node.left);
                    map.put(node.left, true);
                }
                if (node.right != null && !map.getOrDefault(node.right, false)){
                    queue.add(node.right);
                    map.put(node.right, true);
                }
                if (node.par != null && !map.getOrDefault(node.par, false)){
                    queue.add(node.par);
                    map.put(node.par, true);
                }
            }
            if (queue.isEmpty())
                break;
            ans++;
        }
        return ans;
    }
    public static Tree<Integer> createTree(BinaryTreeNode<Integer> root, int start){
        if (root == null)
            return null;
        Tree<Integer> tree = new Tree(root.data);
        tree.left = createTree(root.left, start);
        tree.right = createTree(root.right, start);
        if (root.data == start)
            begin = tree;
        return tree;
    }
    public static void linkParent(Tree<Integer> root, Tree<Integer> par){
        if (root == null)
            return;
        root.par = par;
        linkParent(root.left, root);
        linkParent(root.right, root);
    }
}
