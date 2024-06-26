package com.dsa_algorithms.Trie;

import java.util.*;

class SortBym implements Comparator<int[]>{
@Override
public int compare(int[] a, int[] b){
    return a[1]-b[1];
}
}

public class MaximumXORWithanElementFromArray {
    static class TrieNodes {
        TrieNodes links[] = new TrieNodes[2];
        public TrieNodes() {}
        boolean containsKey(int ind) {
            return (links[ind] != null);
        }
        TrieNodes get(int ind) {
            return links[ind];
        }
        void put(int ind, TrieNodes node) {
            links[ind] = node;
        }
    }

    static class Trie {
        private static TrieNodes root;
        Trie() {
            root = new TrieNodes();
        }
        public static void insert(int num) {
            TrieNodes node = root;
            for(int i = 31;i>=0;i--) {
                int bit = (num >> i) & 1;
                if(!node.containsKey(bit)) {
                    node.put(bit, new TrieNodes());
                }
                node = node.get(bit);
            }
        }

        public int getMax(int num) {
            TrieNodes node = root;
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
