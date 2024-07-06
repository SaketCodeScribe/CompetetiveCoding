package com.dsa_algorithms.Maths.HammingWeight;

public class Hamming {
    /**
     * To count no of bits in a number you just iterate for x != 0 with
     * operation x &= x-1
     */
    public static void main(String[] args) {
        int x = 5;
        int cnt = 0;

        while(x != 0){
            x &= (x-1);
            cnt++;
        }
    }
}
