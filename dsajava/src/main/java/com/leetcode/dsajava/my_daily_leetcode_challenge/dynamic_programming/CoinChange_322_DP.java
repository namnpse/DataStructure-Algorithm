package com.leetcode.dsajava.my_daily_leetcode_challenge.dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class CoinChange_322_DP {

    // 2 ways
    public static void main(String[] args) {
        int amount = 15;
        int[] coins = new int[]{2,3,7};
        System.out.println("res: "+coinChange(coins, amount));
    }

    // C2: DP
    // Time: O(m*n), Space: O(m) (m = amount, n = coins.length)
    public static int coinChange(int[] coins, int amount) {
        int MAX_VALUE = Integer.MAX_VALUE/2;
        int[] dp = new int[amount+1];
        dp[0] = 0;
//        for (int i = 1; i <= amount; i++) dp[i] = MAX_VALUE; // not necessary

        for (int i = 1; i <= amount; i++) {
            int min = MAX_VALUE;
            for (int coin : coins){
                if(i-coin >= 0) {
                    min = Math.min(min, 1 + dp[i-coin]);
                }
            }
            dp[i] = min;
        }

        return dp[amount] == MAX_VALUE ? -1 : dp[amount];
    }
}
