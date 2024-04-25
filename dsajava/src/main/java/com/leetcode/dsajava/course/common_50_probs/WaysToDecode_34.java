package com.leetcode.dsajava.course.common_50_probs;

import java.util.HashMap;
import java.util.Map;

public class WaysToDecode_34 {

    public static void main(String[] args) {
        String str = "00243430";
        System.out.println(waysToDecode(str));
    }

    // Section 34:
    public static int waysToDecode(String str) {
        Map<Integer, Integer> memoization = new HashMap<>();
        return waysToDecode(str, 0, memoization);
    }

    private static int waysToDecode(String str, int i, Map<Integer, Integer> memoization) {
        if (memoization.get(i) != null) return memoization.get(i);
        int n = str.length();
        if (n == 0 || (i < n && str.charAt(i) == '0')) return 0;
        if (i >= n - 1) return 1;
//        Integer number = Integer.parseInt(String.valueOf(str.charAt(i) + str.charAt(i+1)));
        int number = Integer.parseInt(str.substring(i, i + 2)); // str[i] + str[i+1]
        if (10 <= number && number <= 26) { // 2 ways of decoding
            int ways = waysToDecode(str, i + 1, memoization) // take 1 character
                    + waysToDecode(str, i + 2, memoization); // take 2 characters
            memoization.put(i, ways);
            return ways;
        }
        int ways = waysToDecode(str, i + 1, memoization);
        memoization.put(i, ways);
        return ways; // take 1 character
    }
}
