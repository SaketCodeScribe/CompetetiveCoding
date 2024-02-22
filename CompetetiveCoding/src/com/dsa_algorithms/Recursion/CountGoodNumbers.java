package com.dsa_algorithms.Recursion;

public class CountGoodNumbers {
    private final int MOD = (int) Math.pow(10, 9) + 7;

    public int countGoodNumbers(long n) {
        long ne = (long)Math.ceil((n / 2.0)), no = n / 2;

        return (int) (pow(5, ne) % MOD * pow(4, no) % MOD)%MOD;
    }

    private long pow(long x, long n) {
        if (n == 0)
            return 1;
        long val = pow((x % MOD * x % MOD) % MOD, n / 2);
        return n % 2 == 0 ? val  % MOD: (x % MOD * val % MOD) % MOD;
    }

    public static void main(String[] args) {
        CountGoodNumbers obj = new CountGoodNumbers();
        System.out.println(obj.countGoodNumbers(5));
        System.out.println(obj.countGoodNumbers(1));
        System.out.println(obj.countGoodNumbers(4));
        System.out.println(obj.countGoodNumbers(25));
        System.out.println(obj.countGoodNumbers(new Long("806166225460393")));
    }
}
