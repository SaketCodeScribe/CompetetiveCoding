package com.dsa_algorithms.Trie;

import java.util.*;

class SortBym implements Comparator<int[]>{
@Override
public int compare(int[] a, int[] b){
    return a[1]-b[1];
}
}
class Node {
    Node links[] = new Node[2];
    public Node() {}
    boolean containsKey(int ind) {
        return (links[ind] != null);
    }
    Node get(int ind) {
        return links[ind];
    }
    void put(int ind, Node node) {
        links[ind] = node;
    }
}
class Trie {
    private static Node root;
    Trie() {
        root = new Node();
    }
    public static void insert(int num) {
        Node node = root;
        for(int i = 31;i>=0;i--) {
            int bit = (num >> i) & 1;
            if(!node.containsKey(bit)) {
                node.put(bit, new Node());
            }
            node = node.get(bit);
        }
    }

    public int getMax(int num) {
        Node node = root;
        int maxNum = 0;
        for(int i = 31;i>=0 && node != null;i--) {
            int bit = (num >> i) & 1;
            if(node.containsKey(1 - bit)) {
                maxNum = maxNum | (1<<i);
                node = node.get( 1 - bit);
            }
            else {
                node = node.get(bit);
            }
        }
        return maxNum;
    }
}

public class MaximumXORWithanElementFromArray {
    private Trie trie;
    public int[] maximizeXor(int[] nums, int[][] queries) {
        int i = 0;
        Arrays.sort(nums);
        Trie trie = new Trie();
        Map<int[], Integer> map = new HashMap<>();
        for(i=0; i<queries.length; i++)
            map.put(queries[i], i);
        Arrays.sort(queries, new SortBym());
        int[] ans = new int[queries.length];
        i=0;
        for(int[] query:queries){
            while(i<nums.length){
                if (nums[i] <= query[1])
                    trie.insert(nums[i++]);
                else
                    break;
            }
            if (query[1] < nums[0])
                ans[map.get(query)] = -1;
            else
                ans[map.get(query)] = trie.getMax(query[0]);
        }
        return ans;
    }
}
