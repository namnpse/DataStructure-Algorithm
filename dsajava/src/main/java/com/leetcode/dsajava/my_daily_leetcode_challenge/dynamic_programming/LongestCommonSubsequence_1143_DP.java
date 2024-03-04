package com.leetcode.dsajava.my_daily_leetcode_challenge.dynamic_programming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestCommonSubsequence_1143_DP {

    public static void main(String[] args) {

    }

    // C1: backtrack. check LongestCommonSubsequence_1143 class

    // C2: dp
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n+1][m+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }

    // C2: optimize space
    public int longestCommonSubsequence2(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[] dp = new int[m+1];
        int[] tempDp = new int[m+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1)) {
                    tempDp[j] = dp[j-1];
                }else {
                    tempDp[j] = Math.max(dp[j], tempDp[j-1]);
                }
            }
            // copy temp to dp, reset temp
            for (int j = 1; j <= m; j++) {
                dp[j] = tempDp[j];
                tempDp[j] = 0;
            }
        }
        return dp[m];
    }

    public int longestConsecutiveSequence(int[] arr){
        int n = arr.length;
        if(n < 2)   return n;
        Arrays.sort(arr);
        int maxLen = 1;
        int len = 1;
        for (int i = 1; i < n; i++) {
            if(arr[i] == arr[i-1] + 1)  len++;
            else if(arr[i] == arr[i-1]) continue;
            else len = 1;
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }
}
