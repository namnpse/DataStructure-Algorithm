package com.leetcode.dsajava.course.common_50_probs;

import java.util.HashMap;
import java.util.Map;

public class LongestCommonSubsequence_37 {

    public static void main(String[] args) {
        System.out.println(lcs("stackoverflow", "sjkstack"));
    }

    // Section 37: longest common subsequence
    public static int lcs(String str1, String str2) {
        // your code here
        Map<String, Integer> memoiz = new HashMap<>();
        return lcs(str1, str2, 0, 0, memoiz);
    }

    public static int lcs(String str1, String str2, int i, int j, Map<String, Integer> memoiz) {
        // your code here
        if (i == str1.length() || j == str2.length()) return 0;
        String key = i + " " + j;
        if (memoiz.get(key) != null) return memoiz.get(key);
        if (str1.charAt(i) == str2.charAt(j)) {
            return 1 + lcs(str1, str2, i + 1, j + 1, memoiz);
        }
        int max = Math.max(
                lcs(str1, str2, i + 1, j, memoiz),
                lcs(str1, str2, i, j + 1, memoiz)
        );
        memoiz.put(key, max);
        return max;
    }
}
