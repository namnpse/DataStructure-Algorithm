package com.leetcode.dsajava.my_daily_leetcode_challenge.graph;

public class NumberOfProvinces_547 {

    public static void main(String[] args) {

    }

    static int provinces = 0;
    static boolean[] visited;
    public static int findCircleNum(int[][] isConnected) {
        visited = new boolean[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            if(!visited[i]) {
                provinces++;
                dfs(i, isConnected);
            }
        }
        return provinces;
    }

    private static void dfs(int i, int[][] isConnected) {
//        if(i < 0 || i >= isConnected.length || j < 0 || j >= isConnected[0].length
//                || isConnected[i][j] != 1
//        ) return;
        if(visited[i])  return;

        visited[i] = true;
        for (int k = 0; k < isConnected[0].length; k++) {
            if (isConnected[i][k] == 1) {
                dfs(k, isConnected);
            }
        }
//        dfs(i-1, j, isConnected);
//        dfs(i+1, j, isConnected);
//        dfs(i, j-1, isConnected);
//        dfs(i, j+1, isConnected);
    }
}
