package com.leetcode.dsajava.my_daily_leetcode_challenge.sliding_window;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement_424 {

    public static void main(String[] args) {
//        String s = "ABAB";
        String s = "AABABBBA";
//        int k = 2;
        int k = 0;
        System.out.println("Res: "+characterReplacement(s, k));
    }

    // C1:
    public static int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int maxOccurrences = 0;
        int maxLen = 0;
        int start = 0, end = 0;
        while (end < s.length()) {
            char cEnd = s.charAt(end);
            map.put(cEnd, map.getOrDefault(cEnd, 0) + 1);
            maxOccurrences = Math.max(maxOccurrences, map.get(cEnd));
            if(end - start + 1 > maxOccurrences + k) { // invalid
                char cStart = s.charAt(start);
                map.put(cStart, map.getOrDefault(cStart, 0) - 1);
                start++;
            }
            maxLen = Math.max(maxLen, end - start + 1);
            end++;
        }
        return maxLen;
    }

    // C2: same as C1, but use array occurrences (more concise, better performance), not map occurrences
    public static int characterReplacement2(String s, int k) {
//        Map<Character, Integer> map = new HashMap<>();
        int[] arr = new int[26]; // 26 characters
        int maxOccurrences = 0;
        int maxLen = 0;
        int start = 0, end = 0;
        while (end < s.length()) {
            /*char cEnd = s.charAt(end);
            map.put(cEnd, map.getOrDefault(cEnd, 0) + 1);*/
            arr[s.charAt(end) - 'A']++;
//            maxOccurrences = Math.max(maxOccurrences, map.get(cEnd));
            maxOccurrences = Math.max(maxOccurrences, arr[s.charAt(end) - 'A']);
            if(end - start + 1 > maxOccurrences + k) { // invalid
 /*               char cStart = s.charAt(start);
                map.put(cStart, map.getOrDefault(cStart, 0) - 1);*/
                arr[s.charAt(start) - 'A']--;
                start++;
            }
            maxLen = Math.max(maxLen, end - start + 1);
            end++;
        }
        return maxLen;
    }
}
