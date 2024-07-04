package com.dsa_algorithms.Array;

public class DesignHashMap {
    static class Node{
        int key, value;
        Node next;
        public Node(int k, int v){
            key = k; value = v;
        }
    }
    int primeNo = 2069;
    Node head;
    Node[] bucket;
    public DesignHashMap() {
        bucket = new Node[primeNo];
        head = null;
    }

    public void put(int key, int value) {
        int hashKey = key%primeNo;
        if (bucket[hashKey] == null)
            bucket[hashKey] = new Node(key, value);
        else{
            Node curr = bucket[hashKey], prev = null;
            while(curr != null){
                if (curr.key == key){
                    curr.value = value;
                    break;
                }
                prev = curr;
                curr = curr.next;
            }
            if (curr == null)
                prev.next = new Node(key, value);
        }
    }

    public int get(int key) {
        int hashKey = key%primeNo;
        Node curr = bucket[hashKey];
        while(curr != null){
            if (curr.key == key)
                return curr.value;
            curr = curr.next;
        }
        return -1;
    }

    public void remove(int key) {
        int hashKey = key%primeNo;
        Node curr = bucket[hashKey], prev = null;

        while(curr != null){
            Node next = curr.next;
            if (curr.key == key){
                if (prev != null)
                    prev.next = next;
                else
                    bucket[hashKey] = next;
                break;
            }
            prev = curr;
            curr = curr.next;
        }
    }
}
