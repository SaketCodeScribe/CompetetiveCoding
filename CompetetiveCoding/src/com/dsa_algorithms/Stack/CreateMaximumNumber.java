package com.dsa_algorithms.Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
    Here in merging, I'd to call greater method to decide for the next pointer. The reason can be understood from:
    a - 7 6 3
    b - 9 3 6
    if the pointer a is at digit 3, and b is also at digit 3. then which should I increment, if I inc a then the resulting
    ans would look like 336, but if I inc b then the resulting ans would look like 363. Hence, for two pointers
    having equal digits, we need to check the next different ele which is larger, and consider that pointer to inc.s
 */
public class CreateMaximumNumber {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int i, j, m = nums1.length, n = nums2.length, a, b;
        List<Integer> ans = new ArrayList<>();
        for(i=0; i<=k; i++){
            j = k-i;
            if (i > m || j > n)
                continue;
            List<Integer> max1 = maxNum(nums1, i);
            List<Integer> max2 = maxNum(nums2, j);
            List<Integer> temp = new ArrayList<>();
            a = b = 0;
            while (a < i || b < j){
                if (a >= i)
                    temp.add(max2.get(b++));
                else if (b >= j)
                    temp.add(max1.get(a++));
                else if (max1.get(a) > max2.get(b))
                    temp.add(max1.get(a++));
                else if (max1.get(a) < max2.get(b))
                    temp.add(max2.get(b++));
                else if (greater(max1, max2, a, b))
                    temp.add(max1.get(a++));
                else
                    temp.add(max2.get(b++));
            }
            if (ans.isEmpty() || greater(temp, ans, 0, 0))
                ans = temp;
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
    List<Integer> maxNum(int[] nums, int k){
        int i, n = nums.length;
        Stack<Integer> stack = new Stack<>();
        for(i=0; i<n; i++){
            while(!stack.isEmpty() && nums[i] > stack.peek() && k - stack.size() <= n-i-1)
                stack.pop();
            if (stack.size() < k)
                stack.push(nums[i]);
        }
        return stack;
    }
    boolean greater(List<Integer> max1, List<Integer> max2, int a, int b){
        int m = max1.size(), n = max2.size();
        while(a < m || b < n){
            if (a >= m)
                return false;
            else if (b >= n)
                return true;
            else if (max1.get(a) > max2.get(b))
                return true;
            else if (max1.get(a) < max2.get(b))
                return false;
            a++;
            b++;
        }
        return true;
    }
}
