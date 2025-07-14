package com.dsa_algorithms.Contest.weekly.weekly444;

import java.util.*;
public class Solution2 {
//    int size;
//    Set<String> packet;
//    Queue<int[]> queue;
//    Map<Integer, List<Integer>> map;
//
//    public Solution2(int memoryLimit) {
//        size = memoryLimit;
//        queue = new LinkedList<>();
//        map = new HashMap<>();
//    }
//
//    public boolean addPacket(int source, int destination, int timestamp) {
//        if (queue.size() == size){
//            int[] pack = queue.poll();
//            remove(pack[1], Arrays.toString(pack));
//        }
//
//        int[] newPack = new int[]{source, destination, timestamp};
//        String key = Arrays.toString(newPack);
//        if (packet.contains(key)){
//            return false;
//        }
//        queue.offer(newPack);
//        map.computeIfAbsent(destination, x -> new ArrayList<>()).add(timestamp);
//        packet.add(key);
//    }
//    private void remove(int key, String pack){
//        if (map.get(key).size() == 1){
//            map.remove(key);
//            packet.remove(pack);
//        }
//        map.get(key).remove(map.get(key).size()-1);
//    }
//
//    public int[] forwardPacket() {
//        if (queue.isEmpty()){
//            return new int[0];
//        }
//        int[] pack = queue.poll();
//        remove(pack[1], Arrays.toString(pack));
//        return pack;
//    }
//
//    public int getCount(int destination, int startTime, int endTime) {
//        List<Integer> list = map.getOrDefault(destination, null);
//        if (list == null){
//            return 0;
//        }
//        int start = lowerBound(list, startTime);
//        if (start == -1){
//            return 0;
//        }
//        int end = upperBound(list, endTime);
//        return end-start+1;
//    }
//    private int lowerBound(List<Integer> list, int tar){
//        int low = 0, high = list.size()-1, ans = -1, mid;
//
//        while (low <= high){
//            mid = low + (high-low)/2;
//            if (list.get(mid) >= tar){
//                if (list.get(mid) == tar){
//                    ans = mid;
//                }
//                high = mid-1;
//            }
//            else{
//                low = mid+1;
//            }
//        }
//        return ans;
//    }
//    private int upperBound(List<Integer> list, int tar){
//        int low = 0, high = list.size()-1, ans = -1, mid;
//
//        while (low <= high){
//            mid = low + (high-low)/2;
//            if (list.get(mid) <= tar){
//                if (list.get(mid) == tar){
//                    ans = mid;
//                }
//                low = mid+1;
//            }
//            else{
//                high = mid-1;
//            }
//        }
//        return ans;
//    }
}
