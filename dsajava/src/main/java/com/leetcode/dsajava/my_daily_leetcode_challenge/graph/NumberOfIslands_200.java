package com.leetcode.dsajava.my_daily_leetcode_challenge.graph;

public class NumberOfIslands_200 {

    public static void main(String[] args) {

    }

    public static int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(i, j, grid);
                }
            }
        }
        return count;
    }

    private static void dfs(int i, int j, char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1
                || grid[i][j] != '1'
        ) return;
        grid[i][j] = '0'; // mark as visited, no need an extra array
        dfs(i - 1, j, grid);
        dfs(i + 1, j, grid);
        dfs(i, j - 1, grid);
        dfs(i, j + 1, grid);
    }
}
