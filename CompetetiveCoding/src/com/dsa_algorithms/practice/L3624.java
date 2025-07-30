package com.dsa_algorithms.practice;

import java.util.*;

public class L3624 {
    class SegmentTree{
        Map<Integer, Integer>[] tree;

        public SegmentTree(int n){
            tree = new Map[4*n];
        }
        public void build(long[] nums, int left, int right, int treeIndex){
            if (tree[treeIndex] == null){
                tree[treeIndex] = new HashMap<>();
            }
            if (left == right){
                int popCount = getPopCount(nums[left]);
                tree[treeIndex].put(popCount, tree[treeIndex].getOrDefault(popCount, 0)+1);
                return;
            }
            int mid = left + (right - left)/2;
            build(nums, left, mid, 2*treeIndex+1);
            build(nums, mid+1, right, 2*treeIndex+2);
            populate(treeIndex);
        }

        private void populate(int index){
            Map<Integer, Integer> map = new HashMap<>();
            for(Map.Entry<Integer, Integer> entry:tree[2*index+1].entrySet()){
                map.put(entry.getKey(), entry.getValue());
            }
            for(Map.Entry<Integer, Integer> entry:tree[2*index+2].entrySet()){
                int key = entry.getKey(), value = entry.getValue();
                map.put(key, map.getOrDefault(key, 0)+value);
            }
            tree[index] = map;
        }

        public void update(long[] nums, int left, int right, int treeIndex, int i, long val){
            if (left == right){
                int popCount = getPopCount(val);
                int prevPopCount = getPopCount(nums[i]);
                int freq = tree[treeIndex].get(prevPopCount);
                nums[i] = val;
                if (freq == 1){
                    tree[treeIndex].remove(prevPopCount);
                }
                else{
                    tree[treeIndex].put(prevPopCount, freq-1);
                }
                tree[treeIndex].put(popCount, tree[treeIndex].getOrDefault(popCount, 0)+1);
                return;
            }
            int mid = left + (right - left)/2;
            if (i <= mid){
                update(nums, left, mid, 2*treeIndex+1, i, val);
            }
            else{
                update(nums, mid+1, right, 2*treeIndex+2, i, val);
            }
            populate(treeIndex);
        }
        public int rangeQuery(int left, int right, int leftQuery, int rightQuery, int treeIndex, int k){
            if (left > rightQuery || right < leftQuery){
                return 0;
            }
            if (left >= leftQuery && right <= rightQuery){
                return tree[treeIndex].getOrDefault(k, 0);
            }
            int mid = left + (right - left)/2;
            return rangeQuery(left, mid, leftQuery, rightQuery, 2*treeIndex+1, k) +
                    rangeQuery(mid+1, right, leftQuery, rightQuery, 2*treeIndex+2, k);
        }

    }
    int[] pcDepth;
    SegmentTree segmentTree;
    public L3624(){
        memoize();
    }
    public int[] popcountDepth(long[] nums, long[][] queries) {
        int n = nums.length, q = queries.length;
        segmentTree = new SegmentTree(n);
        segmentTree.build(nums, 0, n-1, 0);

        List<Integer> ans = new ArrayList<>();

        for(int i=0; i<q; i++){
            if (queries[i][0] == 1){
                ans.add(segmentTree.rangeQuery(0, n-1, (int)queries[i][1], (int)queries[i][2], 0, (int)queries[i][3]));
            }
            else{
                segmentTree.update(nums, 0, n-1, 0, (int)queries[i][1], queries[i][2]);
            }
        }
        return ans.stream().mapToInt(val -> val).toArray();
    }
    private void memoize(){
        pcDepth = new int[64];
        pcDepth[2] = 1;

        for(int i=3; i<64; i++){
            int bits = Integer.bitCount(i);
            pcDepth[i] = pcDepth[bits]+1;
        }
    }
    private int getPopCount(long val){
        int cnt = 0;
        while(val > 63){
            val = Long.bitCount(val);
            cnt++;
        }
        return cnt + pcDepth[(int)val];
    }
}
