package com.leetcode.dsakotin.my_daily_leetcode

import kotlin.math.max
import kotlin.math.min

fun main() {
    val res = insert(
        arrayOf(
            intArrayOf(1, 2),
            intArrayOf(3, 4),
            intArrayOf(10, 20),
        ),
        intArrayOf(3, 10)
    )
    println(res)
}

fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
    val n = intervals.size
    if (newInterval.isEmpty()) return intervals
    var i = 0
    val res = arrayListOf<IntArray>()
    while (i < n && intervals[i][1] < newInterval[0]) {
        res.add(intervals[i])
        i++
    }
    while (i < n && intervals[i][0] <= newInterval[1]) {
        newInterval[0] = min(intervals[i][0], newInterval[0])
        newInterval[1] = max(intervals[i][1], newInterval[1])
        i++
    }
    res.add(newInterval)
    while (i < n) {
        res.add(intervals[i++])
    }
    val result = arrayOfNulls<IntArray>(res.size)
    i = 0
    res.forEach { result[i++] = it }
    return result.requireNoNulls()
}