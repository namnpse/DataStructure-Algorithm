package com.leetcode.dsajava.course.common_50_probs;

import java.util.Set;

public class WayToClimb_32 {

    public static void main(String[] args) {

    }

    // Section 32:
    // C1: O(m^n), Space: O(n)
    public static int waysToClimb(int n, Set<Integer> possibleSteps) {
        if (n == 0) return 1;
        int steps = 0;
        for (int step : possibleSteps) {
            if (n - step >= 0) {
                steps += waysToClimb(n - step, possibleSteps);
            }
        }
        return steps;
    }

    // C2: O(n*m), Space: O(1)
    public static int waysToClimb2(int n, Set<Integer> possibleSteps) {
        // your code here
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int step : possibleSteps) {
                if (i - step >= 0) {
                    dp[i] += dp[i - step];
                }
            }
        }
        return dp[n];
    }
}
