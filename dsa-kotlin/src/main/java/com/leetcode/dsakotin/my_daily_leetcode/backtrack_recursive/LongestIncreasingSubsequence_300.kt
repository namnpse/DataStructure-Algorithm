package com.leetcode.dsakotin.my_daily_leetcode.backtrack_recursive

import kotlin.math.max

fun main() {
    val res = lengthOfLIS(intArrayOf(10,9,2,5,3,7,101,18))
    println(res)
}

// C1: backtrack
// Time: O(2^n)
fun lengthOfLIS2(nums: IntArray): Int {
    val memoiz = mutableMapOf<String, Int>()
    return lengthOfLIS(nums, 0, Int.MIN_VALUE, memoiz)
}

fun lengthOfLIS(nums: IntArray, i: Int, previous: Int, memoiz: MutableMap<String, Int>): Int {
    if (i == nums.size) return 0
    val key = "$i"
    if (memoiz[key] != null) return memoiz[key]!!
    if (nums[i] <= previous) {
        val res = lengthOfLIS(nums, i + 1, previous, memoiz)
        memoiz[key] = res
        return res
    } // not take it
    else {
        val max = max(
            1 + lengthOfLIS(nums, i + 1, nums[i], memoiz), // take it
            lengthOfLIS(nums, i + 1, previous, memoiz)  // not take it
        )
        memoiz[key] = max
        return max
    }
}

// C2: DP
// Time: O(n^2), Space; O(n)
fun lengthOfLIS(nums: IntArray): Int {
    val n = nums.size
    if(n < 2)   return n
    val dp: Array<Int> = Array(n) { 0 }
    var maxLength = 0
    for (i in nums.indices) {
        var tempMaxLength = 0
        for (j in 0 until i) {
            if(nums[j] < nums[i]) {
                tempMaxLength = max(tempMaxLength, dp[j])
            }
        }
        dp[i] = tempMaxLength + 1
        maxLength = max(maxLength, dp[i])
    }
    return maxLength
}

// C3:
// Time: O(n*logn), Space: O(n)
fun lengthOfLIS3(nums: IntArray): Int {
    val n = nums.size
    if(n < 2)   return n
    val subsequence = arrayListOf<Int>()
    subsequence.add(nums[0])
    for (i in 1 until n) {
        if(nums[i] < subsequence.first()) {
            subsequence[0] = nums[i]
        } else if(nums[i] > subsequence.last()) {
            subsequence.add(nums[i])
        } else {
            val nextGreaterIndex = findNextGreaterIndex(subsequence, nums[i])
            subsequence[nextGreaterIndex] = nums[i]
        }
    }
    return subsequence.size
}

// binary search
fun findNextGreaterIndex(nums: ArrayList<Int>, num: Int): Int {
    var left = 0
    var right = nums.size
    while (left < right - 1) {
        val mid = (left + right) / 2
        if(nums[mid] > num)    right = mid
        else if(nums[mid] < num)    left = mid
        else return mid
    }
    return right
}
