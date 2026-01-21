package com.dsa_algorithms.Cses;

import java.util.Scanner;

public class CSES1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()){
            long n = scanner.nextLong();
            do{
                System.out.print(n+" ");
                if (n%2 == 0 || n == 1){
                    n >>=1;
                }
                else{
                    n = ((n<<1L) + n) + 1;
                }
            }while(n > 0);
        }
    }
}
