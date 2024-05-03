package com.leetcode.dsajava.course.common_50_probs;

import static com.leetcode.dsajava.array.ArrayUtil.asList;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence_38 {

    public static void main(String[] args) {

    }

    // C1: Time: O(nlogn) Space O(1)
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

    public int longestConsecutiveSequence2(int[] arr) {
        int n = arr.length;
        if (n < 2) return n;
        Set<Integer> values = new HashSet<>(asList(arr));
        int maxLen = 1;
        for (Integer value : values) {
            if (values.contains(value - 1)) { // contain (value-1) mean it is NOT the beginning of sequence -> skip
                continue;
            } else { // not contain (value-1), mean value is the beginning of sequence
                int right = value;
                while (values.contains(right + 1)) right++;
                maxLen = Math.max(maxLen, right - value);
            }
        }
        return maxLen;
    }
}
