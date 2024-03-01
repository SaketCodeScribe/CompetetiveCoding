package com.dsa_algorithms.Greedy;

import java.util.Arrays;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
public class FractionalKnapsack {
    double fractionalKnapsack(int W, Item arr[], int n) {
        int i;
        double ans = 0;
        double[][] temp = new double[n][n];

        for(i=0; i<n; i++) {
            temp[i][0] = (double) arr[i].value / arr[i].weight;
            temp[i][1] = arr[i].weight;
        }
        Arrays.sort(temp, (a,b) -> Double.compare(a[0], b[0]));

        for(i=0; i<n && W > 0; i++){
            if (temp[i][1] <= W){
                ans += temp[i][0]*temp[i][1];
                W -= temp[i][1];
            }
            else{
                ans += temp[i][0]*W;
                break;
            }
        }
        return ans;
    }
}
