package com.dsa_algorithms.Cses;

import java.util.Arrays;
import java.util.Scanner;

public class CSES26 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()){
            int i, j, ans = 0, n = scanner.nextInt(), m = scanner.nextInt(), k = scanner.nextInt();
            int[] applicants = new int[n], apartments = new int[m];
            i = 0;
            while(i < n){
                applicants[i++] = scanner.nextInt();
            }
            i = 0;
            while(i < m){
                apartments[i++] = scanner.nextInt();
            }
            Arrays.sort(applicants);
            Arrays.sort(apartments);
            i = j = 0;

            while(i < n && j < m){
                if (Math.abs(applicants[i]-apartments[j]) <= k){
                    ans++;
                    i++;
                    j++;
                }
                else if (applicants[i] > apartments[j]){
                    j++;
                }
                else{
                    i++;
                }
            }
            System.out.println(ans);
        }
    }
}
