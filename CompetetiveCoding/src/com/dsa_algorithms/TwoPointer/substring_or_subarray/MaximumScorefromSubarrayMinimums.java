package com.dsa_algorithms.TwoPointer.substring_or_subarray;

class MaximumScorefromSubarrayMinimums {
    // Function to find pair with maximum sum
    public int pairWithMaxSum(int arr[]) {
        // Your code goes here

        int i = 0, j = 2, smInd, ssInd, n = arr.length, ans = arr[0]+arr[1];

        if (arr[0] < arr[1]){
            smInd = 0;
            ssInd = 1;
        }
        else{
            smInd = 1;
            ssInd = 0;
        }

        /**
         * If find smallest ele - no need to update subarray (be lazy).
         * If curr ele < sec smallest element - then chances of getting a new second smallest exists.
         * If curr ele > sec smallest element - then you can found a new pair of smalles and second smallest element.
         */
        for (j = 2; j < n; j++) {
            if (arr[j] <= arr[smInd]) {
                ssInd = smInd;
                smInd = j;
            } else if (arr[j] <= arr[ssInd]) {
                ssInd = Math.max(smInd, ssInd);
                ssInd = ssInd < j - 1 ? ssInd + 1 : ssInd;
                for (i = ssInd; i < j - 1; i++)
                    if (arr[i] <= arr[ssInd]){
                        ssInd = i;
                    }
                smInd = j;
            } else {
                smInd = Math.max(smInd, ssInd);
                smInd = smInd < j-1 ? smInd+1 : smInd;
                ssInd = smInd + 1;
                for (i = ssInd; i <= j; i++) {
                    if (arr[i] <= arr[smInd]) {
                        ssInd = smInd;
                        smInd = i;
                    } else if (arr[i] <= arr[ssInd]) {
                        ssInd = i;
                    }
                }
            }
            ans = Math.max(ans, arr[smInd] + arr[ssInd]);
        }
        return ans < 0 ? 0 : ans;
    }
}
