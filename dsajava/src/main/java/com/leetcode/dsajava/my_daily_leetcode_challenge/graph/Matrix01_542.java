package com.leetcode.dsajava.my_daily_leetcode_challenge.graph;

import java.util.LinkedList;
import java.util.Queue;

public class Matrix01_542 {

    public static void main(String[] args) {

    }

    // BFS, bfs
    public static int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) queue.add(new Pair<>(i, j)); // keep track of all 0's
                else mat[i][j] = Integer.MAX_VALUE; // else initialize distance to infinity
            }
        }
        int[][] directions = new int[][]{
                {-1, 0}, {1, 0}, {0, -1}, {0, 1},
        };
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> top = queue.poll();
            for (int[] d : directions) {
                int di = top.first + d[0];
                int dj = top.second + d[1];
                if (di < 0 || di >= m || dj < 0 || dj >= n || // if new cell is out of bounds
                        mat[di][dj] <= mat[top.first][top.second] + 1 // or is already closer to another 0, stop further bfs in this cell
                ) continue;

                queue.add(new Pair<>(di, dj)); // put in queue for further bfs operations
                mat[di][dj] = mat[top.first][top.second] + 1; // update new smaller distance
            }
        }
        return mat;
    }
}
