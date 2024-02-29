package com.leetcode.dsajava.my_daily_leetcode_challenge.sliding_window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsInString_438 {

    public static void main(String[] args) {
//        String s = "cbaebabacd", p = "abc";
        String s = "abab", p = "ab";
        for (Integer i : findAnagrams(s, p)) {
            System.out.print(i + " ");
        }
    }

    static Map<Character, Integer> sMap = new HashMap<>();
    static Map<Character, Integer> pMap = new HashMap<>();

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();

        for (Character c : p.toCharArray()) {
            pMap.put(c, pMap.getOrDefault(c, 0) + 1);
        }

        int sLen = s.length();
        int pLen = p.length();
        StringBuilder curr = new StringBuilder();
        for (int i = 0; i < sLen; i++) {
            char si = s.charAt(i);
            curr.append(si);
            sMap.put(si, sMap.getOrDefault(si, 0) + 1);
            int start = i - pLen;
            if(curr.length() > pLen) {
                curr.deleteCharAt(0);
                char startChar = s.charAt(start);
                sMap.put(startChar, sMap.getOrDefault(startChar, 0) - 1);
            }
            if(isValid()) {
                res.add(start+1);
            }
        }

        return res;
    }

    private static boolean isValid() {
        for (Map.Entry<Character, Integer> entry : pMap.entrySet()) {
            if (entry.getValue().intValue() != sMap.getOrDefault(entry.getKey(), 0)) {
                return false;
            }
        }
        return true;
    }
}
