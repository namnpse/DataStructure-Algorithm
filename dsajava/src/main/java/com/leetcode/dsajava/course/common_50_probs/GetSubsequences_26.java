package com.leetcode.dsajava.course.common_50_probs;

import java.util.ArrayList;

public class GetSubsequences_26 {

    // Section 26: String subsequences
    // Time complexity: O(n.2^n)
    // Space complexity: O(n.2^n)
    public static ArrayList<String> getSubsequences(String str) {
        ArrayList<String> res = new ArrayList<>();
        subsequence(str, 0, "", res);
        System.out.println("res:" + res.size());
        return res;
    }

    private static void subsequence(String s, int i, String sub, ArrayList<String> res) {
        if (i == s.length()) {
            res.add(sub);
        } else {
            subsequence(s, i + 1, sub + s.charAt(i), res);
            subsequence(s, i + 1, sub, res);
        }
    }
}
