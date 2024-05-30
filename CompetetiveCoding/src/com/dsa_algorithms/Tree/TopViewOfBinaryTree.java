package com.dsa_algorithms.Tree;
import java.util.*;
public class TopViewOfBinaryTree {
    static class TreeNode{
        int data;
        TreeNode left, right;

        public TreeNode(int data){
            this.data = data;
        }
    }
    static class Pair{
        TreeNode node;
        int coord;

        public Pair(TreeNode node, int coord){
            this.node = node;
            this.coord = coord;
        }
    }
    public static List<Integer> getTopView(TreeNode root) {
        // Write your code here.
        int min = 1, max = 0;
        List<Integer> a = new ArrayList<>(), b = new ArrayList<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            int coord = pair.coord;
            TreeNode left = pair.node.left, right = pair.node.right;
            if (coord < min){
                a.add(pair.node.data);
                min = coord;
            }
            if (coord > max){
                b.add(pair.node.data);
                max = coord;
            }
            if (left != null)
                queue.add(new Pair(left, coord-1));
            if (right != null)
                queue.add(new Pair(right, coord+1));
        }
        Collections.reverse(a);
        a.addAll(b);
        return a;
    }
}
