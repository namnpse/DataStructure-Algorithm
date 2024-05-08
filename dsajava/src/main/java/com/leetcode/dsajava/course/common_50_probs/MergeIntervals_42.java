package com.leetcode.dsajava.course.common_50_probs;

import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals_42 {

    // Section 42:
    // Time: O(nlogn+n+n), Space: O(2n)
    public int[][] mergeIntervals(int[][] intervals) {
        int n = intervals.length;
        int[][] sortedIntervals = (int[][]) Arrays.stream(intervals).sorted(Comparator.comparingInt(arr -> arr[0])).toArray();
        for (int i = 0; i < n - 1; i++) {
            if (sortedIntervals[i][1] >= sortedIntervals[i + 1][0]) { //  end of i >= start of i+1 -> overlapped -> merge
                sortedIntervals[i + 1][0] = intervals[i][0];
                sortedIntervals[i + 1][1] = Math.max(sortedIntervals[i][1], sortedIntervals[i + 1][1]);
                sortedIntervals[i] = new int[]{};
            }
        }
        return (int[][]) Arrays.stream(sortedIntervals).filter((arr) -> arr.length > 0).toArray();
    }
}
