package com.dsa_algorithms.TwoPointer;

public class RearrangeArrayEltsWithSignOrderDeosntMatter {

    /**
     * @param nums
     */
    public void rearrangeElements(int[] nums) {
        int pos = 0, neg = 1, n = nums.length;

        /**
         * No. of pos and neg elements are equal.
         * Check for pos elements if they are in correct position - then array has elements in alternate signt
         * if Not - find the neg pos which pos element.
         * Once found - swap these two element.
         *
         * This will rearrange elements in alternate sign but will not retain the order.
         */
        while(pos < n - 1){
            if (nums[pos] > 0){
                pos +=2;
            }
            else if(nums[neg] < 0){
                neg += 2;
            }
            else{
                int temp = nums[pos];
                nums[pos] = nums[neg];
                nums[neg] = temp;
            }
        }
    }
}
