package com.leetcode.dsakotin.my_daily_leetcode.dp

import kotlin.math.min


fun main() {

}

fun coinChange(coins: IntArray, amount: Int): Int {
    val MAX_VALUE = Int.MAX_VALUE/2
//    val dp = arrayOfNulls<Int>(amount+1).requireNoNulls() // for non-primitive
    val dp = IntArray(amount+1) // for primitive
//    for (i in 1 until amount+1) dp[i] = MAX_VALUE
//    (1..amount).forEach { index -> dp[index] = MAX_VALUE } // not necessary
    dp[0] = 0
    (1..amount).forEach { i ->
        var min = MAX_VALUE
        coins.forEach { coin ->
            if(i - coin >= 0) {
                min = min(min, 1 + dp[i-coin])
            }
        }
        dp[i] = min
    }
    return if(dp[amount] == MAX_VALUE) -1 else dp[amount]
}