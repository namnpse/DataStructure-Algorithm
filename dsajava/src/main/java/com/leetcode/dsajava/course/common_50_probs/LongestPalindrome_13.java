package com.leetcode.dsajava.course.common_50_probs;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome_13 {

    // section 13:
    public int longestPalindrome(String str) {
        // your code here
        int length = 0;
        String s = str;
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int value = entry.getValue();
            if (value % 2 == 0) {
                length += value;
            } else {
                length += (value - 1);
            }
        }
        if (length < s.length()) length++;
        return length;
    }
}
