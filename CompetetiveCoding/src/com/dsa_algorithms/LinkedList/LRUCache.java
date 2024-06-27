package com.dsa_algorithms.LinkedList;

import java.util.*;

public class LRUCache {
    static class Node{
        int data;
        Node left, right;
        public Node(int data){
            this.data = data;
        }
    }
    Node head, tail;
    Map<Integer, Node> map;
    int size, capacity;

    public LRUCache(int sizeOfCache) {
        this.capacity = sizeOfCache;
        map = new HashMap<>();
        head = tail = null;
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        Node node = map.get(key);
        deleteNode(node);
        addToRear(node);
        return node.data;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)){
            Node node = map.get(key);
            node.data = value;
            deleteNode(node);
            addToRear(node);
        }
        else{
            Node node = new Node(value);
            if (size == capacity){
                map.remove(head.data);
                deleteNode(head);
            }
            else
                size++;
            addToRear(node);
            map.put(key, node);
        }
    }

    public void deleteNode(Node node){
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
    }
    public void addToRear(Node node){
        if (head == null)
            head = tail = node;
        else{
            tail.right = node;
            node.left = tail;
            tail = node;
        }
    }
}
