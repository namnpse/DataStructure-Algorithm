package com.leetcode.dsajava.my_daily_leetcode_challenge.array;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval_57 {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
//        if(n == 0 || newInterval.length == 0)   return intervals;
        if(newInterval.length == 0)   return intervals;
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
    }
}
