package com.dsa_algorithms.Cses.Introductory;

import java.util.Scanner;

public class CSES3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()){
            String dna = scanner.next();
            maxDNASequence(dna);
        }
    }

    private static void maxDNASequence(String dna) {
        int i, n = dna.length(), max = 1, curr = 1;

        for(i=0; i<n-1; i++){
            char ch1 = dna.charAt(i), ch2 = dna.charAt(i + 1);
            assert ch1 == 'A' || ch1 == 'C' || ch1 == 'G' || ch1 == 'T';
            assert ch2 == 'A' || ch2 == 'C' || ch2 == 'G' || ch2 == 'T';
            if (ch1 == ch2){
                curr++;
            }
            else{
                max = Math.max(max, curr);
                curr = 1;
            }
        }
        System.out.println(Math.max(max, curr));
    }
}
