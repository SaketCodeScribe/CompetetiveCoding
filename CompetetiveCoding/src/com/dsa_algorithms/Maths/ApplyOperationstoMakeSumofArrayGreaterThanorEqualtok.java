package com.dsa_algorithms.Maths;

public class ApplyOperationstoMakeSumofArrayGreaterThanorEqualtok {
    public int minOperations(int k) {
        int x = (int) Math.ceil(Math.pow(k, 0.5));
        return (k / x * x == k ? k / x - 1 : k / x) + x - 1;

    }
}
