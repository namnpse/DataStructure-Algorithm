package com.leetcode.dsajava.course.common_50_probs;

public class ShortestPalindrome_46 {

    // Section 46:
    // C1:
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

    // C2:
    // By using LPS array:
    // Time complexity: O(n)
    // Space complexity: O(n)
    static int[] getLpsArr(String str) {
        int[] lpsArr = new int[str.length()];
        int length = 0;
        int i = 1;
        while (i < str.length()) {
            if (str.charAt(i) == str.charAt(length))
                lpsArr[i++] = ++length;
            else if (length > 0)
                length = lpsArr[length - 1];
            else
                lpsArr[i++] = 0;
        }
        return lpsArr;
    }

    String shortestPalindrome2(String str) {
        String concatenation = str + "#" + new StringBuilder(str).reverse();
        int[] lpsArr = getLpsArr(concatenation);
        int mirrorLength = lpsArr[lpsArr.length - 1];
        return new StringBuilder(str.substring(mirrorLength)).reverse() + str;
    }
}
