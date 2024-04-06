package com.dsa_algorithms.Graph;

import java.util.*;

public class CloneGraph {
    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
    Map<Integer, Node> map;
    public Node cloneGraph(Node node) {
        map = new HashMap<>();
        return clone(node);
    }

    public Node clone(Node node){
        if (node == null)
            return null;
        if (map.get(node.val) != null)
            return map.get(node.val);
        Node cloneNode = new Node(node.val);
        map.put(node.val, cloneNode);
        for(Node child:node.neighbors)
            cloneNode.neighbors.add(clone(child));
        return cloneNode;
    }
}
