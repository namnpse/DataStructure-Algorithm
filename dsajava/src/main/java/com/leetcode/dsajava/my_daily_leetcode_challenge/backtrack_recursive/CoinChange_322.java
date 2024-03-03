package com.leetcode.dsajava.my_daily_leetcode_challenge.backtrack_recursive;

import java.util.HashMap;
import java.util.Map;

public class CoinChange_322 {

    public static void main(String[] args) {
        int amount = 15;
        int[] coins = new int[]{2, 3, 7};
        System.out.println("res: " + coinChange(coins, amount));
    }

    public static int coinChange(int[] coins, int amount) {
        Map<Integer, Integer> memoiz = new HashMap<>();
        int res = backtrack(coins, amount, memoiz);
        if (res == Integer.MAX_VALUE / 2) return -1;
        return res;
    }

    public static int backtrack(int[] coins, int amount, Map<Integer, Integer> memoiz) {
        if (amount == 0) return 0;
        if (memoiz.get(amount) != null) return memoiz.get(amount);
        int min = Integer.MAX_VALUE / 2;
        for (int coin : coins) {
            if (amount - coin >= 0) {
                min = Math.min(min, 1 + backtrack(coins, amount - coin, memoiz));
            }
        }
        memoiz.put(amount, min);
        return min;
    }
}
