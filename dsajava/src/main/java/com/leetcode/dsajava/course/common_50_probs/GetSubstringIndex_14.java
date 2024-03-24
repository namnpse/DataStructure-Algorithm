package com.leetcode.dsajava.course.common_50_probs;

public class GetSubstringIndex_14 {

    public static void main(String[] args) {
        System.out.println(substrIndex("Hello world", "wo"));
    }

    // section 14: Get substring index
    public static int substrIndex(String str1, String str2) {
        // your code here
        if (str1.equals(str2)) return 0;
        int l1 = str1.length();
        int l2 = str2.length();
        for (int i = 0; i <= l1 - l2; i++) {
            String s = str1.substring(i, i + l2);
            System.out.println("s: " + s + " " + (s.equals(str2)));
            if (s.equals(str2)) {
                return i;
            }
        }
        return -1;
    }

    public int strStr(String haystack, String needle) {
        if (haystack.equals(needle)) return 0;
        int l1 = haystack.length();
        int l2 = needle.length();
        for (int i = 0; i <= l1 - l2; i++) {
            if (haystack.substring(i, i + l2).equals(needle)) return i;
        }
        return -1;
    }
}
