package com.leetcode.dsajava.course.common_50_probs;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval_43 {

    public static void main(String[] args) {
        System.out.println();
    }

    // Section 43:
    // Time: O(n), Space: O(2n + 2) = O(n)
    public int[][] insertInterval(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
//        if(n == 0 || newInterval.length == 0)   return intervals;
        if (newInterval.length == 0) return intervals;
        int i = 0;
        List<int[]> res = new ArrayList<>();

        while (i < n && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i]);
            i++;
        }

        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        res.add(newInterval);
        while (i < n) {
            res.add(intervals[i]);
            i++;
        }

        return (int[][]) res.toArray();
/*        int[][] result = (int[][]) res.toArray();
        i = 0;
        for (int[] arr : res) {
            result[i++] = arr;
        }*/
    }
}
