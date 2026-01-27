package com.dsa_algorithms.Cses.Introductory;

import java.util.Scanner;

public class CSES4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()){
            int n = scanner.nextInt();
            int prev = 0;
            long moves = 0;
            while(n-- > 0){
                int curr = scanner.nextInt();
                if (prev > 0 && prev > curr){
                    moves += prev-curr;
                }
                prev = Math.max(prev, curr);
            }
            System.out.println(moves);
        }
    }
}
