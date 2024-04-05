package com.dsa_algorithms.Maths;

public class FindtheSumofEncryptedIntegers {
    public int sumOfEncryptedInt(int[] nums) {
        int ans = 0;

        for(int num:nums){
            int x = num, mx = 0, val = 0;
            while(x > 0){
                mx = Math.max(mx, x%10);
                x /= 10;
            }
            while(num > 0){
                val = val*10+mx;
                num /= 10;
            }
            ans += val;
        }
        return ans;
    }
}
