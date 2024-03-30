package com.dsa_algorithms.PrefixSum;

import java.util.ArrayList;
import java.util.List;

public class MinMovesToPickKOnes {
        public long minimumMoves(int[] nums, int k, int maxChanges) {
            int i = 0, n = nums.length, consOnes = 0, mxConsOnes = 0;
            long moves = Long.MAX_VALUE;
            List<Integer> ones = new ArrayList<Integer>();
            int[] pre;
            for(i=0; i<n; i++){
                if (nums[i] == 1){
                    ones.add(i);
                    consOnes++;
                }
                else{
                    mxConsOnes = Math.min(3, Math.max(mxConsOnes, consOnes));
                    consOnes = 0;
                }
            }
            mxConsOnes = Math.min(3, Math.max(mxConsOnes, consOnes));
            n = ones.size();
            if (mxConsOnes+maxChanges >= k){
                return Math.max(Math.min(k, mxConsOnes)-1, 0)+Math.max(k-mxConsOnes, 0)*2;
            }
            pre = new int[n];
            pre[0] = ones.get(0);
            for(i=1; i<n; i++)
                pre[i] = ones.get(i)+pre[i-1];
            k = Math.max(1, k-maxChanges);
            for(i=0; i<n-k+1; i++){
                int mid = i+(k-1)/2;
                long temp = 0;
                temp += ones.get(mid)*(mid-i)-(mid > 0 ? pre[mid-1]-(i > 0 ? pre[i-1] : 0) : 0);
                temp += pre[i+k-1]-pre[mid]-ones.get(mid)*(i+k-1-mid);
                moves = Math.min(moves, temp);
            }
            return moves+maxChanges*2;
        }

        private int getSum(List<Integer> prefix_sums, int left, int right) {
            if (left > right) {
                return 0;
            }
            if (left == 0) {
                return prefix_sums.get(right);
            }
            return prefix_sums.get(right) - prefix_sums.get(left - 1);
        }

    public static void main(String[] args) {
        MinMovesToPickKOnes obj = new MinMovesToPickKOnes();
        System.out.println(obj.minimumMoves(new int[]{1,1,0,0,0,1,1,0,0,1}, 3, 2));
    }
}
