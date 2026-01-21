package com.dsa_algorithms.Cses;

import java.util.Scanner;

public class CSES5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            int n = scanner.nextInt();
            if (n > 1 && n < 4){
                System.out.println("NO SOLUTION");
            }
            else{
                int i = 1;
                while(i <= n/2){
                    System.out.print((n/2+i)+" "+i+" ");
                    i++;
                }
                if (n%2 != 0){
                    System.out.print(n);
                }
            }
        }
    }
}