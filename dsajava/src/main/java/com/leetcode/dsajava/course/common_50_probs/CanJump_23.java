package com.leetcode.dsajava.course.common_50_probs;

import com.leetcode.dsajava.my_daily_leetcode_challenge.graph.Graph;

import java.util.ArrayList;
import java.util.Queue;

public class CanJump_23 {

    public static void main(String[] args) {
        int[] arr = {3, 0, 2, 0, 2, 1, 4, 3};
        System.out.println(canJump(arr));
    }

    // Section 23: Jump to last index
    // C1: recursive O(2^n)
    public static boolean canJump(int[] arr) {
//        return canJump2(arr);
        return canJump(arr, 0);
    }

    public static boolean canJump(int[] arr, int i) {
        int n = arr.length;
        if (i == n - 1) return true;
//        int[] arr = {3, 0, 2, 0, 2, 1, 4, 3};
        for (int j = 1; j < arr[i] + 1; j++) {
            if (canJump(arr, i + j)) return true;
        }
        return false;
    }

    // C2: dp O(n^2)
    public static boolean canJump2(int[] arr) {
        int n = arr.length;
        boolean[] dp = new boolean[n];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            if (!dp[i]) return false;
            else if (i + arr[i] >= n - 1) return true;
            else {
                for (int j = 1; j < arr[i] + 1; j++) {
                    dp[i + j] = true;
                }
            }
        }

        return dp[n - 1];
    }

    // C3: O(n)
    public static boolean canJump3(int[] arr) {
        int maxIndex = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            if (i > maxIndex) return false;
            maxIndex = Math.max(i + arr[i], maxIndex);
        }

        return maxIndex >= n - 1;
    }
}
