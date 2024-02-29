package com.leetcode.dsajava.my_daily_leetcode_challenge.sliding_window;

import java.util.HashMap;
import java.util.Map;

public class IsSubsequence_392 {

    public static void main(String[] args) {
        String s = "abc", t = "ahcgdb";
//        String s = "abc", t = "ahbgdc";
        System.out.println("res: " + isSubsequence(s, t));
    }

    // C1: O(m*n)
    public static boolean isSubsequence(String s, String t) {
        int startIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            if(startIndex >= t.length()) return false;
            int index = findIndex(startIndex, s.charAt(i), t);
            System.out.println("index: " + index);
            if (index == -1) return false;
            startIndex = index + 1;
        }

        return true;

    }

    private static int findIndex(int startIndex, char si, String t) {
        for (int i = startIndex; i < t.length(); i++) {
            if (t.charAt(i) == si) return i;
        }
        return -1;
    }

    // C2: O(n)
    public static boolean isSubsequence2(String s, String t) {
        int n = t.length();
        int m = s.length();

        int j = 0;
        for (int i = 0; i < n && j < m; i++) {
            if(s.charAt(j) == t.charAt(i)) // compare s[j] vs t[i], if matched, move s, else move only t
                j++;
        }
        return (j == m); // has reached end of s or not, means all characters of s are found in t
    }
}
