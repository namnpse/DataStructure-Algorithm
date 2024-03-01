package com.leetcode.dsajava.my_daily_leetcode_challenge.dynamic_programming;

import java.util.Arrays;

public class MinimumPathSum_64 {

    public static void main(String[] args) {

    }

    public static int minPathSum(int[][] grid) {
        /* Wrong
            1 3 1
            1 6 2
            4 6 3

            Correct
            1 4 5
            2 7 6
            6 8 7
        */
        int n = grid.length;
        int m = grid[0].length;
        int[][] sum = new int[n][m];

        sum[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) sum[0][i] = grid[0][i] + sum[0][i-1];
        for (int i = 1; i < n; i++) sum[i][0] = grid[i][0] + sum[i-1][0];

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                sum[i][j] = Math.min(sum[i - 1][j], sum[i][j - 1]) + grid[i][j];
            }
        }

       /* for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(sum[i]));
        }*/

        return sum[n - 1][m - 1];
    }
}
