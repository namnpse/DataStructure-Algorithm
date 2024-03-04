package com.leetcode.dsajava.my_daily_leetcode_challenge.backtrack_recursive;

import java.util.HashMap;
import java.util.Map;

public class LongestCommonSubsequence_1143 {

    public static void main(String[] args) {

    }

    Map<String, Integer> memoiz = new HashMap<>();
    public int longestCommonSubsequence(String text1, String text2) {
        return lcs(text1, text2, 0 , 0);
    }

    public int lcs(String str1, String str2, int i, int j){
        if(i == str1.length() || j == str2.length()) return 0;
        String key = i + " " +j;
        if(memoiz.get(key) != null) return memoiz.get(key);
        if(str1.charAt(i) == str2.charAt(j)) {
            return 1 + lcs(str1, str2, i + 1, j + 1);
        }
        int max = Math.max(
                lcs(str1, str2, i, j+1),
                lcs(str1, str2, i+1, j)
        );
        memoiz.put(key, max);
        return max;
    }
}
