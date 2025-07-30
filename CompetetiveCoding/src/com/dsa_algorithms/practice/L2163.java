package com.dsa_algorithms.practice;

import java.util.TreeMap;

public class L2163 {
    public long minimumDifference(int[] nums) {
        int i, m = nums.length, n = m/3;
        long leftSum = 0, rightSum = 0, size = 0;
        TreeMap<Integer, Integer> left = new TreeMap<>(),
                minRight = new TreeMap<>(), maxRight = new TreeMap<>();

        for(i=0; i<m; i++){
            if (i < n){
                leftSum += nums[i];
                add(left, nums[i]);
            }
            else{
                if (size < n){
                    add(minRight, nums[i]);
                    size++;
                    rightSum += nums[i];
                }
                else if (minRight.firstKey() < nums[i]){
                    int removed = minRight.firstKey();
                    remove(minRight, removed);
                    rightSum -= removed;
                    add(maxRight, removed);
                    add(minRight, nums[i]);
                    rightSum += nums[i];
                }
                else{
                    add(maxRight, nums[i]);
                }
            }
        }

        long ans = leftSum - rightSum;
        for(i=n; i<m-n; i++){
            if (left.lastKey() > nums[i]){
                int lastKey = left.lastKey();
                leftSum += nums[i]-lastKey;
                left.put(lastKey, left.getOrDefault(lastKey,0)-1);
                if (left.get(lastKey) == 0){
                    left.remove(lastKey);
                }
                add(left, nums[i]);
            }
            if (minRight.containsKey(nums[i])){
                rightSum -= nums[i];
                minRight.put(nums[i], minRight.get(nums[i])-1);
                if (minRight.get(nums[i]) == 0){
                    minRight.remove(nums[i]);
                }
                size--;
            }
            else {
                maxRight.put(nums[i], maxRight.get(nums[i])-1);
                if (maxRight.get(nums[i]) == 0){
                    maxRight.remove(nums[i]);
                }
            }
            if (size < n){
                int lastKey = maxRight.lastKey();
                rightSum += lastKey;
                maxRight.put(lastKey, maxRight.get(lastKey)-1);
                if (maxRight.get(lastKey) == 0){
                    maxRight.remove(lastKey);
                }
                add(minRight, lastKey);
                size++;
            }
            // if (i >= m-n-10)
            if (leftSum-rightSum == -19595075){
                System.out.println(i);
            }

            ans = Math.min(ans, leftSum - rightSum);
        }
        return ans;
    }

    private static void remove(TreeMap<Integer, Integer> map, int key) {
        int freq = map.get(key);
        if (freq == 1){
            map.remove(key);
        }
        else{
            map.put(key, key-1);
        }
    }

    private static void add(TreeMap<Integer, Integer> map, int key) {
        map.put(key, map.getOrDefault(key, 0)+1);
    }

    public static void main(String[] args) {
        L2163 obj = new L2163();
        System.out.println(obj.minimumDifference(new int[]{16,46,43,41,42,14,36,49,50,28,38,25,17,5,18,11,14,21,23,39,23}));
//        System.out.println(obj.minimumDifference(new int[]{3,1,2}));
    }
}
