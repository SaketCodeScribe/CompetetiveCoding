package com.dsa_algorithms.TwoPointer;

import java.util.Arrays;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        int i = 0, n = asteroids.length, j = 0;
        while(i<n){
            int asteroid = asteroids[i];
            while(j > 0 && asteroids[j-1] > 0 && asteroid < 0 && asteroids[j-1] < -1*asteroids[i]){
                j--;
            }
            if (j == 0 || asteroid > 0 || asteroids[j-1] < 0)
                asteroids[j++] = asteroid;
            else if (asteroids[j-1] == -1*asteroids[i])
                j--;
            i++;
        }

        return Arrays.copyOfRange(asteroids, 0, j);
    }
}
