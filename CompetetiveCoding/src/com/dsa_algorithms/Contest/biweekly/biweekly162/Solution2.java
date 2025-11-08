package com.dsa_algorithms.Contest.biweekly.biweekly162;
import java.util.*;
public class Solution2 {
    public int minRemoval(int[] nums, int k) {
        int n = nums.length, i;
        if (n == 1){
            return 1;
        }
        Arrays.sort(nums);
        Queue<List<Integer>> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        queue.offer(List.of(0, n-1));
        set.add(0+","+(n-1));
        int level = 0;
        while(level < n-1){
            int size = queue.size();
            while(size-- > 0){
                List<Integer> node = queue.poll();
                if (nums[node.get(0)]*k <= nums[node.get(1)]){
                    return level;
                }
                int x = node.get(0)+1, y = node.get(1)-1;
                if (x < n && !set.contains(x+","+node.get(1))){
                    queue.offer(List.of(x, node.get(1)));
                }
                if (y >= 0 && !set.contains(node.get(0)+","+y)){
                    queue.offer(List.of(node.get(0), y));
                }
            }
            level++;
        }
        return level;
    }
}
