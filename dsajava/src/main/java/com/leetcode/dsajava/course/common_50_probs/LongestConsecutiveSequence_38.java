package com.leetcode.dsajava.course.common_50_probs;

import java.util.Arrays;

public class LongestConsecutiveSequence_38 {

    public static void main(String[] args) {

    }

    // Time: O(nlogn)
    // Space O(1)
    public int longestConsecutiveSequence(int[] arr) {
        int n = arr.length;
        if (n < 2) return n;
        Arrays.sort(arr);
        int maxLen = 1;
        int len = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] == arr[i - 1] + 1) len++;
            else if (arr[i] == arr[i - 1]) continue; // by pass, not increment length
            else len = 1;   // reset current len
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }
}
