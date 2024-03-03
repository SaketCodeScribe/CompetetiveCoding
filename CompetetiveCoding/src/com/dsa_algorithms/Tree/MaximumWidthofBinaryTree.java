package com.dsa_algorithms.Tree;

import java.util.ArrayDeque;
import java.util.Deque;

class Node{
    int index;
    TreeNode node;
    public Node(TreeNode node, int index){
        this.index = index;
        this.node = node;
    }
}
public class MaximumWidthofBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        Deque<Node> queue = new LinkedList<Node>();
        queue.add(new Node(root,1));
        int l, mxWidth = 1;
        Node node=null;
        while(queue.size() > 0){
            l = queue.size();
            mxWidth = Math.max(mxWidth, queue.peekLast().index-queue.peekFirst().index+1);
            while(l-- > 0){
                node = queue.poll();
                if (node.node.left != null)
                    queue.add(new Node(node.node.left, 2*node.index));
                if (node.node.right != null)
                    queue.add(new Node(node.node.right, 2*node.index+1));
            }
        }
        return mxWidth;
    }
}
