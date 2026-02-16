package com.dsa_algorithms.Maths.ChineseRemainderTheorem;

public class LC3464 {
    private static final int MOD = 10;
    public boolean hasSameDigits(String s) {
        int i, n=s.length();

        int[] dp = new int[n-1];
        initialize(dp, n-1);
        return calculateDigit(0, n-1, dp, s) == calculateDigit(1, n-1, dp, s);
    }
    private int calculateDigit(int start, int length, int[] dp, String s){
        int digit = 0, k = 0;
        for(int i=start; i<start+length; i++){
            digit = (digit + ((s.charAt(i)-'0')*dp[k++])) % MOD;
        }
        return digit;
    }
    private void initialize(int[] dp, int n){
        int i;
        for(i=0; i<n; i++){
            dp[i] = findnCkMod(n-1, i);
        }
    }
    private int findnCkMod(int n, int k){
        int a1 = lucasTheorem(n, k, 2);
        int a2 = lucasTheorem(n, k, 5);

        int M1 = 5, M2 = 2;
        int invM1 = findInv(M1, 2), invM2 = findInv(M2, 5);
        return (a1*M1*invM1+a2*M2*invM2)%10;


    }
    public int findInv(int a, int b){
        return b == 2 ? 1 : 3; // 3 when b = 5
    }
    public int lucasTheorem(int d, int k, int num){
        // lucasTheorem
        double[] fact = {1, 1, 2, 6, 24};
        int a, b;
        double prod = 1;

        while(d != 0 || k != 0){
            if (d == 0){
                b = k%num;
                if (b != 0){
                    return 0;
                }
            }
            else if (k != 0){
                a = d%num;
                b = k%num;
                if (b > a){
                    return 0;
                }
                prod *= fact[a]/(fact[b]*fact[a-b]);
            }
            d /= num;
            k /=num;
        }
        return (int)prod;
    }
}
