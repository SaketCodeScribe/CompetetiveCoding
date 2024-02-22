package com.dsa_algorithms.Recursion;

public class Powerxn {
    public double myPow(double x, int n) {
        return n > 0 ? calc(x,n) : calc(1/x, n);
    }

    private double calc(double x, int n) {
        if (n == 0)
            return 1;
        double val = calc(x*x, n/2);
        return n%2 == 0 ? val : x*val;
    }

    public static void main(String[] args) {
        Powerxn obj = new Powerxn();
        System.out.printf("%.4f\n", obj.myPow(2,4));
        System.out.printf("%.4f\n", obj.myPow(-2,10));
        System.out.printf("%.4f\n", obj.myPow(-2,-2));
        System.out.printf("%.4f\n", obj.myPow(-2.1,3));


    }
}
