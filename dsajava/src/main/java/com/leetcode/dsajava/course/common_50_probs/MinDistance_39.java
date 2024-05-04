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
}
