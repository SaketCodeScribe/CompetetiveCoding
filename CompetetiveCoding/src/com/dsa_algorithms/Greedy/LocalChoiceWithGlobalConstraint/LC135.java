package com.dsa_algorithms.Greedy.LocalChoiceWithGlobalConstraint;

public class LC135 {
    public int candy(int[] ratings) {
        int n = ratings.length, i = 1, chocolates = 1;

        while(i<n){
            while(i < n && ratings[i] == ratings[i-1]){
                chocolates++;
                i++;
            }
            int upHill = 1;
            while(i < n && ratings[i] > ratings[i-1]){
                i++;
                upHill++;
            }
            int downHill = 1;
            while(i < n && ratings[i-1] > ratings[i]){
                i++;
                downHill++;
            }
            int peakHt = Math.max(upHill, downHill), smallPath = Math.min(upHill, downHill) - 1;
            chocolates += (peakHt*(peakHt+1) + smallPath*(smallPath+1))/2 - 1;
        }
        return chocolates;
    }
}
