package com.dsa_algorithms.Maths;

public class MinimizeManhattanDistances {
    public int minimumDistance(int[][] points) {
        int[] remove = maxManHattanDist(points, -1);
        int distA = maxManHattanDist(points, remove[0])[1];
        int distB = maxManHattanDist(points, remove[1])[1];
        return Math.min(distA, distB);
    }
    public int[] maxManHattanDist(int[][] points, int remove){
        int[] mxsum = new int[]{-1, Integer.MIN_VALUE};
        int[] mxdiff = new int[]{-1, Integer.MIN_VALUE};
        int[] misum = new int[]{-1, Integer.MAX_VALUE};
        int[] midiff = new int[]{-1, Integer.MAX_VALUE};

        for(int i=0; i<points.length; i++){
            if (i == remove)
                continue;
            int sum = points[i][0]+points[i][1], diff = points[i][0]-points[i][1];
            if (mxsum[1] < sum){
                mxsum[0] = i;
                mxsum[1] = sum;
            }
            if (misum[1] > sum){
                misum[0] = i;
                misum[1] = sum;
            }
            if (mxdiff[1] < diff){
                mxdiff[0] = i;
                mxdiff[1] = diff;
            }
            if (midiff[1] > diff){
                midiff[0] = i;
                midiff[1] = diff;
            }
        }
        if (Math.abs(mxsum[1]-misum[1]) > Math.abs(mxdiff[1]-midiff[1]))
            return remove == -1 ? new int[]{mxsum[0], misum[0]} : new int[]{0, Math.abs(mxsum[1]-misum[1])};
        return remove == -1 ? new int[]{mxdiff[0], midiff[0]} : new int[]{0, Math.abs(mxdiff[1]-midiff[1])};
    }
}
