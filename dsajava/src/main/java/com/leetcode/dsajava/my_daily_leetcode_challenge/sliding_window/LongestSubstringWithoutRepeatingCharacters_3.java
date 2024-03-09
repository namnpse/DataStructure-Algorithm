package com.leetcode.dsajava.my_daily_leetcode_challenge.sliding_window;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters_3 {

    public static void main(String[] args) {
        String s = "abcabcdbb";
        System.out.println("res: "+lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int start = 0, end = 0;
        StringBuilder curr = new StringBuilder();
//        String s = "abcabcdbb";
        while (end < n) {
            curr.append(s.charAt(end));
            char cEnd = s.charAt(end);
            map.put(cEnd, map.getOrDefault(cEnd,  0) + 1);
            if(map.get(cEnd) == 0)  map.remove(cEnd);
            if(curr.length() == map.size()) { // not duplicate
                int len = end - start + 1;
                maxLength = Math.max(len, maxLength);
            } else { // meet duplicate char
                curr.deleteCharAt(0);
                char cStart = s.charAt(start);
                map.put(cStart, map.getOrDefault(cStart,  0) - 1);
                if(map.get(cStart) == 0)  map.remove(cStart);
                start++;
            }
            end++;
        }
        return maxLength;
    }
}
