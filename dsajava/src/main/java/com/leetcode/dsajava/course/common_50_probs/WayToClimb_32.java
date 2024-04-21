package com.leetcode.dsajava.course.common_50_probs;

import java.util.Set;

public class WayToClimb_32 {

    public static void main(String[] args) {

    }

    // Section 32:
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
}
