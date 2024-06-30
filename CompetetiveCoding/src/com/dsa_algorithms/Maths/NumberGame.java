package com.dsa_algorithms.Maths;

public class NumberGame {
    static int NumberGame(long A) {
        // Write your code here
        int i, ans = 0;
        if (A == 1)
            return 1;

        for(i=1; i<= (int)Math.pow(A,0.5); i++){
            if (A%i == 0){
                ans += 2;
                if ((long)i*i == A)
                    ans--;
            }

        }
        return ans;
    }
}
