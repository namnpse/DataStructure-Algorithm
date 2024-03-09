package com.leetcode.dsajava.my_daily_leetcode_challenge.sliding_window;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString_567 {

    public static void main(String[] args) {
//        String s1 = "abc", s2 = "eidbaooo";
        String s1 = "adc", s2 = "dcda";
        System.out.println("res: "+checkInclusion(s1, s2));
    }
    static Map<Character, Integer> mapS1 = new HashMap<>();
    static Map<Character, Integer> mapS2 = new HashMap<>();
    public static boolean checkInclusion(String s1, String s2) {

        int len1 = s1.length();
        int len2 = s2.length();
        for (Character c : s1.toCharArray()) {
            mapS1.put(c, mapS1.getOrDefault(c, 0) + 1);
        }

        int start = 0, end = 0;
        StringBuilder curr = new StringBuilder();

        while (end < len2) {
            // add char at end
            char cEnd = s2.charAt(end);
            curr.append(cEnd);
            mapS2.put(cEnd, mapS2.getOrDefault(cEnd, 0) + 1);
            if(mapS2.get(cEnd) == 0)   mapS2.remove(cEnd);
            if(curr.length() > len1) { // remove char at start
                char cStart = s2.charAt(start);
                curr.deleteCharAt(0);
                mapS2.put(cStart, mapS2.getOrDefault(cStart, 0) - 1);
                if(mapS2.get(cStart) == 0)   mapS2.remove(cStart);
                start++;
            }
            if(isContain()) {
                return true;
            }
            end++;
        }

        return false;
    }

    private static boolean isContain() {
        for (Map.Entry<Character, Integer> entry: mapS1.entrySet()) {
            if(entry.getValue().intValue() != mapS2.getOrDefault(entry.getKey(), 0)) {
                return false;
            }
        }
        return true;
    }
}
