package com.dsa_algorithms.Cses;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CSES25 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()){
            int n = scanner.nextInt();
            Set<Integer> set = new HashSet<>();
            while(n-- > 0){
                set.add(scanner.nextInt());
            }
            System.out.println(set.size());
        }
    }
}
