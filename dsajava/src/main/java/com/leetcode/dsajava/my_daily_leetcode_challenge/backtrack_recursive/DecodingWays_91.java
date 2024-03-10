package com.leetcode.dsajava.my_daily_leetcode_challenge.backtrack_recursive;

import java.util.HashMap;
import java.util.Map;

public class DecodingWays_91 {

    public int numDecodings(String s) {
        Map<Integer, Integer> memoization = new HashMap<>();
        return numDecodings(s, 0, memoization);
    }

    private int numDecodings(String s, int i, Map<Integer, Integer> memoization) {
        if(memoization.get(i) != null)  return memoization.get(i);
        int n = s.length();
        if (n == 0 || (i < n && s.charAt(i) == '0')) return 0;
        if (i >= n - 1) return 1;
        Integer number = Integer.parseInt(s.substring(i, i + 2));
        if (10 <= number && number <= 26) {
            int ways = numDecodings(s, i + 1, memoization)
                    + numDecodings(s, i + 2, memoization);
            return ways;
        }
        int ways = numDecodings(s, i + 1, memoization);
        return ways;
    }
}
