package com.leetcode.dsajava.my_daily_leetcode_challenge.sliding_window;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring_76 {

    public static void main(String[] args) {

    }

    static HashMap<Character, Integer> sMap = new HashMap<>();
    static HashMap<Character, Integer> tMap = new HashMap<>();
    public static String minWindow(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if(sLen < tLen)   return "";
        for (Character c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }
        StringBuilder curr = new StringBuilder();
        int start = 0, end = 0;
        int minLen = Integer.MAX_VALUE;
        String res = "";
        while (start < sLen) {
            if(curr.length() < t.length() || sMap.size() < tMap.size() || !isValid()) {
                if(end < sLen) {
                    Character endChar = s.charAt(end);
                    sMap.put(endChar, sMap.getOrDefault(endChar, 0) + 1);
                    curr.append(endChar);
                    end++;
                } else {
                    break;
                }
            } else {
                if(end - start < minLen) {
                    minLen = end - start;
                    res = curr.toString();
                }
                if(curr.length() > 0) curr.deleteCharAt(0);
                Character startChar = s.charAt(start);
                sMap.put(startChar, sMap.getOrDefault(startChar, 0) - 1);
                start++;
            }
        }

        return res;
    }

    private static boolean isValid() {
        if(sMap.size() < tMap.size())   return false;
        for (Map.Entry<Character, Integer> entry : tMap.entrySet()) {
            if(sMap.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }
}
