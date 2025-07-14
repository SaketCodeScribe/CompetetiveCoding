package com.dsa_algorithms.Contest.biweekly.biweekly159;

import java.util.*;
public class Solution3 {
    public int primeSubarray(int[] nums, int k) {
        int n = nums.length, i, start = -1, ans = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        TreeMap<Integer, Integer> tree = new TreeMap<>();
        boolean[] isPrime = new boolean[n];

        extractPrime(nums, n, isPrime);

        for(i=0; i<n; i++){
            if (isPrime[i]){
                while(!deque.isEmpty()){
                    int max = tree.lastKey();
                    int min = tree.firstKey();
                    if (Math.abs(max-nums[i]) > k){
                        start = removeFromDeque(deque, nums, tree);
                    }
                    else if (Math.abs(min-nums[i]) > k){
                        start = removeFromDeque(deque, nums, tree);
                    }
                    else{
                        break;
                    }
                }
                if (deque.size() > 0){
                    ans += deque.peekLast()-start;
                }
                deque.offerLast(i);
                tree.put(nums[i], tree.getOrDefault(nums[i], 0)+1);
            }
            else if (deque.size() > 1){
                int last = deque.pollLast();
                ans += deque.peekLast() - start;
                deque.offerLast(last);
            }
        }
        return ans;
    }

    private static int removeFromDeque(Deque<Integer> deque, int[] nums, TreeMap<Integer, Integer> tree) {
        int start = deque.pollFirst();
        int key = nums[start];
        if (tree.get(key) > 1) {
            tree.put(key, tree.get(key) - 1);
        } else {
            tree.remove(key);
        }
        return start;
    }

    private static void extractPrime(int[] nums, int n, boolean[] isPrime) {
        int i;
        for(i=0; i< n; i++){
            isPrime[i] = true;
            if (nums[i] == 1){
                isPrime[i] = false;
                continue;
            }
            for(int j = 2; j<=Math.sqrt(nums[i]); j++){
                if (nums[i]%j == 0){
                    isPrime[i] = false;
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
    }
}
