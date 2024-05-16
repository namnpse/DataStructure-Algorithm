package com.leetcode.dsajava.course.common_50_probs;

public class ShortestPalindrome_46 {

    // Section 46:
    // Brute force solution:
    // Time complexity: O(n²)
    // Space complexity: O(1)
    String shortestPalindrome(String str) {
        int mirrorLength = 0;
        for (int i = 0; i <= str.length(); i++) {
            if (str.substring(0, i).contentEquals(new StringBuilder(str.substring(0, i)).reverse()))
                mirrorLength = i;
        }
        return new StringBuilder(str.substring(mirrorLength)).reverse() + str;
    }
}
