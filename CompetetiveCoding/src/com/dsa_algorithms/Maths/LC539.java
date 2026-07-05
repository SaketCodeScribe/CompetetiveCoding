package com.dsa_algorithms.Maths;

public class LC539 {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        return validate(p1, p2, p3) && validate(p2, p3, p4) && validate(p1, p3, p4) && validate(p1, p2, p4);
    }
    private boolean validate(int[] p1, int[] p2, int[] p3){
        long a = (long) (p1[0] - p2[0]) *(p1[0]-p2[0]) + (long) (p1[1] - p2[1]) *(p1[1]-p2[1]);
        long b = (long) (p1[0] - p3[0]) *(p1[0]-p3[0]) + (p1[1]-p3[1])*(p1[1]-p3[1]);
        long c = (long) (p3[0] - p2[0]) *(p3[0]-p2[0]) + (long) (p3[1] - p2[1]) *(p3[1]-p2[1]);

        return a!=0 && b!=0 && c!= 0 && ((c == a+b && a == b) || (a == b+c && b == c) || ( b == a+c && a == c));
    }
}
