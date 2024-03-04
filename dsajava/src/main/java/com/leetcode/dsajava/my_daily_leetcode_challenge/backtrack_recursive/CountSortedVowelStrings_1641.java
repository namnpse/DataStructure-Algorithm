package com.leetcode.dsajava.my_daily_leetcode_challenge.backtrack_recursive;

import java.util.Arrays;

public class CountSortedVowelStrings_1641 {

    public static void main(String[] args) {

    }

    // C2: use dynamic programming O(n)
    public int countVowelStrings(int n) {
        int numberOfVowels = 5;
        int[][] dp = new int[n + 1][numberOfVowels];
        for (int i = 0; i < numberOfVowels; i++) dp[0][i] = 1;

        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3] + dp[i - 1][4];
            dp[i][1] = dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3] + dp[i - 1][4];
            dp[i][2] = dp[i - 1][2] + dp[i - 1][3] + dp[i - 1][4];
            dp[i][3] = dp[i - 1][3] + dp[i - 1][4];
            dp[i][4] = dp[i - 1][4];
        }

        return sum(dp[n - 1]);
    }

    public int sum(int[] args) {
        return Arrays.stream(args).sum();
    }

    // C1: recursive
    public int countVowelStrings2(int n) {
        // your code here
        return count(n, 'a');
    }

    char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u'};

    public int count(int n, char last) {
        // your code here
        if (n == 0) return 1;
        int numbers = 0;
        for (char vowel : vowels) {
            if (vowel >= last)
                numbers += count(n - 1, vowel);
        }
        return numbers;
    }

    // C3: use Math
    public int countVowelStrings3(int n) {
        int four = (int) Math.pow(n, 4), three = (int) Math.pow(n, 3), two = (int) Math.pow(n, 2);
        int a = (four + 6 * three + 11 * two + 6 * n) / 24;
        int e = (three + 3 * two + 2 * n) / 6;
        int i = (two + n) / 2;
        int o = n;
        int u = 1;
        return (a + e + i + o + u);
    }
}
