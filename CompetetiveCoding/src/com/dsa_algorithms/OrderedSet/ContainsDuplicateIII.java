package com.dsa_algorithms.OrderedSet;

import java.util.*;

public class ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        int i, n = nums.length;
        TreeSet<Integer> tree = new TreeSet<>();

        for(i=0; i<n; i++){
            Integer floor = tree.floor(nums[i]);
            if (floor != null && nums[i] - floor <= valueDiff)
                return true;
            Integer ceiling = tree.ceiling(nums[i]);
            if (ceiling != null && ceiling - nums[i] <= valueDiff)
                return true;
            if (i >= indexDiff)
                tree.remove(nums[i-indexDiff]);
            tree.add(nums[i]);
        }
        return false;
    }
}
