package com.dsa_algorithms.TwoPointer;

public class LC881 {
    public int numRescueBoats(int[] people, int limit) {
        int i = 1, j = limit, boats = 0;
        int[] cnt = new int[limit+1];

        for(int p:people) cnt[p]++;

        while(i <=j){
            if (cnt[i] == 0) i++;
            else if (cnt[j] == 0) j--;
            else if (i+j > limit) {
                boats += cnt[j];
                cnt[j--] = 0;
            }
            else {
                int minBoat = i != j ? Math.min(cnt[i], cnt[j]) : (2*i > limit ? cnt[i] : (cnt[i]+1)/2);
                boats += minBoat;
                if (cnt[i] < cnt[j]) {
                    i++;
                    cnt[j] -= minBoat;
                }
                else if (cnt[i] > cnt[j]) {
                    j--;
                    cnt[i] -= minBoat;
                }
                else{
                    cnt[i] = cnt[j] = 0;
                    i++;
                    j--;
                }
            }
        }
        return boats;
    }
}
