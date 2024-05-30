package com.dsa_algorithms.BinarySearch;

public class CovidVaccination {
    public static int maxVaccinesAdministered(int n, int dayNumber, int maxVaccines) {
        int low = 1, high = maxVaccines, mid, ans = -1;

        while(low <= high){
            mid = (low+high) >> 1;
            long sum = getVaccines(mid, dayNumber+1, n);
            if (sum >= maxVaccines){
                high = mid-1;
                if (sum == maxVaccines)
                    ans = mid;
            }
            else{
                low = mid+1;
                if (ans == -1 || ans != maxVaccines)
                    ans = mid;
            }
        }
        return ans;
    }
    static long getVaccines(int peak, int day, int n){
        long sum = 0;
        if (peak <= day)
            sum = peak*(peak+1)/2+day-peak;
        else
            sum = peak*(peak+1)/2-(peak-day)*(peak-day+1)/2;
        if (peak-1 <= n-day-1)
            sum += (peak-1)*peak/2+n-day-peak+1;
        else
            sum += peak*(peak-1)/2-(peak-n+day-1)*(peak-n+day)/2;
        return sum;
    }
}
