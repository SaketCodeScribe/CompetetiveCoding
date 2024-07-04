package com.dsa_algorithms.LinkedList;

public class FindTheDuplicateNumbers {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = nums[0];

        while(slow != fast){
            System.out.println(slow+" "+fast);
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = nums[fast];
        slow = 0;

        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
