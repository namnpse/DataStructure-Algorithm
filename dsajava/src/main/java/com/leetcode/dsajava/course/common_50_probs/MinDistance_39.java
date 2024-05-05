package com.leetcode.dsajava.course.common_50_probs;

import java.util.HashMap;
import java.util.Map;

public class MinDistance_39 {

    public static void main(String[] args) {
        System.out.println(minDistance("strongtogether", "get"));
    }

    // Section 39:
    public static int minDistance(String word1, String word2) {
        Map<String, Integer> memoiz = new HashMap<>();
        return minDistance(word1, word2, 0, 0, memoiz);
    }

    public static int minDistance(String word1, String word2, int i, int j, Map<String, Integer> memoiz) {
        if (i == word1.length()) return word2.length() - j; // add all the rest of word2
        if (j == word2.length()) return word1.length() - i; // remove all the rest of word1
        String key = i + " " + j;
        if (memoiz.get(key) != null) return memoiz.get(key);
        if (word1.charAt(i) == word2.charAt(j))
            return minDistance(word1, word2, i + 1, j + 1, memoiz);
        int min = Math.min(
                minDistance(word1, word2, i + 1, j + 1, memoiz),
                Math.min(
                        minDistance(word1, word2, i + 1, j, memoiz),
                        minDistance(word1, word2, i, j + 1, memoiz)
                )
        );
        memoiz.put(key, min);
        return min;
    }

    // C2: dynamic programming
    public int minDistance2(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n + 1][m + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) dp[i][0] = i;
        for (int i = 1; i <= m; i++) dp[0][i] = i;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(
                            Math.min(
                                    dp[i - 1][j], // remove
                                    dp[i][j - 1] // add
                            ),
                            dp[i - 1][j - 1] // replace
                    );
                }
            }
        }
        return dp[n][m];
    }
}
