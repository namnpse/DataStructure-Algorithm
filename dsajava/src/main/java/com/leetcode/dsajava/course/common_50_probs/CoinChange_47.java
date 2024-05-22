package com.leetcode.dsajava.course.common_50_probs;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CoinChange_47 {

    // Section 47:
    public static int coinChange(int amount, Set<Integer> coins) {
        int MAX_VALUE = Integer.MAX_VALUE / 2;
        Map<Integer, Integer> memoiz = new HashMap<>();
        int res = coinChange(amount, coins, memoiz);
        return res == MAX_VALUE ? -1 : res;
    }

    public static int coinChange(int amount, Set<Integer> coins, Map<Integer, Integer> memoiz) {
        if (amount == 0) return 0;
        if (memoiz.containsKey(amount)) return memoiz.get(amount);
        int min = Integer.MAX_VALUE / 2;
        for (Integer coin : coins) {
            if (amount - coin >= 0) {
                min = Math.min(min, 1 + coinChange(amount - coin, coins, memoiz));
            }
        }
        memoiz.put(amount, min);
        return min;
    }
}
