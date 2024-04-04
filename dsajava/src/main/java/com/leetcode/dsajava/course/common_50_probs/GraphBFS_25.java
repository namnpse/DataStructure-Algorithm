package com.leetcode.dsajava.course.common_50_probs;

import com.leetcode.dsajava.my_daily_leetcode_challenge.graph.Graph;

import java.util.Queue;

public class GraphBFS_25 {

    // Section 25: Graph BFS
    public void bfs(Graph graph, int root) {
        boolean[] visited = new boolean[graph.adjList.size()];
        Queue<Integer> queue = new java.util.LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int top = queue.poll();
            System.out.println(top);
            visited[top] = true;
            for (Integer vertex : graph.adjList.get(top)) {
                if (!visited[vertex]) {
                    queue.add(vertex);
                }
            }
        }
    }
}
