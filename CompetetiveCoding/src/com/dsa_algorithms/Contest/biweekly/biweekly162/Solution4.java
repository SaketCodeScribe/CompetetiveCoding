//package com.dsa_algorithms.Contest.biweekly.biweekly162;
//
//import java.util.*;
//
//public class Solution4 {
//    static class SegmentTree{
//        TreeMap<Integer, Integer>[] tree;
//        public SegmentTree(int n){
//            tree = new TreeMap[4*n];
//        }
//        public void build(int[] nums, int l, int r, int i){
//            if (tree[i] == null){
//                tree[i] = new TreeMap<>();
//            }
//            if (l == r) {
//                System.out.println(l+" "+r+" "+tree[i]);
//                tree[i].put(1, nums[l]);
//                return;
//            }
//            int mid = l+(r-l)/2;
//            build(nums, l, mid, 2*i+1);
//            build(nums, mid+1, r, 2*i+2);
//            update(i);
//            System.out.println(l+" "+r+" "+tree[i]);
//        }
//        private void update(int i){
//            TreeMap<Integer, Integer> left = tree[2*i+1];
//            TreeMap<Integer, Integer> right = tree[2*i+2];
//            TreeMap<Integer, Integer> map = new TreeMap<>();
//
//            Map<Integer, Integer> mp = new HashMap<>();
//
//            for(Map.Entry<Integer, Integer> e:left.entrySet()){
//                mp.put(e.getValue(), e.getKey());
//            }
//            for(Map.Entry<Integer, Integer> e:right.entrySet()){
//                if (mp.containsKey(e.getValue())){
//                    if (left.get())
//                }
//            }
//            for(Map.Entry<Integer, Integer>e:mp.entrySet()){
//                map.put(e.getValue(), Math.min(e.getKey(),
//                        map.getOrDefault(e.getValue(), Integer.MAX_VALUE)));
//            }
//            tree[i] = map;
//        }
//        public int rangeQuery(int l, int r, int lq, int rq, int k, int i){
//            if (lq > r || rq < l){
//                return Integer.MAX_VALUE;
//            }
//            if (lq <= l && rq >= r){
//                Map.Entry<Integer, Integer> ceiling = tree[i].ceilingEntry(k);
//                return ceiling == null ? Integer.MAX_VALUE : ceiling.getValue();
//            }
//            int mid = l+(r-l)/2;
//            return Math.min(rangeQuery(l,mid,lq,rq,k,2*i+1),
//                    rangeQuery(mid+1,r,lq,rq,k,2*i+2));
//        }
//    }
//    SegmentTree segmentTree;
//    public int[] subarrayMajority(int[] nums, int[][] queries) {
//        segmentTree = new SegmentTree(nums.length);
//        segmentTree.build(nums, 0, nums.length-1, 0);
//        int[] ans = new int[queries.length];
//
//        for(int i=0; i<queries.length; i++){
//            int val = segmentTree.rangeQuery(0, nums.length-1, queries[i][0], queries[i][1], queries[i][2], 0);
//            if (val < Integer.MAX_VALUE){
//                ans[i] = val;
//            }
//            else{
//                ans[i] = -1;
//            }
//        }
//        return ans;
//    }
//}
//
//
