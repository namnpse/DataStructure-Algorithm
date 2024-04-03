package com.leetcode.dsajava.course.common_50_probs;

import com.leetcode.dsajava.my_daily_leetcode_challenge.graph.Graph;

public class GraphDFS_24 {

    // Section 24: Graph DFS
    // O(V+2E), Space: O(V): print V vertex
    static boolean[] visited;

    public static void main(String[] args) {
        System.out.println();
    }

    public static void dfs(Graph graph, int root) {
        if (visited == null) {
            visited = new boolean[graph.adjList.size()];
        }
        if (visited[root]) return;
        visited[root] = true;
        System.out.println(root);
        for (Integer vertex : graph.adjList.get(root)) {
            dfs(graph, vertex);
        }
    }
}
