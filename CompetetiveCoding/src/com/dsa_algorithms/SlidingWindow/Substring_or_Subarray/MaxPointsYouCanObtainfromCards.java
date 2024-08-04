package com.dsa_algorithms.SlidingWindow.Substring_or_Subarray;

public class MaxPointsYouCanObtainfromCards {
    // prefix sum (dp)
    public int maxScore(int[] cardPoints, int k) {
        int i, n = cardPoints.length, ans = 0;
        int[] prefix = new int[n];

        for(i=0; i<n; i++)
            prefix[i] = (i > 0 ? prefix[i-1] : 0)+cardPoints[i];
        for(i=0; i<=k; i++)
            ans = Math.max(ans, (i > 0 ? prefix[i-1] : 0 )+prefix[n-1]-((k < n) || (k == n && i > 0 )? prefix[n-k+i-1] : 0));
        return ans;
    }
    // front and rear sum (dp)
    public int maxScore1(int[] cardPoints, int k) {
        int n = cardPoints.length;

        int[] frontSetOfCards = new int[k + 1];
        int[] rearSetOfCards = new int[k + 1];

        for (int i = 0; i < k; i++) {
            frontSetOfCards[i + 1] = cardPoints[i] + frontSetOfCards[i];
            rearSetOfCards[i + 1] = cardPoints[n - i - 1] + rearSetOfCards[i];
        }

        int maxScore = 0;

        for (int i = 0; i <= k; i++) {
            int currentScore = frontSetOfCards[i] + rearSetOfCards[k - i];
            maxScore = Math.max(maxScore, currentScore);
        }

        return maxScore;
    }
    // front and rear sum (dp) in constant space
    public int maxScore2(int[] cardPoints, int k) {
        int frontScore = 0;
        int rearScore = 0;
        int n = cardPoints.length;

        for (int i = 0; i < k; i++) {
            frontScore += cardPoints[i];
        }

        // take all k cards from the beginning
        int maxScore = frontScore;

        // take i from the beginning and k - i from the end
        for (int i = k - 1; i >= 0; i--) {
            rearScore += cardPoints[n - (k - i)];
            frontScore -= cardPoints[i];
            int currentScore = rearScore + frontScore;
            maxScore = Math.max(maxScore, currentScore);
        }

        return maxScore;
    }
    // sliding window
    public int maxScore3(int[] cardPoints, int k) {
        int i, j, n = cardPoints.length, tot = 0, minSubarrayScore, sum = 0;

        for(int point:cardPoints)
            tot += point;
        if (k == n)
            return tot;
        i = j = 0;
        minSubarrayScore = tot;
        while(i < n){
            sum += cardPoints[i++];
            if (i-j == n-k){
                minSubarrayScore = Math.min(minSubarrayScore, sum);
                sum -= cardPoints[j++];
            }
        }
        return tot-minSubarrayScore;
    }
}
