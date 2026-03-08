package com.dsa_algorithms.Trie;

import java.util.Arrays;

public class LC2935 {
    static class Node{
        BitTrie bitTrie;
        int cnt = 0;
        public Node(){
            bitTrie = new BitTrie();
        }
    }
    static class BitTrie{
        Node[] node;

        public BitTrie(){
            node = new Node[2];
        }
        private int getSetBit(int num, int i){
            return (num & (1<<i)) > 0 ? 1 : 0;
        }
        public void offer(int num){
            BitTrie head = this;
            for(int i=31; i>=0; i--){
                int bit = getSetBit(num, i);
                if (head.node[bit] == null){
                    head.node[bit] = new Node();
                }
                head.node[bit].cnt++;
                head = head.node[bit].bitTrie;
            }
        }
        public void remove(int num){
            BitTrie head = this;
            for(int i=31; i>=0 && head != null; i--){
                int bit = getSetBit(num, i);
                head.node[bit].cnt--;
                if (head.node[bit].cnt == 0){
                    head.node[bit] = null;
                    head = null;
                }else head = head.node[bit].bitTrie;
            }
        }
        public int getMaxXORElementOfNumber(int num){
            int i = 0, value = 0, half = num%2 == 0 ? num / 2 : num /2 + 1;
            Integer ceil;
            BitTrie head = this;

            while(i<32 && getSetBit(num, 31-i) == 0){
                head = head.node[0].bitTrie;
                i++;
            }
            while(i<32){
                int bit = getSetBit(num, 31-i), complementBit = bit^1;
                value <<= 1;
                if (head.node[complementBit] != null && head.node[complementBit].cnt > 0){
                    head = head.node[complementBit].bitTrie;
                    value++;
                }
                else if (head.node[bit] != null && head.node[bit].cnt > 0) head = head.node[bit].bitTrie;
                else return 0;
                i++;
            }
            return value;
        }
    }
    public int maximumStrongPairXor(int[] nums) {
        int ans = 0, i = 0, j = 0, n = nums.length;
        BitTrie bitTrie = new BitTrie();
        Arrays.sort(nums);

        while(i<n && j<=i){
            while(i<n && nums[i] <= 2*nums[j]){
                bitTrie.offer(nums[i]);
                ans = Math.max(ans, bitTrie.getMaxXORElementOfNumber(nums[i++]));
            }
            bitTrie.remove(nums[j++]);
        }
        return ans;
    }
}
