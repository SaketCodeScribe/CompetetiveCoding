package com.dsa_algorithms.LinkedList;

import java.util.* ;

public class LFUCache {
    static class Node{
        int data;
        Node left, right;
        public Node(int data){
            this.data = data;
        }
    }
    static class Pair{
        Node node;
        int freq;
        public Pair(Node node, int freq){
            this.node = node;
            this.freq = freq;
        }
    }
    static class PairNode{
        Node head, tail;
        public PairNode(Node head, Node tail){
            this.head = head;
            this.tail = tail;
        }
    }
    Map<Integer, Pair> map; // key to pair(node,freq)
    TreeMap<Integer, PairNode> lru; // freq to lru(head, tail)
    int size, capacity;
    LFUCache(int capacity) {
        // Write your code here.
        this.capacity = capacity;
        map = new HashMap<>();
        lru = new TreeMap<>();
    }

    int get(int key) {
        // Write your code here.
        if (!map.containsKey(key))
            return -1;
        Pair pair = map.get(key); // get pair
        int freq = pair.freq; // freq
        Node node = pair.node; // node
        PairNode pairNode = lru.get(freq); //get lru(head, tail)
        Node head = pairNode.head; Node tail = pairNode.tail;

        deleteNode(head, tail, node, freq); // delete node, need to update lru

        pair.freq = ++freq; // update freq
        pairNode = lru.getOrDefault(freq, new PairNode(null, null)); // lruNode for next freq
        head = pairNode.head; tail = pairNode.tail;
        addtoRear(head, tail, node, freq); // add node to lru, need to update lru
        return pair.node.data;
    }

    void put(int key, int value) {
        // Write your code here.
        if (map.containsKey(key)){
            Pair pair = map.get(key);
            pair.node.data = value;
            get(key);
        }
        else{
            Node node = new Node(value);
            Pair pair = new Pair(node, 1);
            if (size == capacity){
                int smfreq = lru.firstKey(); // get lf lru
                PairNode pairNode = lru.get(smfreq); // lrunode
                Node head = pairNode.head; Node tail = pairNode.tail;
                int k = head.data;
                deleteNode(head, tail, head, smfreq); // delete head and update lru
                map.remove(k); // remove key from map
            }
            else
                size++;
            map.put(key, pair); // insert key
            PairNode pairNode = lru.getOrDefault(1, new PairNode(null, null)); // retrieve lru
            Node head = pairNode.head; Node tail = pairNode.tail;
            addtoRear(head, tail, node, 1); // add node to lru and update it.
        }
    }
    public void deleteNode(Node head, Node tail, Node node, int key){
        Node left = node.left, right = node.right;
        node.left = node.right = null;
        if (left != null)
            left.right = right;
        else
            head = right;
        if (right != null)
            right.left = left;
        else
            tail = left;
        if (head == null)
            lru.remove(key);
        else
            lru.put(key, new PairNode(head, tail));
    }

    public void addtoRear(Node head, Node tail, Node node, int key){
        if (head == null)
            head = tail = node;
        else{
            tail.right = node;
            node.left = tail;
            tail = node;
        }
        lru.put(key, new PairNode(head, tail));
    }
}
