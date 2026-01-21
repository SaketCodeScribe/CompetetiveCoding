package com.dsa_algorithms.Cses;

import java.util.Scanner;

public class CSES2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()){
            long n = scanner.nextInt(), t = n-1;
            long sum = 0;
            while(t-- > 0){
                sum += scanner.nextInt();
            }
            System.out.println((n*(n+1)/2) - sum);
        }
    }
}
