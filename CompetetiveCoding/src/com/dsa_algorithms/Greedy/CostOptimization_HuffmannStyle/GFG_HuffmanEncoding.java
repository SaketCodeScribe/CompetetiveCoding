package com.dsa_algorithms.Greedy.CostOptimization_HuffmannStyle;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class GFG_HuffmanEncoding {
    static class Node{
        long frequency;
        Character ch;
        Node left, right;
        public Node(long freq, char ch){
            this.frequency = freq;
            this.ch = ch;
        }
        public Node(long freq){
            this.frequency = freq;
        }
        @Override
        public String toString(){
            return "["+ch+","+frequency+"]";
        }
    }
    public ArrayList<String> huffmanCodes(String S, int f[], int N) {
        ArrayList<String> ans = new ArrayList<>();
        Node huffmanTree = createHuffmanTree(S, f);

        preOrderTraversal(huffmanTree, "", ans);
        return ans;
    }
    private Node createHuffmanTree(String s, int[] f){
        PriorityQueue<Node> pq =
                new PriorityQueue<>((a, b) -> a.frequency != b.frequency ? Long.compare(a.frequency, b.frequency) : 1);
        for (int i = 0; i < f.length; i++) {
            pq.offer(new Node(f[i], s.charAt(i)));
        }

        while (pq.size() > 1) {
            Node a = pq.poll();
            Node b = pq.poll();
            Node parent = new Node(a.frequency + b.frequency);
            parent.left = a;
            parent.right = b;
            pq.offer(parent);
        }
        return pq.isEmpty() ? null : pq.poll();
    }
    private void preOrderTraversal(Node node, String path, ArrayList<String> ans){
        if (node == null){
            return;
        }
        if (node.left == null && node.right == null){
            ans.add(path);
            return;
        }
        preOrderTraversal(node.left, path+"0", ans);
        preOrderTraversal(node.right, path+"1", ans);
    }
}
